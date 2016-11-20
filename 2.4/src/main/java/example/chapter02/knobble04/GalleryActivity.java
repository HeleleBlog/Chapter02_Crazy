package example.chapter02.knobble04;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class GalleryActivity extends AppCompatActivity {

    int[] imageIds = new int[]{
            R.mipmap.img01,
            R.mipmap.img02,
            R.mipmap.img03,
            R.mipmap.img04,
            R.mipmap.img05,
            R.mipmap.img06,
            R.mipmap.img07,
            R.mipmap.img08,
            R.mipmap.img09,
            R.mipmap.img10,
            R.mipmap.img11
    };
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
//        final ImageSwitcher imageSwitcher = (ImageSwitcher) findViewById(R.id.gallery_switcher);
        image = (ImageView) findViewById(R.id.gallery_imageview);
        Gallery gallery = (Gallery) findViewById(R.id.gallery);
//        //为ImageSwitcher对象设置ViewFactory对象
//        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
//            @Override
//            public View makeView() {
//                ImageView imageView = new ImageView(GalleryActivity.this);
//                imageView.setBackgroundColor(0xff0000);
//                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//                imageView.setLayoutParams(new ImageSwitcher.LayoutParams
//                        (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//
//                return imageView;
//            }
//        });
//        //设置图片更换的动画效果
//        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
//        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
        //创建一个BaseAdapter对象，该对象负责提供Gallery所显示的每张图片
        BaseAdapter baseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return imageIds.length;
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            //该方法返回的View就代表了每个列表项
            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                ImageView imageView = new ImageView(GalleryActivity.this);
                imageView.setImageResource(imageIds[i]);
//                设置ImageView的缩放类型
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new Gallery.LayoutParams(75, 100));
                TypedArray typedArray = obtainStyledAttributes(R.styleable.Gallery);
                imageView.setBackgroundResource(typedArray.getResourceId(
                        R.styleable.Gallery_android_galleryItemBackground, 0));
                Log.d("TAG", "getView: ");
                return imageView;
            }
        };
        gallery.setAdapter(baseAdapter);
        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //            当Gallery选中项发生改变时触发该方法
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                image.setImageResource(imageIds[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public static void actionStart(Context context) {
        context.startActivity(new Intent(context, GalleryActivity.class));
    }
}
