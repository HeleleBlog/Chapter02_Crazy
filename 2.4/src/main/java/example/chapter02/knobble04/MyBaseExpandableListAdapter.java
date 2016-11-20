package example.chapter02.knobble04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by orangeLe on 2016/8/25 0025.
 * ExpandListView的适配器，继承自BaseExpandableListAdapter
 */
public class MyBaseExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> groupTitle;
    //子项是一个Map，key是group的id，每一个group对应一个childitem类型的list
    private Map<Integer, List<ChildItem>> childItem;
    private LinearLayout group;//group 那一行

    public MyBaseExpandableListAdapter(Context context, List<String> groupTitle, Map<Integer, List<ChildItem>> childItem) {
        this.context = context;
        this.groupTitle = groupTitle;
        this.childItem = childItem;
    }

    /**
     * 取得分组数
     *
     * @return
     */
    @Override
    public int getGroupCount() {
        return groupTitle.size();
    }

    /**
     * 取得指定分组的子元素数
     *
     * @param i groupPosition
     * @return
     */
    @Override
    public int getChildrenCount(int i) {
        return childItem.get(i).size();
    }

    /**
     * 取得与给定分组关联的数据
     *
     * @param i groupPosition
     * @return
     */
    @Override
    public Object getGroup(int i) {
        return groupTitle.get(i);
    }

    /**
     * 获取某个组下的某一项
     *
     * @param i  groupPosition
     * @param i1 childPosition
     * @return
     */
    @Override
    public Object getChild(int i, int i1) {
        //这里返回每个item的名称，方便单击item时显示
        return childItem.get(i).get(i1).getChildTitle();
    }

    /**
     * 取得指定分组的ID.该组ID必须在组中是唯一的.必须不同于其他所有ID（分组及子项目的ID）
     *
     * @param i groupPosition
     * @return
     */
    @Override
    public long getGroupId(int i) {
        return i;
    }

    /**
     * 组下子项的id
     *
     * @param i  groupPosition
     * @param i1 childPosition
     * @return
     */
    @Override
    public long getChildId(int i, int i1) {
//        取得给定分组中给定子视图的ID. 该组ID必须在组中是唯一的.必须不同于其他所有ID（分组及子项目的ID）
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        // Indicates whether the child and group IDs are stable across changes to the underlying data
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        GroupHolder groupHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.expandable_group_item, null);
            groupHolder = new GroupHolder();
            groupHolder.groupImg = (ImageView) view.findViewById(R.id.expand_group_iv);
            groupHolder.groupText = (TextView) view.findViewById(R.id.expand_group_tv);
            view.setTag(groupHolder);
        } else {
            groupHolder = (GroupHolder) view.getTag();
        }
        //如果group是展开的
        if (b) {
            groupHolder.groupImg.setImageResource(R.mipmap.open_expandable);
        } else {
            groupHolder.groupImg.setImageResource(R.mipmap.close_expandable);
        }
        groupHolder.groupText.setText(groupTitle.get(i));
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ChildHolder childHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.expandable_child_item, null);
            childHolder = new ChildHolder();
            childHolder.childHead = (ImageView) view.findViewById(R.id.expand_child_iv);
            childHolder.childText = (TextView) view.findViewById(R.id.expand_child_tv);
            view.setTag(childHolder);
        } else {
            childHolder = (ChildHolder) view.getTag();
        }
        childHolder.childHead.setImageResource(childItem.get(i).get(i1).getChildHead());
        childHolder.childText.setText(childItem.get(i).get(i1).getChildTitle());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        // Whether the child at the specified position is selectable
        return true;
    }

    private class GroupHolder {
        ImageView groupImg;
        TextView groupText;
    }

    private class ChildHolder {
        ImageView childHead;
        TextView childText;
    }
}
