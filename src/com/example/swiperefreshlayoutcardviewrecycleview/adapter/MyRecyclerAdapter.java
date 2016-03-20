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
//RecyclerViewû�е���¼���ֻ���Լ�д�ӿ�ʵ��
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


    @Override  //��һ��UI��ΪHolder �������
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.recy_item,null);
        MyViewHolder holder = new MyViewHolder(v);
        //��������Viewע�����¼�
        v.setOnClickListener(this);
        v.setOnLongClickListener(this);
        return holder;
    }

    //��������
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Item item = datalist.get(position);
        TextView text1 = (TextView) holder.itemView.findViewById(R.id.text) ;
        text1.setText(item.desc);
        ImageView img = (ImageView) holder.itemView.findViewById(R.id.img);
        img.setImageResource(item.imgId);
       //�����ݱ�����itemView��Tag�У��Ա���ʱ���л�ȡ
        holder.itemView.setTag(item.desc);
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }
    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            //ע������ʹ��getTag������ȡ����
            mOnItemClickListener.onItemClick(view,view.getTag());
        }
    }
 
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


	@Override
	public boolean onLongClick(View view) {
		 if (mOnItemLongClickListener != null) {
	            //ע������ʹ��getTag������ȡ����
			 mOnItemLongClickListener.onLongClick(view,  view.getTag());
	        }
		return false;
		
	}
	public void setOnItemLongClickListener(OnRecyclerViewItemLongClickListener  listener) {
        this.mOnItemLongClickListener = listener;
    }
//	���ɾ������
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

