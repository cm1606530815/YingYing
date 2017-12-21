package com.example.yingying.utlis;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;


/**
 * Created by samsung on 2017/12/14.
 */

public abstract class BaseFragment<T extends IPresenter> extends Fragment {
    T presentre;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createpresenter();
    }

    protected abstract void createpresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presentre != null) {
            presentre.datach();
        }
    }
}
