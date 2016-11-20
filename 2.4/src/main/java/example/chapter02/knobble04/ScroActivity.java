package example.chapter02.knobble04;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ScroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scro);
        findViewById(R.id.scro_tv1);
    }

    public static void actionStart(Context context) {
        context.startActivity(new Intent(context,ScroActivity.class));
    }
}
