package example.chapter02.knobble04;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/8/1 0001.
 */
public class ProgressBarActivity extends Activity {

    private Button progrDiaCirBtn;
    private Button progrDiaHorBtn;
    private int currentCount;
    private int count;
    private ProgressBar progressbarHor;//水平风格进度条

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        设置窗口特征：启用显示进度的进度条
        requestWindowFeature(Window.FEATURE_PROGRESS);
//        设置窗口特征：启用不显示进度的进度条
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.progressbar);
        progrDiaCirBtn = (Button) findViewById(R.id.progress_dialog_circle_btn);
        progrDiaHorBtn = (Button) findViewById(R.id.progress_dialog_hor_btn);
        progressbarHor = (ProgressBar) findViewById(R.id.progressbar_hor);
        progressBarHor();
        progressDialogCircle();
        progressDialogHor();

        example();

    }

    /**
     * 实例：显示在标题上的进度条
     */
    private void example() {
        Button show = (Button) findViewById(R.id.show_btn);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                设置不带进度的进度条显示
                setProgressBarIndeterminateVisibility(true);
//                设置带进度的进度条显示
                setProgressBarVisibility(true);
                setProgress(4500);
            }
        });
        Button hide = (Button) findViewById(R.id.hide_btn);
        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                设置不带进度的进度条隐藏
                setProgressBarIndeterminateVisibility(false);
//                设置带进度的进度条隐藏
                setProgressBarVisibility(false);
            }
        });
    }

    /**
     * 水平进度条
     */
    private void progressBarHor() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                progressbarHor.setProgress(count++);
                if (count > 100) count = 0;
            }
        }, 0, 100);
    }
//    下载文件进度条实现思路：
//    设计一个定时任务，每隔一定的时间获取当前已经下载的文件大小，已经下载文件/文件的总大小 = 当前下载文件的进度百分比
//    把百分比的值传到 setProgress 中

    /**
     * 水平hor风格进度条
     */
    private void progressDialogHor() {
        progrDiaHorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog dialog = new ProgressDialog(ProgressBarActivity.this);
                dialog.setTitle("提示");
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setMessage("这是一个水平风格的进度条");
                dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                dialog.setProgress(100);//设置进度条进度
                dialog.setIndeterminate(false);//设置进度条是否不明确
                dialog.setCancelable(false);
                dialog.show();
//                模拟定时更新progress进度 方法一：
//                new Thread() {
//                    @Override
//                    public void run() {
//                        super.run();
//                        int count = 0;
//                        try {
//                            while (count <= 100) {
//                                dialog.setProgress(count++);
//                                Thread.sleep(100);
//                            }
//                            dialog.cancel();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                            dialog.cancel();
//                        }
//                    }
//                }.start();

//                模拟定时更新progress进度 方法二：
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        dialog.setProgress(currentCount++);
                        if (currentCount > 100) dialog.cancel();
                    }
                }, 0, 100);
            }
        });
    }

    /**
     * 圆形Dialog风格进度条
     */
    private void progressDialogCircle() {
        progrDiaCirBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progressDialog = new ProgressDialog(ProgressBarActivity.this);
                progressDialog.setTitle("提示");
                progressDialog.setMessage("正在加载...");
                progressDialog.setIcon(R.mipmap.ic_launcher);
                //设置按下back键是否可以取消progressDialog显示
                progressDialog.setCancelable(true);
                progressDialog.setButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        点击确定取消对话框
                        progressDialog.dismiss();
                    }
                });
                progressDialog.show();
            }
        });
    }

    public static void actionStart(Context context) {
        context.startActivity(new Intent(context, ProgressBarActivity.class));
    }
}
