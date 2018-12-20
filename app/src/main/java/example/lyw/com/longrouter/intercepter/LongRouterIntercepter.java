package example.lyw.com.longrouter.intercepter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

import example.lyw.com.longrouter.Constants;
import example.lyw.com.module1.Module1Constants;
import example.lyw.com.module2.Module2Constants;
import example.lyw.com.module2.filter.LongArouterManager;

/**
 * @author Liuyewu
 * @date 2018/11/21
 */
@Interceptor(priority = 1)
public class LongRouterIntercepter implements IInterceptor{
    private Context mContext;
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        Uri uri =  postcard.getUri();
        if (uri!=null&&Constants.ROUTRE_URI_TEST2.equals(uri.toString())) {
            Bundle bundle = postcard.getExtras();
            bundle.putString("long_url",Constants.ROUTRE_TEST7);
            LongArouterManager.startFrom(bundle,false);

            callback.onInterrupt(null);
        }if (uri!=null&&Constants.ROUTRE_URI_MODULE11.equals(uri.toString())) {
            Bundle bundle = postcard.getExtras();
            bundle.putString("long_url", Module1Constants.ROUTRE_MODULE11);
            LongArouterManager.startFrom(bundle,true);

            callback.onInterrupt(null);
        } if (uri!=null&&Constants.ROUTRE_URI_MODULE21.equals(uri.toString())) {
            Bundle bundle = postcard.getExtras();
            bundle.putString("long_url", Module2Constants.ROUTRE_MODULE21);
            LongArouterManager.startFrom(bundle,true);

            callback.onInterrupt(null);
        } else  if(uri!=null&&Constants.ROUTRE_URI_TEST6.equals(uri.toString())) {
            Bundle bundle = postcard.getExtras();
            bundle.putString("long_url",Constants.ROUTRE_TEST6);
            LongArouterManager.startFrom(bundle,false);
        } else{
                callback.onContinue(postcard);
            }

    }

    @Override
    public void init(Context context) {
        mContext = context;
    }
}
