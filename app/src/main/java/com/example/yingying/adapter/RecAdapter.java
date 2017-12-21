package com.example.yingying.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.yingying.Bean.MyBean;
import com.example.yingying.R;

import java.util.List;

/**
 * Created by samsung on 2017/12/19.
 */

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.MyHolder> {
    Context context;
    List<MyBean.RetBean.ListBean.ChildListBean> list;

    public RecAdapter(Context context, List<MyBean.RetBean.ListBean.ChildListBean> childList) {
        this.context=context;
        this.list=childList;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.jianjie_item, null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.imageView.setImageURI(Uri.parse(list.get(position).getPic()));
        holder.textView.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView textView;

        public MyHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.jj_sdv);
            textView = (TextView) itemView.findViewById(R.id.jj_tv);
        }
    }
}
