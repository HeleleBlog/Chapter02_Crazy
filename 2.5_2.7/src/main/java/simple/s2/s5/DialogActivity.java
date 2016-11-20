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
import android.widget.Toast;

import simple.s2.s5.popupwindow.PopupWindowActivity;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {

    private View tv01, tv02, tv03, tv04, tv05, tv06;
    private AlertDialog.Builder builder;
    private int SINGLE_DIALOG = 0x113;

    final String[] arrayFruit = new String[]{"苹果", "橘子", "草莓", "香蕉"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        tv01 = findViewById(R.id.dialog_1);
        tv02 = findViewById(R.id.dialog_2);
        tv03 = findViewById(R.id.dialog_3);
        tv04 = findViewById(R.id.dialog_4);
        tv05 = findViewById(R.id.dialog_5);
        tv06 = findViewById(R.id.dialog_6);
        tv01.setOnClickListener(this);
        tv02.setOnClickListener(this);
        tv03.setOnClickListener(this);
        tv04.setOnClickListener(this);
        tv05.setOnClickListener(this);
        tv06.setOnClickListener(this);
    }

    public static void actionStart(Context context) {
        context.startActivity(new Intent(context, DialogActivity.class));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_1:
//                简单的Dialog
                easyDialog();
                break;
            case R.id.dialog_2:
//                2.5.2 使用AlertDialog创建 列表/单选/多选 对话框
//                listDialog();
//                singleDialog();
                multiDialog();

                break;
            case R.id.dialog_3:
//                2.5.3 使用AlertDialog创建自定义对话框
                CustomDialogActivity.actionStart(this);
                break;
            case R.id.dialog_4:
//              2.5.4 popupwindow
//                参考博客：http://blog.csdn.net/harvic880925/article/details/49272285
                PopupWindowActivity.actionStart(this);
                break;
            case R.id.dialog_5:
                DateTimePickerDialogActivity.actionStart(this);
                break;
            case R.id.dialog_6:
                ProgressDialogActivity.actionStart(this);
                break;
        }
    }

    /**
     * 多对话框
     */
    private void multiDialog() {
        final boolean[] checkedItems = new boolean[]{true, true, true, false};
        builder = new AlertDialog.Builder(DialogActivity.this);
        builder.setTitle("多选对话框");
        builder.setMultiChoiceItems(arrayFruit, checkedItems,
                //为列表项的单击事件设置监听器
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        String str = "";
                        for (int j = 0; j < arrayFruit.length; j++) {
                            if (checkedItems[j]) {
                                str += arrayFruit[j]+" ";
                            }
                        }
                        Toast.makeText(DialogActivity.this,str,Toast.LENGTH_SHORT).show();
                    }
                });
        builder.create().show();

    }

    /**
     * 简单的Dialog
     */
    private void easyDialog() {
        builder = new AlertDialog.Builder(DialogActivity.this);
        builder.setTitle("简单的Dialog")
                .setMessage("Message")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogActivity.this, "AlertDialog OK", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }

    /**
     * 单选对话框
     */
    private void singleDialog() {
        showDialog(SINGLE_DIALOG);
    }

    /**
     * 列表对话框
     */
    private void listDialog() {
        builder = new AlertDialog.Builder(DialogActivity.this);
        builder.setTitle("列表对话框")
                .setCancelable(true)
                .setItems(arrayFruit, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogActivity.this, arrayFruit[i], Toast.LENGTH_SHORT).show();
                    }
                })
                .create().show();
    }

    @Nullable
    @Override
    protected Dialog onCreateDialog(int id, Bundle args) {
//        判断生成哪种类型的对话框
        switch (id) {
            case 0x113:
                builder = new AlertDialog.Builder(DialogActivity.this);
                builder.setTitle("单选对话框");
                builder.setSingleChoiceItems(arrayFruit, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogActivity.this, arrayFruit[i], Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("确定", null);
                return builder.create();
        }
        return null;
    }
}
