package com.example.swiperefreshlayoutcardviewrecycleview;

import java.util.ArrayList;
import java.util.List;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class SwiperefreshLayoutActivity extends ActionBarActivity {
	 private SwipeRefreshLayout swipeRefreshLayout;
		private ListView listView;
		private com.example.swiperefreshlayoutcardviewrecycleview.adapter.ListViewAdapter adapter;
		private ArrayList<String> arrayList;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_swiperefreshlayout);
	        swipeRefreshLayout= (SwipeRefreshLayout) findViewById(R.id.swipeLayout);
//	        设置进度动画的颜色
	        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light,  
	                android.R.color.holo_orange_light, android.R.color.holo_red_light);
//	        设置进度圈的大小，只有两个值：DEFAULT、LARGE
	        swipeRefreshLayout.setSize(SwipeRefreshLayout.LARGE);
//	        设置进度圈的背景色
//	        swipeRefreshLayout.setProgressBackgroundColor(android.R.color.holo_blue_dark);
	        //swipeRefreshLayout.setPadding(20, 20, 20, 20);
	        //swipeRefreshLayout.setProgressViewOffset(true, 100, 200);
	        //swipeRefreshLayout.setDistanceToTriggerSync(50);
	        swipeRefreshLayout.setProgressViewEndTarget(true, 100);
//	        设置手势滑动监听器
	        swipeRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
	            @Override
	            public void onRefresh() {
	            	//这里开了一个线程暂停5秒再执行程序，这是为了模拟耗时的网络请求
	                new Thread(new Runnable() {
	                    @Override
	                    public void run() {
	                    	//清空list
	                    	arrayList.clear();//如果想保留原来的数据就不要清空
	                        for(int i=0;i<20;i++){
	                        	//加载到list中
	                        	arrayList.add("SwipeRefreshLayout下拉刷新"+i);
	                        }
	                        try {
	                            Thread.sleep(5000);
	                        } catch (InterruptedException e) {
	                            e.printStackTrace();
	                        }
	                        //发送消息1
	                        mHandler.sendEmptyMessage(1);
	                    }
	                    //一定不要忘记开启线程start
	                }).start();
	            }
	        });
	        ListView listView = (ListView) findViewById(R.id.mylist);
	        initData();
			adapter = new com.example.swiperefreshlayoutcardviewrecycleview.adapter.ListViewAdapter(this, arrayList);
			listView.setAdapter(adapter);
	    }
	 private void initData() {

			arrayList = new ArrayList<String>();
			for (int i = 0; i < 20; i++) {
				arrayList.add("---->" + i);
			}
		}
	 //handler
	    private Handler mHandler = new Handler(){
	        @Override
	        public void handleMessage(Message msg) {
	            super.handleMessage(msg);
//	           接收到消息且是1时停止刷新，并显示数据
	            switch (msg.what) {
	            case 1:
//	                 停止刷新
	                swipeRefreshLayout.setRefreshing(false);
	                adapter.notifyDataSetChanged();
	                //swipeRefreshLayout.setEnabled(false);
	                break;
	            default:
	                break;
	            }
	        }
	    };
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
