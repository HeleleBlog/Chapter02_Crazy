package simple.s2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import simple.s2.s5.DialogActivity;
import simple.s2.s5.R;
import simple.s2.s6.MessageHintActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View tv1;
    private View tv2;
    private View sound, video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.main_2_5);
        tv2 = findViewById(R.id.main_2_6);
        sound = findViewById(R.id.main_sound);
        video = findViewById(R.id.main_video);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        sound.setOnClickListener(this);
        video.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_2_5:
                DialogActivity.actionStart(MainActivity.this);
                break;
            case R.id.main_2_6:
                MessageHintActivity.actionStart(MainActivity.this);
                break;
            case R.id.main_sound:
                SoundActivity.actionStart(MainActivity.this);
                break;
            case R.id.main_video:
                VideoActivity.actionStart(this);
                break;
        }
    }
}
