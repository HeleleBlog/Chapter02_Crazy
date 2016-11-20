package example.chapter02.knobble04;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button autoCompTVBtn;//自动完成文本框
    private Button spinnerBtn;//下拉列表
    private Button dateTimePicker;//日期时间选择器
    private Button progressbar;//进度条
    private Button seekbar;//拖动条
    private Button ratingbar;//星级评分条
    private Button tabhost;//选项卡
    private Button listview;
    private Button scro;//滚动
    private Button expandable;//可展开的
    private Button gridview;//GridView
    private Button gallery;//画廊

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoCompTVBtn = (Button) findViewById(R.id.auto_comp_tv_Btn);
        spinnerBtn = (Button) findViewById(R.id.spinner_btn);
        dateTimePicker = (Button) findViewById(R.id.date_time_picker_btn);
        progressbar = (Button) findViewById(R.id.progressbar_btn);
        seekbar = (Button) findViewById(R.id.seekbar_btn);
        ratingbar = (Button) findViewById(R.id.ratingbar_btn);
        tabhost = (Button) findViewById(R.id.tabhost_btn);
        listview = (Button) findViewById(R.id.listView_listactivity_btn);
        scro = (Button) findViewById(R.id.scrollView_btn);
        expandable = (Button) findViewById(R.id.expandable_listview_btn);
        gridview = (Button) findViewById(R.id.gridView_imageswitch_btn);
        gallery = (Button) findViewById(R.id.gallery_btn);

        autoCompTVBtn.setOnClickListener(this);
        spinnerBtn.setOnClickListener(this);
        dateTimePicker.setOnClickListener(this);
        progressbar.setOnClickListener(this);
        seekbar.setOnClickListener(this);
        ratingbar.setOnClickListener(this);
        tabhost.setOnClickListener(this);
        listview.setOnClickListener(this);
        scro.setOnClickListener(this);
        expandable.setOnClickListener(this);
        gridview.setOnClickListener(this);
        gallery.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.auto_comp_tv_Btn:
                AutoCompTVActivity.actionStart(MainActivity.this);
                break;
            case R.id.spinner_btn:
                SpinnerActivity.actionStart(MainActivity.this);
                break;
            case R.id.date_time_picker_btn:
                DateTimePickerActivity.actionStart(MainActivity.this);
                break;
            case R.id.progressbar_btn:
                ProgressBarActivity.actionStart(MainActivity.this);
                break;
            case R.id.seekbar_btn:
                SeekBarActivity.actionStart(MainActivity.this);
                break;
            case R.id.ratingbar_btn:
                RatingBarActivity.actionStart(MainActivity.this);
                break;
            case R.id.tabhost_btn:
                TabHostActivity.actionStart(MainActivity.this);
                break;
            case R.id.listView_listactivity_btn:
                ListViewActivity.actionStart(MainActivity.this);
                break;
            case R.id.scrollView_btn:
                ScroActivity.actionStart(MainActivity.this);
                break;
            case R.id.expandable_listview_btn:
                ExpandableActivity.actionStart(this);
                break;
            case R.id.gridView_imageswitch_btn:
                GridViewActivity.actionStart(this);
                break;
            case R.id.gallery_btn:
                GalleryActivity.actionStart(this);
                break;
        }
    }
}
