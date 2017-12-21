package com.example.yingying.utlis;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
/**
 * Created by samsung on 2017/12/18.
 */

public abstract class BaseActivity<T extends IPresenter> extends FragmentActivity {
    T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createpresenter();

    }

    protected abstract void createpresenter();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.datach();
        }
    }
}
