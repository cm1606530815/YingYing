package com.example.yingying.presenter;

import android.os.IBinder;

import com.example.yingying.Bean.MyBean;
import com.example.yingying.moderl.HomeModer;
import com.example.yingying.moderl.IHome;
import com.example.yingying.utlis.IPresenter;
import com.example.yingying.view.IbeanView;

import java.lang.ref.SoftReference;
import java.util.List;

/**
 * Created by samsung on 2017/12/14.
 */

public class PresenterView implements IPresenter<IbeanView> {


    IHome home;
    SoftReference<IbeanView> softReference;

    public PresenterView(IbeanView view) {
        attch(view);
        home = new HomeModer();
    }

    public void showMoview1() {
        home.show_Data1(new IHome.Movie() {
            @Override
            public void complete(List<MyBean.RetBean.ListBean> list) {
                softReference.get().showHome(list);
            }
        });
    }

    @Override
    public void attch(IbeanView view) {
        softReference = new SoftReference<IbeanView>(view);
    }

    @Override
    public void datach() {
        softReference.clear();
    }
}
