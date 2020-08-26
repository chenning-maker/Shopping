package com.atguigu.shoppingmall.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;

import com.atguigu.shoppingmall.R;

public class WelcomActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);

        //设置2s后进入主页面：
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //在主线程执行
                //启动主页面
                startActivity(new Intent(WelcomActivity.this, MainActivity.class));

                //关闭当前页面
                finish();

            }
        },2000);
    }
}
