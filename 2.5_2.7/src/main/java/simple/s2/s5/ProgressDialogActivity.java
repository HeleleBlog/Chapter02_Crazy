package simple.s2.s5;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ProgressDialogActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView progress01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dialog);
        progress01 = (TextView) findViewById(R.id.progress_dialog_01);
        progress01.setOnClickListener(this);
    }

    public static void actionStart(Context context) {
        context.startActivity(new Intent(context, ProgressDialogActivity.class));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.progress_dialog_01:
                showProgressDialog01();
                break;
        }
    }

    private void showProgressDialog01() {
        ProgressDialog pd = new ProgressDialog(this);
        pd.show();
    }
}
