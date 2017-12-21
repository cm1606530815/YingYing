package com.example.yingying.utlis;


import com.example.yingying.Bean.MyBean;
import com.example.yingying.Bean.MyBean_Jianjie;
import com.example.yingying.Bean.XQ_Bean;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by samsung on 2017/12/14.
 */

public interface ApiService {
    //http://api.svipmovie.com/front/homePageApi/homePage.do
    //首页
    @GET("front/homePageApi/homePage.do")
    Observable<MyBean> getData();

    Retrofit RETROFIT = new Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://api.svipmovie.com/").build();
    ApiService API_SERVICE = RETROFIT.create(ApiService.class);

    @GET("/front/videoDetailApi/videoDetail.do")
    Observable<XQ_Bean> getData_xq(@Query("mediaId") String mediaId);

    Retrofit RETROFIT_xq = new Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://api.svipmovie.com")
            .build();
    ApiService getApiService = RETROFIT_xq.create(ApiService.class);

    //简介
    @GET("front/videoDetailApi/videoDetail.do")
    Observable<MyBean_Jianjie> getData_jj(@Query("mediaId") String mediaId);

    Retrofit RETROFIT_jj = new Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://api.svipmovie.com/")
            .build();
    ApiService API_SERVICE_jj = RETROFIT_jj.create(ApiService.class);
}
