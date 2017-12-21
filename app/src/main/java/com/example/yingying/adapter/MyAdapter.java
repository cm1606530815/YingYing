package com.example.yingying.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.yingying.Bean.EventbusMessager;
import com.example.yingying.Bean.MyBean;
import com.example.yingying.R;
import com.example.yingying.activity.XiangQingActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by samsung on 2017/12/14.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>implements  View.OnClickListener{
    private OnItemClickListener mOnItemClickListener1 = null;
    Context context;
    List<MyBean.RetBean.ListBean> list;
    private OnItemClickListener mOnItemClickListener = null;
    private MyHolder myHolder;

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }

    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }


    public MyAdapter(Context context, List<MyBean.RetBean.ListBean> list) {
        this.context=context;
        this.list=list;
    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item, null);
        myHolder = new MyHolder(view);


        //将创建的View注册点击事件
        view.setOnClickListener(this);


        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
     holder.textView.setText(list.get(position).getTitle());
     holder.imageView.setImageURI(Uri.parse(list.get(position).getChildList().get(0).getPic()));
      holder.imageView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              EventBus.getDefault().postSticky(new EventbusMessager(list.get(position).getChildList().get(0).getDataId(),list.get(position).getTitle()));
              context.startActivity(new Intent(context, XiangQingActivity.class));
          }
      });
    }


    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView textView;

        public MyHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.sdv);
            textView = (TextView)itemView.findViewById(R.id.titleView);
        }
    }
}
