package example.chapter02.knobble02;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/7/26 0026.
 */
public class FrameLayoutActivity extends Activity {

    private int currentColor = 0;

    //定义一个颜色数组
    final int[] colors = new int[]{
            R.color.entry06,
            R.color.entry08,
            R.color.entry02,
            R.color.entry03,
            R.color.entry04,
            R.color.entry05,
            R.color.entry07
    };
    final int[] names = new int[]{
            R.id.view_01,
            R.id.view_02,
            R.id.view_03,
            R.id.view_04,
            R.id.view_05,
            R.id.view_06,
            R.id.view_07
    };
    TextView[] views = new TextView[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout);
        for (int i = 0; i < 7; i++) {
            views[i] = (TextView) findViewById(names[i]);
        }

        // 定义一个线程周期性的(每隔0.1s)改变currentColor的值
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                currentColor++;
                if (currentColor >= 6) currentColor = 0;
                Message msg = new Message();
                // 给该消息定义一个标识
                msg.what = 0x1122;
                handler.sendMessage(msg);
            }
        }, 0, 100);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            // 表明消息来自本程序
            if (msg.what == 0x1122) {
                // 依次改变7个TextView的背景色
                for (int i = 0; i < 7 - currentColor; i++) {
                    views[i].setBackgroundResource(colors[currentColor + 1]);
                }
                for (int i = 7 - currentColor, j = 0; i < 7; i++, j++) {
                    views[i].setBackgroundResource(colors[j]);
                }
            }
        }
    };
}
