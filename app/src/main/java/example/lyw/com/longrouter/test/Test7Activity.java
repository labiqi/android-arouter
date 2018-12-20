package example.lyw.com.longrouter.test;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import example.lyw.com.longrouter.Constants;
import example.lyw.com.longrouter.R;
import example.lyw.com.module2.filter.BaseActivity;

@Route(path = Constants.ROUTRE_TEST7)
public class Test7Activity extends BaseActivity {
    private Button btn1;
    private Button btn6;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test7);

        initView();
        initData();
        setTitle("第二个长路由起点页面");
    }

    public void onClick(View view) {
        finish();
    }

    private void initView(){
        btn1 = (Button) findViewById(R.id.button1);
        btn6 = (Button) findViewById(R.id.button6);
        tv = (TextView) findViewById(R.id.tv1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("from","从Test7跳转来");
                ARouter.getInstance().build(Constants.ROUTRE_TEST2)
                        .with(bundle)
                        .navigation();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("from_long","单模块长路由跳转");
                Uri uri = Uri.parse(Constants.ROUTRE_URI_TEST6);
                ARouter.getInstance().build(uri)
                        .with(bundle)
                        .navigation();
            }
        });
    }

    private void initData(){
        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        String from = bundle.getString("from");
        String from_long = bundle.getString("from_long");
        tv.setText(from + "   " +from_long);
    }
}
