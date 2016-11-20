package simple.s2.s5;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自定义列表Dialog
 */
public class CustomDialogActivity extends AppCompatActivity implements View.OnClickListener {

    private int LIST_DIALOG = 0x113;
private AlertDialog.Builder builder;
    private TextView listCustomDialog,login,mock;
    //定义三个列表项名称
    private String[] names = new String[]{"橘子", "香蕉", "苹果"};
    //定义三个列表项对应的图标
    private int[] imgIds = new int[]{R.mipmap.orange, R.mipmap.banana, R.mipmap.apple};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_custom);
        listCustomDialog = (TextView) findViewById(R.id.custom_dialog_list);
        login = (TextView) findViewById(R.id.custom_dialog_login);
        mock = (TextView) findViewById(R.id.custom_dialog_mock);
        listCustomDialog.setOnClickListener(this);
        login.setOnClickListener(this);
        mock.setOnClickListener(this);
    }

    @Nullable
    @Override
    protected Dialog onCreateDialog(int id, Bundle args) {
        switch (id) {
            case 0x113:
                List<Map<String, Object>> listItems = new ArrayList<>();
                for (int i = 0; i < names.length; i++) {
                    Map<String, Object> listItem = new HashMap<>();
                    listItem.put("header", imgIds[i]);
                    listItem.put("name", names[i]);
                    listItems.add(listItem);
                }
                AlertDialog.Builder b = new AlertDialog.Builder(this);
                b.setTitle("自定义列表Dialog");
                //创建一个SimpleAdapter
                SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.row, new String[]{"name", "header"}, new int[]{R.id.name, R.id.header});
                b.setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(CustomDialogActivity.this,names[i],Toast.LENGTH_SHORT).show();
                    }
                });
                return b.create();
        }
        return null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.custom_dialog_list:
                showDialog(LIST_DIALOG);
                break;
            case R.id.custom_dialog_login:
                loginDialog();
                break;
            case R.id.custom_dialog_mock:
                Intent intent = new Intent(this,MockActivity.class);
                startActivity(intent);
                break;
        }
    }

    /**
     * 自定义登录Dialog
     */
    private void loginDialog() {
        builder = new AlertDialog.Builder(this);
        builder.setTitle("登录");
        LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.login_dialog,null);
        builder.setView(layout);
        builder.setPositiveButton("登录", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }

    public static void actionStart(Context context) {
        context.startActivity(new Intent(context, CustomDialogActivity.class));
    }
}
