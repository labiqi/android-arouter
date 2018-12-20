package example.lyw.com.module2.filter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.Window;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author Liuyewu
 * @date 2018/11/21
 */
@Route(path = "/com/filter")
public class JumpActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        ARouter.getInstance().inject(this);

        initData();
    }
    private void initData(){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle == null){
            return;
        }
        String url = bundle.getString("long_url");
        bundle.remove("long_url");

//        LongArouterManager.createrLongParamManager();
//        LongArouterManager.getInstance().setBundle(bundle);
//        LongArouterManager.getInstance().setTaskId(getTaskId());

        ARouter.getInstance().build(url)
                .with(bundle)
                .navigation();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        LongArouterManager.getInstance().destroy();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        finish();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void finish() {
//        LongArouterManager.finishActivitys();
        super.finish();
    }

}
