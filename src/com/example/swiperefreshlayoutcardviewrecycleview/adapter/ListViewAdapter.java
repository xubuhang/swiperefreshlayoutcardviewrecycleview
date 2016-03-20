package com.example.swiperefreshlayoutcardviewrecycleview.adapter;

import java.util.ArrayList;

import com.example.swiperefreshlayoutcardviewrecycleview.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<String> arrayList;

	public ListViewAdapter(Context context, ArrayList<String> arrayList) {
		super();
		this.context = context;
		this.arrayList = arrayList;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arrayList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return arrayList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(R.layout.item,
					null);
			holder.textView = (TextView) convertView
					.findViewById(R.id.textview);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.textView.setText(arrayList.get(position));
		return convertView;
	}

	private final static class ViewHolder {
		TextView textView;
	}
}
