package com.example.swiperefreshlayoutcardviewrecycleview;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button swiperefreshlayoutBtn=(Button) findViewById(R.id.swiperefreshlayoutBtn);
        Button cardviewBtn=(Button) findViewById(R.id.cardviewBtn);
        Button recycleviewBtn=(Button) findViewById(R.id.recycleviewBtn);
        Button paletteBtn=(Button) findViewById(R.id.paletteBtn);
        swiperefreshlayoutBtn.setOnClickListener(this);
        cardviewBtn.setOnClickListener(this);
        recycleviewBtn.setOnClickListener(this);
        paletteBtn.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.swiperefreshlayoutBtn:
			Intent intent1 =new Intent(this, SwiperefreshLayoutActivity.class);
			startActivity(intent1);
			
			break;
		case R.id.cardviewBtn:
			Intent intent2 =new Intent(this, CardViewActivity.class);
			startActivity(intent2);
			break;
		case R.id.recycleviewBtn:
			Intent intent3 =new Intent(this, RecycleViewActivity.class);
			startActivity(intent3);
	break;
		case R.id.paletteBtn:
			Intent intent4 =new Intent(this, PaletteActivity.class);
			startActivity(intent4);
	break;
		default:
			break;
		}
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
