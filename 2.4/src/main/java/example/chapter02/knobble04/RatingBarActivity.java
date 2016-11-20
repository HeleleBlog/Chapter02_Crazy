package example.chapter02.knobble04;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;

/**
 * Created by Administrator on 2016/8/2 0002.
 */
public class RatingBarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ratingbar);
        RatingBar ratingbar = (RatingBar) findViewById(R.id.ratingbar);
        final ImageView img = (ImageView) findViewById(R.id.img);
        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                img.setAlpha((int)v * 255 / 5);
            }
        });
    }

    public static void actionStart(Context context) {
        context.startActivity(new Intent(context, RatingBarActivity.class));
    }
}
