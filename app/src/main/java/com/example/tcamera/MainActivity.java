package com.example.tcamera;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tcamera.Menu.test;
import com.example.tcamera.data.Displaydata;

public class MainActivity extends AppCompatActivity implements test.OnSearchingClickListener{
    private test mSearching;
    private static final String TAG = "PlayActivity";
    private String path, name;
    private ImageView btn;
    private ImageView camera;
    private ImageView change;
    int x = 0;



    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case 0:
//                    mProgressBar.setVisibility(View.GONE);
//                    mTextContent.setVisibility(View.VISIBLE);
//                    mTextContent.setText("显示搜索结果");
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Log.d(TAG, "onCreate: ");

        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();//去除标题栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//去除状态栏
        mSearching = findViewById(R.id.test);
        mSearching.setOnItemClickListener(this);

        Point outSize = new Point();
        getWindowManager().getDefaultDisplay().getRealSize(outSize);
        Displaydata Displaydata=new Displaydata();
        Displaydata.setData("width",outSize.x);
        Displaydata.setData("height",outSize.y);
        System.out.println("宽="+outSize.x+"高="+outSize.y);


    }


    @Override
    public void onSearchingCLick(String content) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(5000);
                handler.sendEmptyMessage(0);
            }
        }).start();
    }
}