package example.lyw.com.module1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import example.lyw.com.module2.filter.BaseActivity;

@Route(path = Module1Constants.ROUTRE_MODULE12)
public class Module12Activity extends BaseActivity {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module12);

        initView();
        initData();
        setTitle("module12");
    }

    private void initView(){
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        btn4 = (Button)findViewById(R.id.button4);
        btn5 = (Button)findViewById(R.id.button5);
        btn6 = (Button)findViewById(R.id.button6);
        tv = (TextView) findViewById(R.id.tv1);
        btn1.setVisibility(View.GONE);
        btn2.setVisibility(View.GONE);
        btn3.setVisibility(View.GONE);
        btn4.setVisibility(View.GONE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("from","从module12跳转来");
                ARouter.getInstance().build(Module1Constants.ROUTRE_TEST1)
                        .withFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        .with(bundle)
                        .navigation();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("from","从module12跳转来");
                ARouter.getInstance().build(Module1Constants.ROUTRE_TEST2)
                        .withFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        .with(bundle)
                        .navigation();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("from","从module12跳转来");
                ARouter.getInstance().build(Module1Constants.ROUTRE_TEST3)
                        .withFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        .with(bundle)
                        .navigation();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("from","从module12跳转来");
                ARouter.getInstance().build(Module1Constants.ROUTRE_TEST4)
                        .withFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        .with(bundle)
                        .navigation();
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("from","从module12跳转来");
                ARouter.getInstance().build(Module1Constants.ROUTRE_MODULE11)
                        .with(bundle)
                        .navigation();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("from","从module12跳转来");
                ARouter.getInstance().build(Module1Constants.ROUTRE_MODULE13)
                        .with(bundle)
                        .navigation();
            }
        });
    }

    private void initData(){
        tv.setText(getIntent().getStringExtra("from"));
    }
}
