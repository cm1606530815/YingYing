package com.example.yingying.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.yingying.Bean.MyBean;
import com.example.yingying.Bean.MyBean_Jianjie;
import com.example.yingying.R;
import com.example.yingying.adapter.RecAdapter;
import com.example.yingying.presenter.PresenterView_JianJie;
import com.example.yingying.utlis.BaseFragment;
import com.example.yingying.view.IbeanView_Jianjie;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by samsung on 2017/12/18.
 */

public class Fragment_Zuo extends BaseFragment<PresenterView_JianJie> implements IbeanView_Jianjie {

    PresenterView_JianJie presenter;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    Unbinder unbinder;
    @BindView(R.id.rec_jj)
    RecyclerView recJj;
    private RecAdapter recAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_zuo, null);
        SharedPreferences spf = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        String dataid = spf.getString("dataid", null);
        presenter.showHomejj(dataid);
//        presenter.showHome_shipin();
        unbinder = ButterKnife.bind(this, view);
        recJj.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        return view;
    }

    @Override
    public void showjianjie(MyBean_Jianjie myBean_jianjie) {
        String description = myBean_jianjie.getRet().getDescription();
        String director = myBean_jianjie.getRet().getDirector();
        String actors = myBean_jianjie.getRet().getActors();
        tv1.setText(description);
        tv2.setText(director);
        tv3.setText(actors);
    }

    @Override
    public void show_shipin(MyBean myBean) {
        List<MyBean.RetBean.ListBean.ChildListBean> childList = myBean.getRet().getList().get(0).getChildList();

        recAdapter = new RecAdapter(getActivity(), childList);
        recJj.setAdapter(recAdapter);
    }

    @Override
    protected void createpresenter() {
        presenter = new PresenterView_JianJie(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.datach();
    }
}
