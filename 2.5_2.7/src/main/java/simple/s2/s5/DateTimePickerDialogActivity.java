package simple.s2.s5;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DateTimePickerDialogActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView datePicker, timerPicker;
    private int year, month, day, hour, minute;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_picker_dialog);
        datePicker = (TextView) findViewById(R.id.date_picker_dialog);
        timerPicker = (TextView) findViewById(R.id.timer_picker_dialog);
        datePicker.setOnClickListener(this);
        timerPicker.setOnClickListener(this);
        calendar = Calendar.getInstance();
    }

    public static void actionStart(Context context) {
        context.startActivity(new Intent(context, DateTimePickerDialogActivity.class));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.date_picker_dialog:
//                创建一个DatePickerDailog对话框实例，并且将它显示出来。
                new DatePickerDialog(DateTimePickerDialogActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        Toast.makeText(DateTimePickerDialogActivity.this, i + "年" + (i1+1) + "月" + i2 + "日", Toast.LENGTH_SHORT).show();
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
                break;
            case R.id.timer_picker_dialog:
//                创建一个TimerPickerDialog对话框实例
                new TimePickerDialog(DateTimePickerDialogActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        Toast.makeText(DateTimePickerDialogActivity.this, i + "时" + i1 + "分", Toast.LENGTH_SHORT).show();
                    }
                }, Calendar.HOUR_OF_DAY, Calendar.MINUTE, true).show();
                break;
        }
    }
}
