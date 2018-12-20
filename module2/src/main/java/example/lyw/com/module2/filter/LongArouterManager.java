package example.lyw.com.module2.filter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Liuyewu
 * @date 2018/11/23
 */
public class LongArouterManager {
    private LongArouterManager(){}
    private static LongArouterManager instance;
    private static ArrayList<LongParam> params;
    private static Map<String,List<Activity>> activityMap;
    private final static String KEY = "activityMap";
    private static int taskId ;
    private static boolean temp;

    public static void addActivity(Activity act){
        if(instance == null || params == null ){
            return;
        }
        if(act.getTaskId()==taskId){
            return;
        }
        if(activityMap == null){
            activityMap = new HashMap();
        }
        String key = KEY + params.size();
        if(!activityMap.containsKey(key)){
            activityMap.put(key,new ArrayList<Activity>());
        }
        activityMap.get(key).add(act);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void finishActivitys(){
        if(instance == null || params == null || activityMap == null){
            return;
        }
        String key = KEY + params.size();
        if(!activityMap.containsKey(key)){
            return;
        }
        List<Activity> list = activityMap.get(key);
        activityMap.remove(key);
        int size = list.size();
        for (int i = 0;i < size;i++) {
            Activity act = list.get(i);
            if(act != null){
                if((i+1)==size){
                    act.finishAndRemoveTask();
                }else {
                    act.finish();
                }
            }
        }
        if(activityMap.size()==0){
            activityMap = null;
        }
    }

    public static void createrLongParamManager(){
        if(instance == null){
            synchronized (LongArouterManager.class){
                if(instance == null){
                    instance = new LongArouterManager();
                    params = new ArrayList<>();
                }
            }
        }
    }
    public static LongArouterManager getInstance(){
        return instance;
    }
    public synchronized void setTaskId(int id){
        taskId = id;
    }

    public synchronized void destroy(){
        if(params != null ){
            if(params.size()<=1){
                instance = null;
                params = null;
                taskId = 0;
            }else {
                params.remove(0);
            }
        }else {
            instance = null;
            taskId = 0;
        }
    }

    public synchronized void setBundle(Bundle value){
        if(params == null ){
            params = new ArrayList<>();
        }
        if(value == null){
            params.add(0,new LongParam());
        }else {
            params.add(0,new LongParam(value,temp));
            temp = true;
        }
    }

    public synchronized Bundle getBundle(){
        if(params != null && params.size()>0){
            LongParam param = params.get(0);
            return  param.isUseAll()? param.getBundle() : null;
        }else {
            return null;
        }
    }

    public synchronized Bundle getUserBundle(){
        if(params != null && params.size()>0){
            LongParam param = params.get(0);
            return param.getBundle();
        }else {
            return null;
        }
    }
    public static synchronized void startFrom(Bundle bundle, boolean isAll, Context context){
        temp = isAll;
        ARouter.getInstance().build("/com/filter")
                .withFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .with(bundle)
                .navigation((Activity) context,123);
    }
    public static synchronized void startFrom(Bundle bundle,boolean isAll){
        temp = isAll;
        ARouter.getInstance().build("/com/filter")
                .withFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .with(bundle)
                .navigation();
    }

    public static synchronized void startFrom(Bundle bundle){
        temp = true;
        ARouter.getInstance().build("/com/filter")
                .withFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .with(bundle)
                .navigation();
    }

    public static synchronized void returnFrom(){
//        if(instance == null){
//            return;
//        }
        ARouter.getInstance().build("/com/filter")
                .withFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP)
                .navigation();
    }
}
