package example.lyw.com.module2.filter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author Liuyewu
 * @date 2018/11/26
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        LongArouterManager.addActivity(this);
    }



    @Override
    public Intent getIntent() {
        Intent intent = super.getIntent();
        Bundle bundle = intent.getExtras();
        if(LongArouterManager.getInstance() != null){
            Bundle bundleTemp = LongArouterManager.getInstance().getBundle();
            if(bundleTemp != null){
                if(bundle == null){
                    bundle = new Bundle();
                }
                bundle.putAll(bundleTemp);
            }
        }
        if(bundle != null){
            intent.putExtras(bundle);
        }
        return intent;
    }
}
