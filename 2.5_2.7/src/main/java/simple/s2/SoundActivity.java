package simple.s2;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import simple.s2.s5.R;

public class SoundActivity extends AppCompatActivity implements View.OnClickListener {
    private String TAG = "SoundActivity";
    private Button play, pause, stop;
    private MediaPlayer mediaPlayer = new MediaPlayer();

    public static final String DM_TARGET_FOLDER = File.separator + "AA" + File.separator; //下载管理目标文件夹

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);
        play = (Button) findViewById(R.id.sound_play);
        pause = (Button) findViewById(R.id.sound_pause);
        stop = (Button) findViewById(R.id.sound_stop);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
//        createmidr();
        test();
//        initMediaPlayer();
    }

    private void test() {

        //初始化目标Download保存目录
        String folder = Environment.getExternalStorageDirectory() + DM_TARGET_FOLDER;
        if (!new File(folder).exists()) {
            boolean flag = new File(folder).mkdirs();
            if (flag) {
                Log.e(TAG, "创建成功");
            }
            else {
                Log.e(TAG, "创建失败");
            }
        }
    }

    private void initMediaPlayer() {
        try {
            // 判断SD卡是否存在，并且本程序是否拥有SD卡的权限
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
//            需要读写权限，如果是删除文件还需要删除权限。
//            getExternalStorageDirectory()来获得SD卡的根目录
                File file = new File(Environment.getExternalStorageDirectory().getAbsoluteFile(), File.separator + "a.mp3");
//            File file = new File(Environment.getRootDirectory().getParentFile().getAbsoluteFile(), "/a.mp3");
//            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC), "/a.mp3");
                if (file.exists()) {
                    mediaPlayer.setDataSource(file.getPath());//指定音频文件的路径
                    mediaPlayer.prepare();//MediaPlayer进入到准备状态
                    Toast.makeText(this, "文件存在", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "文件没有找到", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createmidr() {
//        判断sdcard是否插入
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            String rootImage = Environment.getExternalStorageDirectory() + File.separator + "AAA" + File.separator + "Image";
            String rootVoice = Environment.getExternalStorageDirectory() + File.separator + "AAA" + File.separator + "Voice";
            File imageFile = new File(rootImage);
            if (!imageFile.exists()) {
                imageFile.mkdirs();
            }
            File voiceFile = new File(rootVoice);
            if (!voiceFile.exists()) {
                voiceFile.mkdirs();
            }

        }
    }

    public static void actionStart(Context context) {
        context.startActivity(new Intent(context, SoundActivity.class));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sound_play:
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();//开始播放
                }
                break;
            case R.id.sound_pause:
                if (mediaPlayer.isPlaying())
                    mediaPlayer.pause();//暂停播放
                break;
            case R.id.sound_stop:
                if (mediaPlayer.isPlaying())
                    mediaPlayer.stop();//停止播放
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }
}
