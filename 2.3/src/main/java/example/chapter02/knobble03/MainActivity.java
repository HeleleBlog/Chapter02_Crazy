package example.chapter02.knobble03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * 2.3 基本界面组件
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Integer> idBtnArr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 使用逻辑简化了初始化视图控件的代码
     */
    private void initView() {
        idBtnArr.add(R.id.view_01);
        idBtnArr.add(R.id.view_02);
        idBtnArr.add(R.id.view_04);
        idBtnArr.add(R.id.view_05);
        idBtnArr.add(R.id.view_06);
        idBtnArr.add(R.id.view_07);
        Button[] buttons = new Button[idBtnArr.size()];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = (Button) findViewById(idBtnArr.get(i));
            buttons[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.view_01:
                TextEditActivity.actionStart(MainActivity.this);
                break;
            case R.id.view_02:
                ButtonActivity.actionStart(MainActivity.this);
                break;
            case R.id.view_04:
                RadioBtnActivity.actionStart(MainActivity.this);
                break;
            case R.id.view_05:
                ToggleBtnActivity.actionStart(MainActivity.this);
                break;
            case R.id.view_06:
                ClockActivity.actionStart(MainActivity.this);
                break;
            case R.id.view_07:
                ImageViewActivity.actionStart(MainActivity.this);
                break;
        }
    }
}
