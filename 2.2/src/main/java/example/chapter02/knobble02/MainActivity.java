package example.chapter02.knobble02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


/**
 * 2.2 布局管理器
 */
public class MainActivity extends Activity implements View.OnClickListener {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        initView();
    }

    private void initView() {
        Button layoutBtn = (Button) findViewById(R.id.layout_manager);
        LinearLayout layout_selector = (LinearLayout) findViewById(R.id.linear_layout_selector);

        layoutBtn.setOnClickListener(this);
        layout_selector.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_manager:
                intent = new Intent(MainActivity.this, LayoutManagerActivity.class);
                startActivity(intent);
                break;
            case R.id.linear_layout_selector:
                break;
        }

    }
}
