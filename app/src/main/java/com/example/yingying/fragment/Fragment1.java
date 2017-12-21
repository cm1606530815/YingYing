package com.example.yingying.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yingying.Bean.MyBean;
import com.example.yingying.ImagGithub.ImgGithub;
import com.example.yingying.R;
import com.example.yingying.adapter.MyAdapter;
import com.example.yingying.presenter.PresenterView;
import com.example.yingying.utlis.BaseFragment;
import com.example.yingying.view.IbeanView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by samsung on 2017/12/14.
 */

public class Fragment1 extends BaseFragment<PresenterView> implements IbeanView {
    PresenterView presenter;
    @BindView(R.id.banner)
    Banner banner;
    Unbinder unbinder;

    List<String> list;
    List<String> list1;
    private List<String> lists;
    private String dataId;
    private MyAdapter myAdapter;
    private SwipeRefreshLayout mSwipeRefreshWidget;
    private RecyclerView rec;
    List<String> mData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment1, null);
        presenter.showMoview1();
        rec = (RecyclerView) view.findViewById(android.R.id.list);
        unbinder = ButterKnife.bind(this, view);
        mSwipeRefreshWidget = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_widget);
        rec = (RecyclerView) view.findViewById(android.R.id.list);

        rec.setLayoutManager(new LinearLayoutManager(getActivity()));
        // 这句话是为了，第一次进入页面的时候显示加载进度条
        mSwipeRefreshWidget.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
        mSwipeRefreshWidget.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //我在List最前面加入一条数据
                presenter.showMoview1();
                //数据重新加载完成后，提示数据发生改变，并且设置现在不在刷新
                myAdapter.notifyDataSetChanged();
                mSwipeRefreshWidget.setRefreshing(false);


            }
        });
        return view;
    }


//    @Override
//    public void showHome(MyBean myBean) {
//
//        List<MyBean.RetBean.ListBean> list = myBean.getRet().getList();
//
//        for (int i = 0; i < list.size(); i++) {
//            dataId = list.get(i).getChildList().get(i).getDataId();
//            banner.setImageLoader(new ImgGithub());
//            this.list.add(list.get(i).getChildList().get(i).getPic());
//            banner.setImages(this.list);
//            banner.start();
//
//
//        }
//        SharedPreferences spf = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
//        spf.edit().putString("dataid", dataId).commit();
//        myAdapter = new MyAdapter(getActivity(), list);
//        rec.setAdapter(myAdapter);
//        myAdapter.notifyDataSetChanged();
//
//    }

    @Override
    protected void createpresenter() {
        presenter = new PresenterView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.datach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.swipe_refresh_widget)
    public void onViewClicked() {


    }

    @Override
    public void showHome(List<MyBean.RetBean.ListBean> list) {
        list1 = new ArrayList<String>();
        for (int i = 0; i <list.size() ; i++) {
            dataId = list.get(i).getChildList().get(0).getDataId();
            list1.add(list.get(i).getChildList().get(0).getPic());
        }
        banner.setImageLoader(new ImgGithub());
        banner.setImages(list1);
        banner.start();
        SharedPreferences spf = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        spf.edit().putString("dataid", dataId).commit();
        myAdapter = new MyAdapter(getActivity(), list);
        rec.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }
}
