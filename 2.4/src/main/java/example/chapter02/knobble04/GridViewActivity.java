package example.chapter02.knobble04;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridViewActivity extends AppCompatActivity {

    int[] imageIds = new int[]{
            android.R.drawable.ic_delete,
            android.R.drawable.ic_btn_speak_now,
            android.R.drawable.ic_dialog_alert,
            android.R.drawable.ic_dialog_dialer,
            android.R.drawable.ic_dialog_email,
            android.R.drawable.ic_dialog_info,
            android.R.drawable.ic_dialog_map,
            android.R.drawable.ic_input_add,
            android.R.drawable.ic_input_get
    };
    List<Post> griddata;
    GridView gridView;
    ImageSwitcher switcher;
    MyGridViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        gridView = (GridView) findViewById(R.id.gridview);
        griddata = new ArrayList<>();
        for (int i = 0; i < imageIds.length; i++) {
            Post post = new Post("张三"+i,imageIds[i]);
            griddata.add(post);
        }
        adapter = new MyGridViewAdapter(this, griddata);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridViewActivity.this, "You click item "+i, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void actionStart(Context context) {
        context.startActivity(new Intent(context, GridViewActivity.class));
    }

    class MyGridViewAdapter extends BaseAdapter {
        Context context;
        List<Post> gridData;

        public MyGridViewAdapter(Context context, List<Post> gridData) {
            this.context = context;
            this.gridData = gridData;
        }

        @Override
        public int getCount() {
            return gridData.size();
        }

        @Override
        public Object getItem(int i) {
            return gridData.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            Post post = (Post) getItem(i);
            if (view == null) {
                view = LayoutInflater.from(context).inflate(R.layout.grid_view_item, null);
                viewHolder = new ViewHolder();
                viewHolder.iv = (ImageView) view.findViewById(R.id.gridview_item_iv);
                viewHolder.tv = (TextView) view.findViewById(R.id.gridview_item_tv);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.tv.setText(post.getTv());
            viewHolder.iv.setImageResource(post.getIv());
            return view;
        }
    }

    private class ViewHolder {
        TextView tv;
        ImageView iv;
    }

    private class Post{
        String tv;
        int iv;

        public Post(String tv, int iv) {
            this.tv = tv;
            this.iv = iv;
        }

        public String getTv() {
            return tv;
        }

        public void setTv(String tv) {
            this.tv = tv;
        }

        public int getIv() {
            return iv;
        }

        public void setIv(int iv) {
            this.iv = iv;
        }
    }
}
