package simple.s2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import simple.s2.s5.R;

/**
 * 播放视频
 */
public class VideoActivity extends AppCompatActivity implements View.OnClickListener {

    private Button play, pause, replay;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        init();

        String videoPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/huge.mp4";
        videoView.setVideoPath(videoPath);
    }

    private void init() {
        play = (Button) findViewById(R.id.video_play);
        pause = (Button) findViewById(R.id.video_pause);
        replay = (Button) findViewById(R.id.video_replay);
        videoView = (VideoView) findViewById(R.id.video_view);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        replay.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.video_play:
                if (!videoView.isPlaying()) {
                    videoView.start();//开始播放
                }
                break;
            case R.id.video_pause:
                if (videoView.isPlaying()) {
                    videoView.pause();//暂停播放
                }
                break;
            case R.id.video_replay:
                if (videoView.isPlaying()) {
                    videoView.resume();//重新播放
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoView != null) {
            videoView.suspend();//将 VideoView 所占用的资源释放掉
        }
    }

    public static void actionStart(Context context) {
        context.startActivity(new Intent(context,VideoActivity.class));
    }
}
