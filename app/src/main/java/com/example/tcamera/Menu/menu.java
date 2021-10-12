package com.example.tcamera.Menu;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tcamera.R;

import java.util.ArrayList;

public class menu extends RelativeLayout {
    private ImageView mDownArrow;
    private Context mContext;
    private EditText mEditText;
    private ImageView mSearching;
    private RecyclerView mRecyclerView;
    public menu(Context context, AttributeSet attrs) {
        super(context, attrs);
        showPopupwindow();
    }
    private void showPopupwindow() {
        Log.d("comeOnTest", "showPopupwindow()");
        View view = LayoutInflater.from(mContext).inflate(R.layout.searching_layout, null);
        PopupWindow popupWindow = new PopupWindow(this);
        popupWindow.setWidth(600);
        popupWindow.setHeight(150);
        popupWindow.setContentView(view);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.showAsDropDown(mDownArrow, 0, 0);

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("我是条目：" + i);
        }
        mRecyclerView = view.findViewById(R.id.rv_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        MyAdapter adapter = new MyAdapter(list);
        popupWindow.dismiss();
        mRecyclerView.setAdapter(adapter);

//        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
//            @Override
//            public void onItemCLick(int position) {
////                mEditText.setText(list.get(position));
//                popupWindow.dismiss();
//            }
//        });

    }
//    test.OnSearchingClickListener mListener;
//
//    public interface OnSearchingClickListener {
//        void onSearchingCLick(String content);
//    }
}
