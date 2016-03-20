package com.example.swiperefreshlayoutcardviewrecycleview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;

public class CardViewActivity extends ActionBarActivity {
	CardView cardView = null;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_cardview);
	        cardView = (CardView) findViewById(R.id.card_view);

	        SeekBar seek1 = (SeekBar) findViewById(R.id.seek1);
	        SeekBar seek2 = (SeekBar) findViewById(R.id.seek2);

	        seek1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
	            @Override
	            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
	                if (b) {
	                	//阴影大小设置  
	                   cardView.setCardElevation(i);//shadow
	                }
	            }

	            @Override
	            public void onStartTrackingTouch(SeekBar seekBar) {

	            }

	            @Override
	            public void onStopTrackingTouch(SeekBar seekBar) {

	            }
	        });

	        seek2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
	            @Override
	            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
	                if (b) {
	                	//圆角大小设置  
	                    cardView.setRadius(i);
	                }
	            }

	            @Override
	            public void onStartTrackingTouch(SeekBar seekBar) {

	            }

	            @Override
	            public void onStopTrackingTouch(SeekBar seekBar) {

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


