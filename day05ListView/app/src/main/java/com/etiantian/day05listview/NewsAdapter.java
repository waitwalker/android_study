package com.etiantian.day05listview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends BaseAdapter {
    List<News> mData;
    Context mContext;
    NewsAdapter(List<News> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false);
        TextView textViewImage = convertView.findViewById(R.id.text_image);
        TextView textView1 = convertView.findViewById(R.id.text1);
        TextView textView2 = convertView.findViewById(R.id.text2);
        textViewImage.setText(position);
        textView1.setText(mData.get(position).getTitle());
        textView2.setText(mData.get(position).getContent());
        return convertView;
    }
}
