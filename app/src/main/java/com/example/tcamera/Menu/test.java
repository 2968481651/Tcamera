package com.example.tcamera.Menu;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tcamera.R;
import com.example.tcamera.data.Displaydata;

import java.util.ArrayList;

public class test extends RelativeLayout implements View.OnClickListener {
    private ImageView mDownArrow;
    private Context mContext;

    public test(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.searching_view, this, true);
        mDownArrow = findViewById(R.id.iv_down_arrow);
        mDownArrow.setOnClickListener(this);
    }
boolean cc=true;
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_down_arrow:
                showPopupwindow();
//                if(cc){
//                    mDownArrow.animate().rotation(180);
//                cc=false;
//                }
//                mDownArrow.animate().rotation(0);

                break;
        }
    }


    private RecyclerView mRecyclerView;

    private void showPopupwindow() {

        Log.d("comeOnTest", "showPopupwindow()");
        View view = LayoutInflater.from(mContext).inflate(R.layout.searching_layout, null);
        PopupWindow popupWindow = new PopupWindow(this);
        Displaydata displaydata = new Displaydata();
        int width = (int) displaydata.getData("width");
        System.out.println("获取宽为:" + width);
        popupWindow.setWidth(width);
        popupWindow.setHeight(150);
        popupWindow.setContentView(view);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
//        popupWindow.showAtLocation(mDownArrow, Gravity.TOP, 0, 0);
        popupWindow.showAsDropDown(mDownArrow, 0, -180);

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("我是条目：" + i);
        }
        mRecyclerView = view.findViewById(R.id.rv_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        MyAdapter adapter = new MyAdapter(list);
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemCLick(int position) {
                popupWindow.dismiss();
            }
        });
        mRecyclerView.setAdapter(adapter);
    }

    OnSearchingClickListener mListener;

    public void setOnItemClickListener(OnSearchingClickListener listener) {
        mListener = listener;
    }

    public interface OnSearchingClickListener {
        void onSearchingCLick(String content);
    }
}
