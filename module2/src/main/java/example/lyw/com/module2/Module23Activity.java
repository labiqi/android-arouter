package example.lyw.com.module2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import example.lyw.com.module2.filter.BaseActivity;
import example.lyw.com.module2.filter.LongArouterManager;
@Route(path = Module2Constants.ROUTRE_MODULE23)
public class Module23Activity extends BaseActivity {

    private Button btn1;
    private Button btn2;
    private TextView taskId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module23);

        initView();
        initData();
        setTitle("Module23");
    }

    private void initView(){
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        taskId = (TextView) findViewById(R.id.taskIdTv);

        taskId.setText(getTaskId()+"");
    }

    private void initData(){
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("from","Module21跳转来");
                ARouter.getInstance().build(Module2Constants.ROUTRE_MODULE22)
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
}
