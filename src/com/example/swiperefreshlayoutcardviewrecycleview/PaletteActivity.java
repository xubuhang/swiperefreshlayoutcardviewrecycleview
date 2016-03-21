package com.example.swiperefreshlayoutcardviewrecycleview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class PaletteActivity extends ActionBarActivity {
	 ImageView imageIv;
	ImageView iv1,iv2,iv3,iv4,iv5,iv6;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_palette);
	         imageIv=(ImageView) findViewById(R.id.imageIv);
	         iv1 = (ImageView) findViewById(R.id.iv1);
		        iv2 = (ImageView) findViewById(R.id.iv2);
		        iv3 = (ImageView) findViewById(R.id.iv3);
		        iv4 = (ImageView) findViewById(R.id.iv4);
		        iv5 = (ImageView) findViewById(R.id.iv5);
		        iv6 = (ImageView) findViewById(R.id.iv6);
	           GetPalette(R.drawable.cat1);
	        
	    }

	    private void GetPalette(int imageId) {
	    	imageIv.setImageResource(imageId);
	        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imageId);
//	        四种根据Bitmap对象来创建Palette对象的方法
//	        Palette.generate(bitmap)
//	        Palette.generate(bitmap, numColors)
//	        Palette.generateAsync(bitmap, listener)
//	        Palette.generateAsync(bitmap, numColors, listener)
	      //使用默认的调色板大小（16）
	        Palette.generateAsync(bitmap,
	                new Palette.PaletteAsyncListener() {
	            @Override
	            public void onGenerated(Palette palette) {
	                 Palette.Swatch s1 = palette.getVibrantSwatch(); //充满活力的色板
	                Palette.Swatch s2 = palette.getDarkVibrantSwatch(); //充满活力的暗色类型色板
	                 Palette.Swatch s3 = palette.getLightVibrantSwatch(); //充满活力的亮色类型色板
	                 Palette.Swatch s4 = palette.getMutedSwatch(); //黯淡的色板
	                Palette.Swatch s5 = palette.getDarkMutedSwatch(); //黯淡的暗色类型色板（翻译过来没有原汁原味的赶脚啊！）
	                 Palette.Swatch s6 = palette.getLightMutedSwatch(); //黯淡的亮色类型色板
	                 //充满活力和或充满活力暗色类型色板应该是大部分开发经常使用的
	                 //设置图片颜色swatch.getRgb()
	                 //设置文本颜色swatch.getTitleTextColor()
	                 if (s1 != null) {
	                     iv1.setBackgroundColor(s1.getRgb());
//	                     iv1.setBackgroundColor(s1.getTitleTextColor());
	                     s1.getPopulation();
	                 }
	                 if (s2 != null) {
	                     iv2.setBackgroundColor(s2.getRgb());
	                 }
	                 if (s3 != null) {
	                     iv3.setBackgroundColor(s3.getRgb());
	                 }
	                 if (s4 != null) {
	                     iv4.setBackgroundColor(s4.getRgb());
	                 }
	                 if (s5 != null) {
	                     iv5.setBackgroundColor(s5.getRgb());
	                 }
	                 if (s6 != null) {
	                     iv6.setBackgroundColor(s6.getRgb());
	                 }
	            }
	        });
		
	}

		@Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }

	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        // Handle action bar item clicks here. The action bar will
	        // automatically handle clicks on the Home/Up button, so long
	        // as you specify a parent activity in AndroidManifest.xml.
	        int id = item.getItemId();
	        if (id == R.id.action_settings) {
	            return true;
	        }
	        return super.onOptionsItemSelected(item);
	    }

}


