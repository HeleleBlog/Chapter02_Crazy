package example.chapter02.knobble03;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.ToggleButton;

/**
 * Created by Administrator on 2016/7/27 0027.
 * 2.3.5 状态开关按钮
 */
public class ToggleBtnActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toggle_btn_layout);
        ToggleButton toggleBtn = (ToggleButton) findViewById(R.id.toggle_btn);
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_layout);
        toggleBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    linearLayout.setOrientation(LinearLayout.VERTICAL);
                }else{
                    linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                }
            }
        });

        final Switch switchBtn = (Switch) findViewById(R.id.switch1);
        switchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    linearLayout.setOrientation(LinearLayout.VERTICAL);
                    switchBtn.setText("Switch On");
                }else{
                    linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                    switchBtn.setText("Switch Off");
                }
            }
        });
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context,ToggleBtnActivity.class);
        context.startActivity(intent);
    }
}
