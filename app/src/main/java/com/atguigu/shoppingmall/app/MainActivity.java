package com.atguigu.shoppingmall.app;

import android.os.Bundle;

import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.atguigu.shoppingmall.R;
import com.atguigu.shoppingmall.base.BaseFragment;
import com.atguigu.shoppingmall.community.fragment.CommunityFragment;
import com.atguigu.shoppingmall.home.fragment.HomeFragment;
import com.atguigu.shoppingmall.shoppingcart.fragment.ShoppingCartFragment;
import com.atguigu.shoppingmall.type.fragment.TypeFragment;
import com.atguigu.shoppingmall.user.fragment.UserFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

// 主页面
public class MainActivity extends FragmentActivity {

    @Bind(R.id.frameLayout)
    FrameLayout frameLayout;
    @Bind(R.id.rg_main)
    RadioGroup rgMain;

    //装了多个Fragment的集合
    private ArrayList<BaseFragment> fragments;
    private int position=0;
    private TypeFragment typeFragment;
    private BaseFragment mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //默认选中首页
       // rgMain.check(R.id.rb_home);



        //去除title
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //去掉Activity上面的状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        //ButterKnife和Activity绑定：
        ButterKnife.bind(this);
        initFragment();
        initListener();
    }

    private void initFragment() {

        fragments = new ArrayList<>();
        typeFragment = new TypeFragment();
        fragments.add(new HomeFragment());    //有顺序的放
        fragments.add(typeFragment);
        fragments.add(new CommunityFragment());
        fragments.add(new ShoppingCartFragment());
        fragments.add(new UserFragment());
    }


    //设置RadioGroup的监听，监听各个Fragment的切换
    private void initListener() {

        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.rb_home:

                        //选中首页时，position为0
                        position = 0;

                        break;

                    case R.id.rb_type:
                        position = 1;
                        break;

                    case R.id.rb_community:
                        position = 2;
                        break;

                    case R.id.rb_cart:
                        position = 3;
                        break;

                    case R.id.rb_user:
                        position = 4;
                        break;

                        default:
                            position=0;
                            break;
                }

                BaseFragment baseFragment = getFragment(position);
                switchFragment(mContext, baseFragment);
            }
        });

        rgMain.check(R.id.rb_home);
    }



    /*根据不同的位置取不同的Fragment：*/
    private BaseFragment getFragment(int position) {

        if (fragments != null && fragments.size() > 0) {
            BaseFragment baseFragment = fragments.get(position);
            return baseFragment;
        }

        return null;
    }

    /*切换Fragment：
    * 参数：上次显示的Fragment；当前正要显示的Fragment*/
    private void switchFragment(Fragment fromFragment, BaseFragment nextFragment) {

        //第一次和第二次点击的RadioButton不一样时，切换到第二次的
        if (mContext != nextFragment) {

            mContext = nextFragment;

            if (nextFragment != null) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();//若本Activity extends Activity时这里会报错，必须是FragmentActivity

                //判断nextFragment是否添加
                if (!nextFragment.isAdded()) {

                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.add(R.id.frameLayout, nextFragment).commit(); //添加上nextFragment
                } else {

                    //已添加则显示nextFragment
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }
    }
}
