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
        ViewHolder viewHolder = null;
        if (viewHolder == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent,false);
            viewHolder.textView1 = convertView.findViewById(R.id.text1);
            viewHolder.textView2 = convertView.findViewById(R.id.text2);
            viewHolder.textView = convertView.findViewById(R.id.text_image);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView1.setText(mData.get(position).getTitle());
        viewHolder.textView2.setText(mData.get(position).getContent());
        viewHolder.textView.setText(mData.get(position).getCurrentIndex());

        return convertView;
    }

    static class ViewHolder {
        TextView textView;
        TextView textView1;
        TextView textView2;
    }
}
