package example.chapter02.knobble04;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 可展开的列表组件
 */
public class ExpandableActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private List<String> groupData;//group数据源
    private Map<Integer, List<ChildItem>> childData;//child的数据源
    private MyBaseExpandableListAdapter myAdapter;

    final int CONTEXT_MENU_GROUP_DELETE = 0;//添加上下文菜单时每一个菜单项的item ID
    final int CONTEXT_MENU_GROUP_RENAME = 1;
    final int CONTEXT_MENU_CHILD_EDIT = 2;
    final int CONTEXT_MENU_CHILD_DELETE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);
        initDatas();
        initView();
        initEvents();
    }

    private void initEvents() {
//        child子项的单击事件
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Toast.makeText(ExpandableActivity.this, "点击了" + myAdapter.getChild(i, i1), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void initView() {
        expandableListView = (ExpandableListView) findViewById(R.id.expandable_listview);
        expandableListView.setGroupIndicator(null);//不显示系统默认的group indicator
        expandableListView.setAdapter(myAdapter);
        registerForContextMenu(expandableListView);//给ExpandableListView添加上下文菜单
    }

    private void initDatas() {
        groupData = new ArrayList<>();
        groupData.add("家人");
        groupData.add("朋友");
        groupData.add("同事");

        List<ChildItem> childItem1 = new ArrayList<>();
        ChildItem childData1 = new ChildItem("baba", R.mipmap.head01);
        childItem1.add(childData1);
        ChildItem childData2 = new ChildItem("mama", R.mipmap.head02);
        childItem1.add(childData2);
        ChildItem childData3 = new ChildItem("gege", R.mipmap.head03);
        childItem1.add(childData3);
        List<ChildItem> childItem2 = new ArrayList<>();
        ChildItem childData4 = new ChildItem("baba", R.mipmap.head01);
        childItem2.add(childData4);
        ChildItem childData5 = new ChildItem("mama", R.mipmap.head02);
        childItem2.add(childData5);
        ChildItem childData6 = new ChildItem("gege", R.mipmap.head03);
        childItem2.add(childData6);
        List<ChildItem> childItem3 = new ArrayList<>();
        ChildItem childData7 = new ChildItem("baba", R.mipmap.head01);
        childItem3.add(childData7);
        ChildItem childData8 = new ChildItem("mama", R.mipmap.head02);
        childItem3.add(childData8);

        childData = new HashMap<Integer, List<ChildItem>>();
        childData.put(0, childItem1);
        childData.put(1, childItem2);
        childData.put(2, childItem3);

        myAdapter = new MyBaseExpandableListAdapter(this, groupData, childData);
    }

    /**
     * 添加上下文菜单
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        ExpandableListView.ExpandableListContextMenuInfo info = (ExpandableListView.ExpandableListContextMenuInfo) menuInfo;
        int type = ExpandableListView.getPackedPositionType(info.packedPosition);
        if(type==ExpandableListView.PACKED_POSITION_TYPE_GROUP){
            menu.setHeaderTitle("Options");
            menu.add(0,CONTEXT_MENU_GROUP_DELETE,0,"删除");
            menu.add(0,CONTEXT_MENU_GROUP_RENAME,0,"重命名");
        }
        if(type == ExpandableListView.PACKED_POSITION_TYPE_CHILD){
            menu.setHeaderTitle("Options");
            menu.add(1,CONTEXT_MENU_CHILD_EDIT,0,"编辑");
            menu.add(1,CONTEXT_MENU_CHILD_DELETE,0,"删除");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case CONTEXT_MENU_GROUP_DELETE:
                Toast.makeText(this,"这是group的删除",Toast.LENGTH_SHORT).show();
                break;
            case CONTEXT_MENU_GROUP_RENAME:
                Toast.makeText(this,"这是group的重命名",Toast.LENGTH_SHORT).show();
                break;
            case CONTEXT_MENU_CHILD_EDIT:
                Toast.makeText(this,"这是child的编辑",Toast.LENGTH_SHORT).show();
                break;
            case CONTEXT_MENU_CHILD_DELETE:
                Toast.makeText(this,"这是child的删除",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    public static void actionStart(Context context) {
        context.startActivity(new Intent(context,ExpandableActivity.class));
    }
}
