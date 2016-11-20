package example.chapter02.knobble03;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by Administrator on 2016/7/27 0027.
 * 文本框与编辑框
 */
public class TextEditActivity extends Activity{

    private EditText userNameEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_edit_layout);
        userNameEdit = (EditText) findViewById(R.id.user_name_edit);
//         添加文本改变的监听
        userNameEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    public static void actionStart(Context context) {
        Intent intent = new Intent(context,TextEditActivity.class);
        context.startActivity(intent);
    }
}
