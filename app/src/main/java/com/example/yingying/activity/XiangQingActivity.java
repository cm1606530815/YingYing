package com.example.yingying.activity;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;


import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.example.yingying.Bean.EventbusMessager;
import com.example.yingying.Bean.XQ_Bean;
import com.example.yingying.R;
import com.example.yingying.fragment.Fragment_Zuo;
import com.example.yingying.fragment.Fragment_you;
import com.example.yingying.presenter.PresenterXqView;
import com.example.yingying.utlis.BaseActivity;
import com.example.yingying.view.Ibean_xq_View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class XiangQingActivity extends BaseActivity<PresenterXqView> implements Ibean_xq_View {

    private String dataid;
    PresenterXqView presenter;
    private String sdurl;
    PlayerView play;
    String str = "";
    List<Fragment> list_frag;
    List<String> title;
    private TabLayout mTablayout;
    private ViewPager mViewPager;

    @BindView(R.id.manage_viewpager_weidenglu)
    ViewPager manageViewpagerWeidenglu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_qing);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        presenter.showMovieXq(str);

        //找控件
        initViews();

    }

    private void initViews() {
        mTablayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            private String[] mTitles = new String[]{"简介", "评论"};

            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    return new Fragment_Zuo();
                } else if (position == 1) {
                    return new Fragment_you();
                }


                return null;
            }

            @Override
            public int getCount() {
                return mTitles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }
        });
        mTablayout.setupWithViewPager(mViewPager);


    }


    @Subscribe(sticky = true)
    public void onmessager(EventbusMessager eventbusMessager) {
        str = eventbusMessager.getPosition();

    }

    @Override
    protected void createpresenter() {
        presenter = new PresenterXqView(this);
    }

    @Override
    public void show_Xq(XQ_Bean xq_bean) {
        String url = xq_bean.getRet().getSmoothURL();
        String title = xq_bean.getRet().getTitle();
        play = new PlayerView(this)
                .setTitle(title)
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .setPlaySource(url);
        play.startPlay();

    }

    //当你离开播放界面的时候视频停止播放
    @Override
    protected void onStop() {
        super.onStop();
        play.stopPlay();
    }


}
