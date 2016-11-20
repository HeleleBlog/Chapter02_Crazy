package example.chapter02.knobble03;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/7/27 0027.
 */
public class ImageViewActivity extends Activity implements View.OnClickListener, View.OnTouchListener {

    private ImageView image1,image2;
    //    定义一个访问图片的数组
    int[] images = new int[]{
            R.drawable.one,
            R.drawable.two,
            R.drawable.trhee,
            R.drawable.four,
            R.drawable.five
    };
    //    定义默认显示的图片
    int currentImg = 2;
    //    定义图片的初始透明度
    int alpha = 255;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_view_layout);
        Button plus = (Button) findViewById(R.id.plus);//加
        Button minus = (Button) findViewById(R.id.minus);//减
        Button next = (Button) findViewById(R.id.next);
        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        // 设置查看下一张图的监听器
        next.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        image1.setOnTouchListener(this);
    }


    public static void actionStart(Context context) {
        context.startActivity(new Intent(context, ImageViewActivity.class));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.next:
                currentImg++;
                if (currentImg >= 5) currentImg = 0;
                BitmapDrawable bitmapDrawable = (BitmapDrawable) image1.getDrawable();
//                如果图片未回收，先强制回收该图片
                if (!bitmapDrawable.getBitmap().isRecycled()) {
                    bitmapDrawable.getBitmap().recycle();
                }
                // 将resources资源解码为bitmap
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), images[currentImg]);
                image1.setImageBitmap(bitmap);
                break;
            case R.id.plus:
                alpha += 20;// 先对自身进行加20操作，再返回alpha的值。类似于 ++alpha
                break;
            case R.id.minus:
                alpha -= 20;
                break;
        }
        if (alpha >= 255) alpha = 255;
        if (alpha <= 0) alpha = 0;
//        设置图片透明度
        image1.setAlpha(alpha);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (view.getId()) {
            case R.id.image1:
                BitmapDrawable bitmapDrawable = (BitmapDrawable) image1.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
//                bitmap图片的实际大小与ImageView的缩放比例
                double scale = bitmap.getWidth() / image1.getWidth();
//                imageview 点的坐标  *  scale比例  =  bitmap 点的坐标
                int x = (int) (motionEvent.getX() * scale);
                int y = (int) (motionEvent.getY() * scale);
                if (x + 120 > bitmap.getWidth()) x = bitmap.getWidth() - 120;
                if (y + 120 > bitmap.getHeight()) x = bitmap.getHeight() - 120;
                //Bitmap类的createBitmap方法可以截取位图的指定部分。
                image2.setImageBitmap(Bitmap.createBitmap(bitmap,x,y,120,120));
                image2.setAlpha(alpha);
                break;
        }
        return false;
    }
}
