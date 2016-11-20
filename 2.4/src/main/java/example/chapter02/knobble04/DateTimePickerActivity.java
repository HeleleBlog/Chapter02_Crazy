package example.chapter02.knobble04;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by Administrator on 2016/8/1 0001.
 */
public class DateTimePickerActivity extends Activity implements View.OnClickListener {

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private String TAG = DateTimePickerActivity.class.getSimpleName();
    private EditText show;//显示常规日期的控件
    private TextView datetv, timetv;//显示日期、时间的控件
    //    private TextView dialogShow;//显示dialog日期的控件
    private DatePicker datePicker;
    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_time_picker);
        initView();
        initData();

//        初始化DatePicker组件及监听器
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                Log.d(TAG, "onDateChanged  i: " + i);
                Log.d(TAG, "onDateChanged  i1: " + i1);
                Log.d(TAG, "onDateChanged  i2: " + i2);
                year = i;
                month = i1 + 1;
                day = i2;
//                显示日期、时间
                showDate(year, month, day, hour, minute);
            }
        });
//        为TimePicker指定监听器
//        timePicker.setVisibility(View.GONE);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                hour = i;
                minute = i1;
//                显示日期、时间
                showDate(year, month, day, hour, minute);
            }
        });
    }

    private void initData() {
        Calendar calendar = Calendar.getInstance();
        Log.d(TAG, "onCreate: " + calendar);
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);
        setDatetv();
        timetv.setText(hour + "/" + minute);
    }

    private void initView() {
        datePicker = (DatePicker) findViewById(R.id.date_picker);
        timePicker = (TimePicker) findViewById(R.id.time_picker);
//        dialogShow = (TextView) findViewById(R.id.dialog_selected_date_text);
        show = (EditText) findViewById(R.id.show);
        datetv = (TextView) findViewById(R.id.date_tv);
        timetv = (TextView) findViewById(R.id.time_tv);

        datetv.setOnClickListener(this);
        timetv.setOnClickListener(this);
    }

    /**
     * 显示时间
     *
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     */
    private void showDate(int year, int month, int day, int hour, int minute) {
        String date = "日期：" + year + "年" + month + "月" + day + "日" + hour + "时" + minute + "分";
        show.setText(date);
    }

    public static void actionStart(Context context) {
        context.startActivity(new Intent(context, DateTimePickerActivity.class));
    }

    @Override
    public void onClick(View view) {
        Context context = DateTimePickerActivity.this;
        switch (view.getId()) {
            case R.id.date_tv:
                new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        year = i;
                        month = i1 + 1;
                        day = i2;
                        setDatetv();
                    }
                }, year, month, day).show();
                break;
            case R.id.time_tv:
                new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        hour = i;
                        minute = i1;
                        timetv.setText(hour + ":" + minute);
                    }
                }, hour, minute, true).show();
                break;
        }
    }

    /**
     * 设置日期textview显示的文本
     */
    private void setDatetv() {
        datetv.setText(year + "/" + month + "/" + day);
    }
}
