package example.chapter02.knobble03;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/7/27 0027.
 * 2.3.4 单选按钮RaidoButton和复选框checkBox
 */
public class RadioBtnActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_btn_layout);

    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context,RadioBtnActivity.class);
        context.startActivity(intent);
    }
}
