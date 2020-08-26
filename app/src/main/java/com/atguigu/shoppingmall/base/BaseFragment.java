package com.atguigu.shoppingmall.base;

import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


//基类Fragment：
public abstract class BaseFragment extends Fragment {
    public Context mContext;

    //当系统创建Fragment时调用
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = getActivity();
    }

    //添加布局文件时调用
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return initView();
    }

    //当Activity创建时调用
    //该方法一定在onCreateView（）之后进行，创建ＵＩ－显示ＵＩ,处理数据
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //请求数据
        initData();
    }

    /**
     * 由子类实现，实现特有效果
     * @return
     */
    public abstract View initView();

    /**
     * 初始化数据
     * 当子类需要联网请求时，可以重写该方法，在该方法中进行联网请求
     */
    public void initData() {

    }
}
