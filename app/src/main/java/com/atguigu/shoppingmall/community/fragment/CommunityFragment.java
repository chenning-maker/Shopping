package com.atguigu.shoppingmall.community.fragment;


import android.view.View;

import androidx.viewpager.widget.ViewPager;

import com.atguigu.shoppingmall.R;
import com.atguigu.shoppingmall.base.BaseFragment;
import com.atguigu.shoppingmall.community.adapter.CommunityViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

// 社区
public class CommunityFragment extends BaseFragment {

    private TabLayout tablayout;
    private ViewPager viewPager;

    @Override
    public View initView() {

        View view = View.inflate(mContext, R.layout.fragment_community, null);

        tablayout = (TabLayout) view.findViewById(R.id.tablayout);
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);

        CommunityViewPagerAdapter adapter = new CommunityViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(adapter);
        tablayout.setVisibility(View.VISIBLE);
        tablayout.setupWithViewPager(viewPager);

        return view;
    }

    @Override
    public void initData() {
        super.initData();
    }
}
