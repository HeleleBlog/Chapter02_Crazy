package example.chapter02.knobble04;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

/**
 * Created by Administrator on 2016/8/2 0002.
 * 拖动条
 */
public class SeekBarActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seekbar);
        final SeekBar seekbar = (SeekBar) findViewById(R.id.seekbar);
        final ImageView img = (ImageView) findViewById(R.id.img);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            当拖动条滑块的位置发生改变时触发此方法
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                img.setAlpha(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public static void actionStart(Context context) {
        context.startActivity(new Intent(context,SeekBarActivity.class));
    }
}
