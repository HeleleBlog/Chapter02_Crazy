package simple.s2.s6;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import simple.s2.s5.R;

public class MessageHintActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv01, tv02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_hint);
        tv01 = (TextView) findViewById(R.id.notification_01);
        tv02 = (TextView) findViewById(R.id.notification_02);
        tv01.setOnClickListener(this);
        tv02.setOnClickListener(this);
    }

    public static void actionStart(Context context) {
        context.startActivity(new Intent(context, MessageHintActivity.class));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.notification_01:
                showNotification();
                break;
            case R.id.notification_02:
                showNotification2();
                break;
        }
    }

    private void showNotification2() {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("This is Title")
        .setContentText("This is Text")
                .setSmallIcon(R.mipmap.ic_launcher);
//        通知栏点击事件
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,new Intent(this,PendingIntentActivity.class),PendingIntent.FLAG_ONE_SHOT);
        builder.setContentIntent(pendingIntent);
//        通知到来时播放手机铃声
        playSystemSound();

        Notification notification = builder.build();

//        设置手机 静止_震动_静止_震动 的时长（控制手机震动需要声明权限）
//        long[] vibrates = {0,1000,1000,1000};
//        notification.vibrate = vibrates;
//
////        控制LED灯的显示，四个属性 ledARGB、ledOnMs、ledOffMs以及flags
//        notification.ledARGB = Color.BLUE;
//        notification.ledOnMS = 1000;
//        notification.ledOffMS = 1000;
//        notification.flags = Notification.FLAG_SHOW_LIGHTS;

//        通过下一行代码可以直接使用通知的默认效果
        notification.defaults = Notification.DEFAULT_ALL;

//        通过通知管理器发送通知
        manager.notify(1,notification);
    }

    /**
     * 播放手机铃声
     */
    private void playSystemSound() {
        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
        r.play();
    }

    private void showNotification() {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("This is Title")
                .setContentText("This is content text")
                .setWhen(System.currentTimeMillis())
                .setTicker("状态栏提示消息");
//        通知栏点击事件的处理
        Intent intent = new Intent(this, PendingIntentActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        builder.setContentIntent(pendingIntent);
//        通过通知管理器发送通知
        Notification notification = builder.build();
        manager.notify(1, notification);

    }
}
