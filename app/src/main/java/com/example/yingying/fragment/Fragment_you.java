package com.example.yingying.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yingying.R;


/**
 * Created by samsung on 2017/12/18.
 */

public class Fragment_you extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=View.inflate(getActivity(), R.layout.fragment_you,null);

        return view;
    }
}
