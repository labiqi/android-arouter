package example.lyw.com.longrouter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends Activity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private TextView taskId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDate();
    }

    private void initView(){
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        taskId = (TextView) findViewById(R.id.taskIdTv);

        taskId.setText(getTaskId()+"");
    }

    private void initDate(){
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("from","正常跳转");
                ARouter.getInstance().build(Constants.ROUTRE_TEST1)
                        .with(bundle)
                        .navigation();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("from_long","单模块长路由跳转");
                Uri uri = Uri.parse(Constants.ROUTRE_URI_TEST2);
                ARouter.getInstance().build(uri)
                        .with(bundle)
                        .navigation();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("from","单模块长路由跳转");
                Uri uri = Uri.parse(Constants.ROUTRE_URI_MODULE21);
                ARouter.getInstance().build(uri)
                        .with(bundle)
                        .navigation();
//                ARouter.getInstance().build("/mod2/module21").navigation();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
