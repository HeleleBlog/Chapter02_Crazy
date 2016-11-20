package example.chapter02.knobble02.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Administrator on 2016/7/25 0025.
 */
public class DrawView extends View {

    public float currentX = 200;
    public float currentY = 300;

    public DrawView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 创建画笔
        Paint paint = new Paint();
        // 设置画笔的颜色
        paint.setColor(Color.RED);
        // 绘制一个小圆（球）
        canvas.drawCircle(currentX,currentY,50,paint);
        // 圆 透明度控制
//        canvas.translate(2,1);
    }
}
