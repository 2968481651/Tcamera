package com.example.tcamera.Menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tcamera.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyVIewHolder> {
    private ArrayList<String> mList;

    public MyAdapter(ArrayList<String> list) {
        mList = list;
    }

    //创建UI布局
    @NonNull
    @Override
    public MyVIewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv, parent, false);
        return new MyVIewHolder(view);
    }

    //数据和View绑定
    @Override
    public void onBindViewHolder(@NonNull MyVIewHolder holder, int position) {
//        holder.mItemText.setText(mList.get(position));
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(mListener != null) {
//                    mListener.onItemCLick(position);
//                }
//            }
//        });
    }

    //条码个数
    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyVIewHolder extends RecyclerView.ViewHolder {
        private TextView mItemText;

        public MyVIewHolder(@NonNull View itemView) {
            super(itemView);
            mItemText = itemView.findViewById(R.id.tv_item_text);
        }
    }

    OnItemClickListener mListener;
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener= listener;
    }
    public interface OnItemClickListener {
        void onItemCLick(int position);
    }
}
