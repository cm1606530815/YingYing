package com.example.yingying.moderl;


import com.example.yingying.Bean.MyBean;
import com.example.yingying.Bean.MyBean_Jianjie;
import com.example.yingying.Bean.XQ_Bean;

import java.util.List;

/**
 * Created by samsung on 2017/12/14.
 */

public interface IHome {
    //首页
    void show_Data1(Movie movie);

    interface Movie {
        void complete(List<MyBean.RetBean.ListBean> list);
    }

    void show_Xq(Movie_Xq movie_xq, String mediaId);

    interface Movie_Xq {
        void complete(XQ_Bean xq_bean);
    }

    //简介
    void show_jj(Movie_jj movie_jj, String mediaId);

    interface Movie_jj {
        void complete(MyBean_Jianjie myBean_jianjie);
    }
}
