package com.example.yingying.presenter;


import com.example.yingying.Bean.MyBean;
import com.example.yingying.Bean.MyBean_Jianjie;
import com.example.yingying.moderl.HomeModer;
import com.example.yingying.moderl.IHome;
import com.example.yingying.utlis.IPresenter;
import com.example.yingying.view.IbeanView_Jianjie;

import java.lang.ref.SoftReference;

import retrofit2.http.PUT;

/**
 * Created by samsung on 2017/12/19.
 */

public class PresenterView_JianJie implements IPresenter<IbeanView_Jianjie> {

    IHome home;
    SoftReference<IbeanView_Jianjie> softReference;

    public PresenterView_JianJie(IbeanView_Jianjie view) {
        attch(view);
        home = new HomeModer();
    }

    public void showHomejj(String mediaId) {
        home.show_jj(new IHome.Movie_jj() {
            @Override
            public void complete(MyBean_Jianjie myBean_jianjie) {
                softReference.get().showjianjie(myBean_jianjie);
            }
        }, mediaId);

    }


    @Override
    public void attch(IbeanView_Jianjie view) {
        softReference = new SoftReference<IbeanView_Jianjie>(view);
    }

    @Override
    public void datach() {
        softReference.clear();
    }
}
