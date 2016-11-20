package example.chapter02.knobble02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import example.chapter02.knobble02.view.DrawView;


/**
 * 2.2布局管理器
 */
public class LayoutManagerActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_manager);
        initView();
    }

    private void initView() {
        LinearLayout root = (LinearLayout) findViewById(R.id.root);
        final DrawView draw = new DrawView(this);
        //设置自定义组件的最大宽、高
        draw.setMinimumWidth(300);
        draw.setMinimumHeight(500);
        //为draw组件绑定Touch事件（OnTouchListener——监听触摸屏事件的监听器）
        draw.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //修改draw组件的currentX、currentY两个属性
                draw.currentX = motionEvent.getX();
                draw.currentY = motionEvent.getY();
                //通知draw重绘
                draw.invalidate();
                return true;
            }
        });
        root.addView(draw);
        Button linear_layout = (Button) findViewById(R.id.linear_layout);
        Button table_layout = (Button) findViewById(R.id.table_layout);
        Button frame_layout = (Button) findViewById(R.id.frame_layout);
        Button relative_layout = (Button) findViewById(R.id.relative_layout);
        linear_layout.setOnClickListener(this);
        table_layout.setOnClickListener(this);
        frame_layout.setOnClickListener(this);
        relative_layout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.linear_layout:
                intent = new Intent(LayoutManagerActivity.this,LinearLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.table_layout:
                intent = new Intent(LayoutManagerActivity.this, TableLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.frame_layout:
                intent = new Intent(LayoutManagerActivity.this,FrameLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.relative_layout:
                intent = new Intent(LayoutManagerActivity.this, RelativeLayoutActivity.class);
                startActivity(intent);
                break;
        }
    }
}
