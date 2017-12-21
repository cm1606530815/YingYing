package com.example.yingying.presenter;


import com.example.yingying.Bean.XQ_Bean;
import com.example.yingying.moderl.HomeModer;
import com.example.yingying.moderl.IHome;
import com.example.yingying.utlis.IPresenter;
import com.example.yingying.view.Ibean_xq_View;

import java.lang.ref.SoftReference;

/**
 * Created by samsung on 2017/12/18.
 */

public class PresenterXqView implements IPresenter<Ibean_xq_View> {

    IHome home;
    SoftReference<Ibean_xq_View> softReference;

    public PresenterXqView(Ibean_xq_View view) {
        attch(view);
        home = new HomeModer();
    }

    public void showMovieXq(String mediaId) {
        home.show_Xq(new IHome.Movie_Xq() {
            @Override
            public void complete(XQ_Bean xq_bean) {
                softReference.get().show_Xq(xq_bean);
            }
        }, mediaId);

    }

    @Override
    public void attch(Ibean_xq_View view) {
        softReference = new SoftReference<Ibean_xq_View>(view);
    }

    @Override
    public void datach() {
        softReference.clear();
    }
}
