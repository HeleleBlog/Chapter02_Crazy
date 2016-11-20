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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListView listview = (ListView) findViewById(R.id.listview);
        List<Post> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Post post = new Post("张三"+i,"今天天气真好");
            list.add(post);
        }
        MyListViewAdapter adapter = new MyListViewAdapter(this,list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewActivity.this,"点击了"+i,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void actionStart(Context context) {
        context.startActivity(new Intent(context,ListViewActivity.class));
    }

    private class MyListViewAdapter extends BaseAdapter {
        Context context;
        List<Post> list;
        public MyListViewAdapter(Context context,List<Post> list) {
            this.context = context;
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            Post post = (Post) getItem(i);
            ViewHolder viewHolder;
            if(view==null){
                view = LayoutInflater.from(context).inflate(R.layout.listview_item,null);
                viewHolder = new ViewHolder();
                viewHolder.title = (TextView) view.findViewById(R.id.listview_item_title);
                viewHolder.message = (TextView) view.findViewById(R.id.listview_item_message);
                view.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.title.setText(post.getName());
            viewHolder.message.setText(post.getStr());
            return view;
        }
    }

    private class ViewHolder{
        private TextView title;
        private TextView message;
    }

    private class Post{
        private String name;
        private String str;

        public Post(String name, String str) {
            this.name = name;
            this.str = str;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }
    }
}
