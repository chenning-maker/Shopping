package com.example.opendanmaku;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.opendanmaku.DanmakuItem;
import com.opendanmaku.DanmakuView;
import com.opendanmaku.IDanmakuItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener{

    private DanmakuView mDanmakuView;
    private Button switcher;
    private Button send;
    private EditText text;
    private TextView textView;
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //实例化控件
        mDanmakuView=findViewById(R.id.danmakuView);
        switcher=findViewById(R.id.switcher);
        send=findViewById(R.id.send);
        text=findViewById(R.id.text);
        textView=findViewById(R.id.title);
        videoView=findViewById(R.id.videoView);

        //播放视频设置
        setVideoView();

        //设置标题
        textView.setText("弹幕Play");

        List<IDanmakuItem> list=initItems();
        //将集合中的数据变成随机数据：打乱弹幕条的顺序（并非按i的从大到小）
        Collections.shuffle(list);

        //加入弹幕控件中：true？：是否新建后台线程来执行添加任务（否则会在主线程中执行）
        mDanmakuView.addItem(list,true);

        switcher.setOnClickListener(this);
        send.setOnClickListener(this);






    }

    //设置播放视频
    private void setVideoView() {

        //1，设置准备好了的监听
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoView.start();//底层准备好了之后，开始播放
            }
        });

        //2，设置播放完成的监听：
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.start();//继续播放
            }
        });

        //3，设置播放出错的监听
        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {

               Toast.makeText(MainActivity.this,"播放出错了！",Toast.LENGTH_LONG).show();
                return false; //弹出对话框 return true：不弹

            }
        });

        //4，设置控制面板
        videoView.setMediaController(new MediaController(this));

        //5，设置播放地址：
        videoView.setVideoPath("http://vfx.mtime.cn/Video/2016/12/12/mp4/161212190638286683_480.mp4");


    }

    /*构建弹幕的数据集合*/
    private List<IDanmakuItem> initItems() {
        List<IDanmakuItem> list=new ArrayList<>();

        //创建100条纯文本弹幕
        for (int i=0;i<100;i++){
            //最后一个参数：起始坐标
            IDanmakuItem item=new DanmakuItem(this,i+": plain text danmaku",mDanmakuView.getWidth());
            list.add(item);
        }

        //创建100条图文混排的弹幕
        String msg=":  text with image  ";
        for (int i=0;i<100;i++){
            ImageSpan imageSpan=new ImageSpan(this,R.drawable.em);

            //SpannableString:让文本和图片形成一个整体。
            SpannableString spannableString=new SpannableString(i + msg);
            spannableString.setSpan(imageSpan,spannableString.length()-2,spannableString.length()-1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            IDanmakuItem item=new DanmakuItem(this,spannableString,mDanmakuView.getWidth(),0,0,0,1.5f);
            list.add(item);
        }

        return list;


    }

    @Override
    protected void onResume() {
        super.onResume();
        mDanmakuView.show();//显示弹幕
    }


    @Override
    protected void onPause() {
        super.onPause();
        mDanmakuView.hide();//隐藏弹幕
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDanmakuView.clear();//清除弹幕
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.switcher:
                if (mDanmakuView.isPaused()){
                    //原先的
                    switcher.setText(R.string.hide);
                    //点击之后关闭
                    mDanmakuView.show();

                }else {
                    switcher.setText(R.string.show);
                    mDanmakuView.hide();
                }

                break;
            case R.id.send:
                String input=text.getText().toString();
                if (TextUtils.isEmpty(input)){
                    Toast.makeText(this,R.string.empty_prompt,Toast.LENGTH_LONG).show();
                }else {
                    IDanmakuItem item=new DanmakuItem(this,new SpannableString(input),mDanmakuView.getWidth(),0,R.color.my_item_color,0,1);
                    mDanmakuView.addItemToHead(item);
                }

                text.setText("");
                break;
        }


    }
}
