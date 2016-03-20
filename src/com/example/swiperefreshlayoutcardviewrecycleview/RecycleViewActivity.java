package com.example.swiperefreshlayoutcardviewrecycleview;

import java.util.ArrayList;
import java.util.List;

import com.example.swiperefreshlayoutcardviewrecycleview.adapter.MyRecyclerAdapter;
import com.example.swiperefreshlayoutcardviewrecycleview.adapter.MyRecyclerAdapter.OnRecyclerViewItemClickListener;
import com.example.swiperefreshlayoutcardviewrecycleview.adapter.MyRecyclerAdapter.OnRecyclerViewItemLongClickListener;
import com.example.swiperefreshlayoutcardviewrecycleview.bean.Item;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class RecycleViewActivity extends ActionBarActivity {
	private List<Item> itemList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recycleview);
		initView();
	}

	private void initView() {
		String title = "我是小猫，你好，来抱我吧-";
		// String title = "";
		itemList = new ArrayList<Item>(5);
		itemList.add(new Item(title+0, R.drawable.cat0));
		itemList.add(new Item(title+1, R.drawable.cat1));
		itemList.add(new Item(title+2, R.drawable.cat2));
		itemList.add(new Item(title+3, R.drawable.cat3));
		itemList.add(new Item(title+4, R.drawable.cat4));
		itemList.add(new Item(title+5, R.drawable.cat5));
		itemList.add(new Item(title+6, R.drawable.cat6));
		itemList.add(new Item(title+7, R.drawable.cat7));
		itemList.add(new Item(title+8, R.drawable.cat8));

		// RecyclerView就是高级的ListView
		RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
		// RecyclerView.Adapter：托管数据集合，为每个Item创建视图；
		// RecyclerView.ViewHolder：承载Item视图的子视图；
		// RecyclerView.LayoutManager：负责Item视图的布局；
		// RecyclerView.ItemDecoration：为每个Item视图添加子视图，在Demo中被用来绘制Divider；
		// RecyclerView.ItemAnimator：负责添加、删除数据时的动画效果；

		 LinearLayoutManager mg = new LinearLayoutManager(this);
		 //水平或垂直摆放，可以不用 HorizontalScrollView
		 mg.setOrientation(LinearLayoutManager.HORIZONTAL);

		recyclerView.setItemAnimator(new DefaultItemAnimator());
		// 格子摆放
//		GridLayoutManager mg = new GridLayoutManager(this, 3); // 3列
		// 交错性的摆放，有点win8那种格子风格，最好使用CardView作为item，有边框和圆角
		// StaggeredGridLayoutManager mg = new
		// StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
		recyclerView.setLayoutManager(mg);
		MyRecyclerAdapter adapter = new MyRecyclerAdapter(this, itemList);
		recyclerView.setAdapter(adapter);
		// RecyclerView没有点击事件，只能自己写接口实现
		 adapter.setOnItemClickListener(new OnRecyclerViewItemClickListener()
		 {

		@Override
		public void onItemClick(View view, Object data) {
			Toast.makeText(RecycleViewActivity.this,  "单击事件：内容="+(String)data, 600)
			 .show();
			
		}
		 });
		 adapter.setOnItemLongClickListener(new OnRecyclerViewItemLongClickListener() {
			
			@Override
			public boolean onLongClick(View view, Object data) {
				Toast.makeText(RecycleViewActivity.this,  "长按事件：内容="+(String)data, 600)
				 .show();
				return false;
			}
		});

		// 对RecyclerView设置滑动监听事件，在其中进行判断：
		// recyclerView.setOnScrollListener(new OnScrollListener() {
		//
		// @Override
		// public void onScrollStateChanged(RecyclerView recyclerView,
		// int newState) {
		// // TODO Auto-generated method stub
		// super.onScrollStateChanged(recyclerView, newState);
		// }
		//
		// @Override
		// public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
		// // TODO Auto-generated method stub
		// super.onScrolled(recyclerView, dx, dy);
		// }
		// });

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