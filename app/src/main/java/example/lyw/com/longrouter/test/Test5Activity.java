package example.lyw.com.longrouter.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import example.lyw.com.longrouter.Constants;
import example.lyw.com.longrouter.R;
import example.lyw.com.module2.filter.BaseActivity;
import example.lyw.com.module2.filter.LongArouterManager;

@Route(path = Constants.ROUTRE_TEST5)
public class Test5Activity extends BaseActivity {
    private Button btn1;
    private Button btn2;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test5);

        initView();
        initData();
        setTitle("Test5");
    }

    private void initView(){
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        tv = (TextView) findViewById(R.id.tv1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("from","从Test5放回");
                ARouter.getInstance().build(Constants.ROUTRE_TEST1)
                        .withFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP)
                        .with(bundle)
                        .navigation();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LongArouterManager.returnFrom();
            }
        });
    }

    public void onClick(View view) {
        finish();
    }

    public void back(View view) {
        ARouter.getInstance().build(Constants.ROUTRE_TEST2)
                .withFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP)
                .navigation();
    }

    private void initData(){
        Bundle bundle = getIntent().getExtras();
        tv.setText(bundle.getString("from"));
    }
}
