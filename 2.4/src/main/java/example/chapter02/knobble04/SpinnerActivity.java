package example.chapter02.knobble04;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/8/1 0001.
 */
public class SpinnerActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);

        spinner();
        spinner02();
    }

    private void spinner02() {
        String[] languages = getResources().getStringArray(R.array.programme_languages);
        MyAdapter myAdapter = new MyAdapter(SpinnerActivity.this,languages);
        Spinner spinner = (Spinner) findViewById(R.id.spinner_02);

        spinner.setAdapter(myAdapter);
    }

    /**
     * 第一个Spinnner
     */
    private void spinner() {
        final String[] items = getResources().getStringArray(R.array.books);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SpinnerActivity.this,"选中了 "+items[i],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public static void actionStart(Context context) {
        context.startActivity(new Intent(context,SpinnerActivity.class));
    }

    private class MyAdapter extends BaseAdapter{
        Context context;
        String[] languages;
        public MyAdapter(SpinnerActivity spinnerActivity, String[] languages) {
            this.context = spinnerActivity;
            this.languages = languages;
        }

        @Override
        public int getCount() {
            return languages.length;
        }

        @Override
        public Object getItem(int i) {
            return languages[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.setMinimumWidth(40);
            linearLayout.setMinimumHeight(40);
            ImageView image = new ImageView(context);
            image.setImageResource(R.mipmap.ic_launcher);
            TextView text = new TextView(context);
            text.setText(i+"");
            text.setTextSize(16);
            text.setTextColor(Color.BLACK);
            linearLayout.addView(image);
            linearLayout.addView(text);
            return linearLayout;

//            TextView text = new TextView(context);
//            text.setText(i+"");
//            return text;
        }
    }
}
