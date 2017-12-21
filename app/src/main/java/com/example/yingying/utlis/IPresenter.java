package com.example.yingying.utlis;

/**
 * Created by samsung on 2017/12/14.
 */

public interface IPresenter<T> {
    void attch(T view);

    void datach();
}
