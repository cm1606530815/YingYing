package com.example.yingying.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yingying.R;

/**
 * Created by samsung on 2017/12/14.
 */

public class Fragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view=View.inflate(getActivity(), R.layout.fragment2,null);

        return view;
    }
}
