package example.chapter02.knobble03;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
/**
 * Created by Administrator on 2016/7/27 0027.
 * 按钮与图片按钮
 */
public class ButtonActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_layout);
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context,ButtonActivity.class);
        context.startActivity(intent);
    }
}
