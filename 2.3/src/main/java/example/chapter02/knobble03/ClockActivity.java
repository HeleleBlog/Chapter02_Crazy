package example.chapter02.knobble03;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/7/27 0027.
 */
public class ClockActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clock_layout);
    }


    public static void actionStart(Context context) {
        context.startActivity(new Intent(context,ClockActivity.class));
    }
}
