package simple.s2.s5.popupwindow;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import simple.s2.s5.R;

public class ShowAsDropDown extends AppCompatActivity implements View.OnClickListener {

    private PopupWindow popupWindow;
    private TextView menu;
    private View contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_as_drop_down);
        menu = (TextView) findViewById(R.id.menu);
        menu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menu:
                showPopupWindow();
                break;
            case R.id.pop_computer_02:
                Toast.makeText(ShowAsDropDown.this, "Clicked computer", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
                break;
            case R.id.pop_financial_02:
                Toast.makeText(ShowAsDropDown.this, "Clicked financial", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
                break;
            case R.id.pop_manage_02:
                Toast.makeText(ShowAsDropDown.this, "Clicked manager", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
                break;
        }
    }

    private void showPopupWindow() {
        if(contentView == null){
            contentView = LayoutInflater.from(this).inflate(R.layout.popop_window_02,null);

            popupWindow = new PopupWindow(contentView);
            popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
            popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);

//          外部是否可以点击
            popupWindow.setBackgroundDrawable(new BitmapDrawable());//加上此行代码，setOutsideTouchable（）才会生效;并且，点击手机的返回按钮，可以关闭PopupWindow，如果不加此行代码，点击back键则会关闭PopupWindow所在的Activity
//            setOutsideTouchable(boolean touchable) 指PopupWindow以外的区域是否可点击，即如果点击PopupWindow以外的区域，PopupWindow是否会消失。
            popupWindow.setOutsideTouchable(true);

            TextView textView1 = (TextView) contentView.findViewById(R.id.pop_computer_02);
            TextView textView2 = (TextView) contentView.findViewById(R.id.pop_financial_02);
            TextView textView3 = (TextView) contentView.findViewById(R.id.pop_manage_02);
            textView1.setOnClickListener(this);
            textView2.setOnClickListener(this);
            textView3.setOnClickListener(this);
            
            popupWindow.setAnimationStyle(R.style.contextMenuAnim);

            popupWindow.showAsDropDown(menu);
        }else{
            popupWindow.showAsDropDown(menu);
        }
    }

    public static void actionStart(Context context) {
        context.startActivity(new Intent(context,ShowAsDropDown.class));
    }
}
