package example.lyw.com.longrouter;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author Liuyewu
 * @date 2018/11/21
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.openDebug();
        ARouter.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ARouter.getInstance().destroy();
    }
}
