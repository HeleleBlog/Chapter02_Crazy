package example.chapter02.knobble04;

/**
 * Created by Administrator on 2016/8/25 0025.
 */
public class ChildItem {
    private String childTitle;//子项显示的文字
    private int childHead;//子项头像

    public ChildItem(String childTitle, int childHead) {
        this.childTitle = childTitle;
        this.childHead = childHead;
    }

    public String getChildTitle() {
        return childTitle;
    }

    public void setChildTitle(String childTitle) {
        this.childTitle = childTitle;
    }

    public int getChildHead() {
        return childHead;
    }

    public void setChildHead(int childHead) {
        this.childHead = childHead;
    }

}
