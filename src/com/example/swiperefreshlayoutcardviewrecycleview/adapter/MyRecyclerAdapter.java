package com.example.swiperefreshlayoutcardviewrecycleview.adapter;

import java.util.List;

import android.app.Activity;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.swiperefreshlayoutcardviewrecycleview.bean.Item;

import com.example.swiperefreshlayoutcardviewrecycleview.R;
import com.example.swiperefreshlayoutcardviewrecycleview.RecycleViewActivity;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> implements View.OnClickListener ,View.OnLongClickListener{
//RecyclerView没有点击事件，只能自己写接口实现
	 //define interface
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , Object data);
    }
    public static interface OnRecyclerViewItemLongClickListener {
        public boolean onLongClick(View view,  Object data);
    }
    
    private Activity activity;
    private List<Item> datalist;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
    private OnRecyclerViewItemLongClickListener mOnItemLongClickListener = null;
    public MyRecyclerAdapter (Activity act, List<Item> list) {
        this.activity = act;
        this.datalist = list;
    }


    @Override  //绑定一个UI作为Holder 提高性能
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.recy_item,null);
        MyViewHolder holder = new MyViewHolder(v);
        //将创建的View注册点击事件
        v.setOnClickListener(this);
        v.setOnLongClickListener(this);
        return holder;
    }

    //设置数据
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Item item = datalist.get(position);
        TextView text1 = (TextView) holder.itemView.findViewById(R.id.text) ;
        text1.setText(item.desc);
        ImageView img = (ImageView) holder.itemView.findViewById(R.id.img);
        img.setImageResource(item.imgId);
       //将数据保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.setTag(item.desc);
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }
    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(view,view.getTag());
        }
    }
 
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


	@Override
	public boolean onLongClick(View view) {
		 if (mOnItemLongClickListener != null) {
	            //注意这里使用getTag方法获取数据
			 mOnItemLongClickListener.onLongClick(view,  view.getTag());
	        }
		return false;
		
	}
	public void setOnItemLongClickListener(OnRecyclerViewItemLongClickListener  listener) {
        this.mOnItemLongClickListener = listener;
    }
//	添加删除数据
	public void addItem(Item content, int position) {
		datalist.add(position, content);
	    notifyItemInserted(position); //Attention!
	}
	public void removeItem(Item model) {
	    int position = datalist.indexOf(model);
	    datalist.remove(position);
	    notifyItemRemoved(position);//Attention!
	}
}

