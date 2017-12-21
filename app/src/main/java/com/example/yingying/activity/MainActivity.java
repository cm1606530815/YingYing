package com.example.yingying.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.yingying.R;
import com.example.yingying.fragment.Fragment1;
import com.example.yingying.fragment.Fragment2;
import com.example.yingying.fragment.Fragment3;
import com.example.yingying.fragment.Fragment4;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.btn1)
    RadioButton btn1;
    @BindView(R.id.btn2)
    RadioButton btn2;
    @BindView(R.id.btn3)
    RadioButton btn3;
    @BindView(R.id.btn4)
    RadioButton btn4;
    @BindView(R.id.rg)
    RadioGroup rg;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Fragment fragment1;
    private Fragment f2;
    private Fragment f3;
    private Fragment f4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            //设置透明,当然还可以根据你的需求来设置颜色。
            getWindow().setStatusBarColor(Color.TRANSPARENT);
            // 注意还需要在 xml 布局里 指定  android:fitsSystemWindows="true" 属性，注意是你当前布局倒数第二级的布局里添加，不然发                生错位的问题。
        }
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        /**
         * 拿到事务管理器并开启事务
         */
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        /**
         * 启动默认选中第一个
         */
        rg.check(R.id.btn1);
        Fragment f1 = new Fragment1();
        transaction.replace(R.id.fl_content, f1);
        transaction.commit();
    }


    @OnClick({R.id.fl_content, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.rg})
    public void onViewClicked(View view) {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        switch (view.getId()) {
            case R.id.fl_content:
                break;

            case R.id.btn1:
                hideFragment(transaction);
                fragment1 = new Fragment1();
                transaction.replace(R.id.fl_content, fragment1);
                transaction.commit();
                break;
            case R.id.btn2:
                hideFragment(transaction);
                f2 = new Fragment2();
                transaction.replace(R.id.fl_content, f2);
                transaction.commit();
                break;
            case R.id.btn3:
                hideFragment(transaction);
                f3 = new Fragment3();
                transaction.replace(R.id.fl_content, f3);
                transaction.commit();
                break;
            case R.id.btn4:
                hideFragment(transaction);
                f4 = new Fragment4();
                transaction.replace(R.id.fl_content, f4);
                transaction.commit();
                break;
            default:
                break;
        }

    }

    private void hideFragment(FragmentTransaction transaction) {

        if (fragment1 != null) {
            //transaction.hide(f1);隐藏方法也可以实现同样的效果，不过我一般使用去除
            transaction.remove(fragment1);
        }
        if (f2 != null) {
            //transaction.hide(f2);
            transaction.remove(f2);
        }
        if (f3 != null) {
            //transaction.hide(f3);
            transaction.remove(f3);
        }
        if (f4 != null) {
            //transaction.hide(f4);
            transaction.remove(f4);
        }



    }
}
