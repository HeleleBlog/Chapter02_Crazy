package example.chapter02.knobble04;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

/**
 * Created by Administrator on 2016/8/2 0002.
 */
public class TabHostActivity extends TabActivity {
    //    TabHost使用步骤
//    1.在界面布局中定义TabHost组件，并为该组件定义选项卡的内容
//    2.Activity继承自TabActiivty
//    3.调用TabActivity的getTabHost()方法获取TabHost对象
//    4.通过TabHost对象的方法创建选项卡和添加选项卡
//        创建选项卡 newTabSpec(String tag)
//        添加选项卡 addTab(TabHost.TabSpec tabspec)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TabHost tabhost = getTabHost();
        //设置使用TanHost布局
        LayoutInflater.from(this).inflate(R.layout.tabhost, tabhost.getTabContentView(), true);
//        添加第一个标签页
        tabhost.addTab(tabhost.newTabSpec("tab1").setIndicator("未接电话").setContent(R.id.tab_01));
        tabhost.addTab(tabhost.newTabSpec("tab2").setIndicator("已接电话", getResources().getDrawable(R.mipmap.ic_launcher)).setContent(R.id.tab_02));
        tabhost.addTab(tabhost.newTabSpec("tab3").setIndicator("通话记录").setContent(R.id.tab_03));

    }

    public static void actionStart(Context context) {
        context.startActivity(new Intent(context, TabHostActivity.class));
    }
}
