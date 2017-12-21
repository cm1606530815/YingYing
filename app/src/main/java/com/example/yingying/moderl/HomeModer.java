package com.example.yingying.moderl;


import com.example.yingying.Bean.MyBean;
import com.example.yingying.Bean.MyBean_Jianjie;
import com.example.yingying.Bean.XQ_Bean;
import com.example.yingying.utlis.ApiService;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by samsung on 2017/12/14.
 */

public class HomeModer implements IHome {

    //首页
    @Override
    public void show_Data1(final Movie movie) {
        ApiService.API_SERVICE.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MyBean myBean) {
                        final List<MyBean.RetBean.ListBean> list = myBean.getRet().getList();
                        movie.complete(list);

                    }
                });
    }

    @Override
    public void show_Xq(final Movie_Xq movie_xq, String mediaId) {
        ApiService.getApiService.getData_xq(mediaId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<XQ_Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(XQ_Bean xq_bean) {
                        movie_xq.complete(xq_bean);
                    }
                });
    }

    @Override
    public void show_jj(final Movie_jj movie_jj, String mediaId) {
        ApiService.API_SERVICE_jj.getData_jj(mediaId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyBean_Jianjie>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MyBean_Jianjie myBean_jianjie) {
                        movie_jj.complete(myBean_jianjie);
                    }
                });
    }


}
