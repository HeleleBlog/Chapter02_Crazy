package simple.s2.s5.popupwindow;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import simple.s2.s5.R;

public class PopupWindowActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn01,btn02;
    PopupWindow popupwindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);
        btn01 = (Button) findViewById(R.id.popupwindow_btn01);
        btn02 = (Button) findViewById(R.id.popupwindow_btn02);
        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
    }

    public static void actionStart(Context context) {
        context.startActivity(new Intent(context,PopupWindowActivity.class));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.popupwindow_btn01:
                showPopupWindow();
                break;
            case R.id.popupwindow_btn02:
                ShowAsDropDown.actionStart(this);
                break;
            case R.id.pop_computer_01:
                Toast.makeText(PopupWindowActivity.this, "clicked computer", Toast.LENGTH_SHORT).show();
                popupwindow.dismiss();
                break;
            case R.id.pop_financial_01:
                Toast.makeText(PopupWindowActivity.this, "clicked financial", Toast.LENGTH_SHORT).show();
                popupwindow.dismiss();
                break;
            case R.id.pop_manage_01:
                Toast.makeText(PopupWindowActivity.this, "clicked manager", Toast.LENGTH_SHORT).show();
                popupwindow.dismiss();
                break;
        }
    }

    private void showPopupWindow() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.popop_window_01,null);
        popupwindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);
        popupwindow.setContentView(contentView);
//        设置各个控件的点击响应
        TextView tv1 = (TextView) contentView.findViewById(R.id.pop_computer_01);
        TextView tv2 = (TextView) contentView.findViewById(R.id.pop_financial_01);
        TextView tv3 = (TextView) contentView.findViewById(R.id.pop_manage_01);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
//        显示PopupWindow
        View rootview = LayoutInflater.from(this).inflate(R.layout.activity_popup_window,null);
//        将PopupWindow的实例放在一个父容器中，然后显示在父容器的指定位置。
        popupwindow.showAtLocation(rootview, Gravity.BOTTOM,0,0);
    }
}
