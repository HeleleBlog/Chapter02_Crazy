package example.chapter02.knobble04;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

/**
 * Created by Administrator on 2016/8/1 0001.
 */
public class AutoCompTVActivity extends Activity {

    String[] strArr = new String[]{
            "Android群英传 简化版",
            "Android群英传 第一版",
            "Android群英传 第二版",
            "Android群英传 第三版",
            "Android群英传 第四版",
            "Android群英传 第五版",
            "Android架构",
            "AndroidUI设计",
            "Android开发艺术探索"
    };
    private AutoCompleteTextView autoCompTV;//自动完成文本框

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_comp_tv);
        autoCompTV = (AutoCompleteTextView) findViewById(R.id.autocompletetextview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, strArr);
        autoCompTV.setAdapter(adapter);
    }

    public static void actionStart(Context context) {
        context.startActivity(new Intent(context, AutoCompTVActivity.class));
    }
}
