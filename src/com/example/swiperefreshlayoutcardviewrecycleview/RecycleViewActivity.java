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
		String title = "����Сè����ã������Ұ�-";
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

		// RecyclerView���Ǹ߼���ListView
		RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
		// RecyclerView.Adapter���й����ݼ��ϣ�Ϊÿ��Item������ͼ��
		// RecyclerView.ViewHolder������Item��ͼ������ͼ��
		// RecyclerView.LayoutManager������Item��ͼ�Ĳ��֣�
		// RecyclerView.ItemDecoration��Ϊÿ��Item��ͼ�������ͼ����Demo�б���������Divider��
		// RecyclerView.ItemAnimator��������ӡ�ɾ������ʱ�Ķ���Ч����

		 LinearLayoutManager mg = new LinearLayoutManager(this);
		 //ˮƽ��ֱ�ڷţ����Բ��� HorizontalScrollView
		 mg.setOrientation(LinearLayoutManager.HORIZONTAL);

		recyclerView.setItemAnimator(new DefaultItemAnimator());
		// ���Ӱڷ�
//		GridLayoutManager mg = new GridLayoutManager(this, 3); // 3��
		// �����Եİڷţ��е�win8���ָ��ӷ�����ʹ��CardView��Ϊitem���б߿��Բ��
		// StaggeredGridLayoutManager mg = new
		// StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
		recyclerView.setLayoutManager(mg);
		MyRecyclerAdapter adapter = new MyRecyclerAdapter(this, itemList);
		recyclerView.setAdapter(adapter);
		// RecyclerViewû�е���¼���ֻ���Լ�д�ӿ�ʵ��
		 adapter.setOnItemClickListener(new OnRecyclerViewItemClickListener()
		 {

		@Override
		public void onItemClick(View view, Object data) {
			Toast.makeText(RecycleViewActivity.this,  "�����¼�������="+(String)data, 600)
			 .show();
			
		}
		 });
		 adapter.setOnItemLongClickListener(new OnRecyclerViewItemLongClickListener() {
			
			@Override
			public boolean onLongClick(View view, Object data) {
				Toast.makeText(RecycleViewActivity.this,  "�����¼�������="+(String)data, 600)
				 .show();
				return false;
			}
		});

		// ��RecyclerView���û��������¼��������н����жϣ�
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