package example.lyw.com.longrouter.test;

import android.app.Activity;
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

@Route(path = Constants.ROUTRE_TEST2)
public class Test2Activity extends BaseActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private TextView text;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        initView();
        initData();
        setTitle("Test2");
    }

    public void onClick(View view) {
        finish();
    }

    private void initView(){
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        text = (TextView) findViewById(R.id.text);
        tv = (TextView) findViewById(R.id.tv1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("from","从Test2跳转来");
                ARouter.getInstance().build(Constants.ROUTRE_TEST1)
                        .with(bundle)
                        .navigation();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("from","从Test2跳转来");
                ARouter.getInstance().build(Constants.ROUTRE_TEST3)
                        .with(bundle)
                        .navigation();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("from","从Test2跳转来");
                ARouter.getInstance().build(Constants.ROUTRE_TEST4)
                        .with(bundle)
                        .navigation();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("from","从Test2跳转来");
                ARouter.getInstance().build(Constants.ROUTRE_TEST5)
                        .with(bundle)
                        .navigation();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("from","从Test2跳转来");
                Uri uri = Uri.parse(Constants.ROUTRE_URI_MODULE11);
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
