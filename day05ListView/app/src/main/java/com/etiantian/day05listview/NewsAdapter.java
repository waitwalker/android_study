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

    private static final int kType_news_1 = 0;
    private static final int kType_news_2 = 1;
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

    // 返回相应的item类型
    @Override
    public int getItemViewType(int position) {
        if (position %2 == 0) {
            return kType_news_1;
        } else {
            return kType_news_2;
        }
    }

    // item 类型
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        ViewHolder2 viewHolder2 = null;
        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case kType_news_1:
                    viewHolder = new ViewHolder();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent,false);
                    viewHolder.textView1 = convertView.findViewById(R.id.text1);
                    viewHolder.textView2 = convertView.findViewById(R.id.text2);
                    viewHolder.textView = convertView.findViewById(R.id.text_image);
                    convertView.setTag(viewHolder);
                    break;
                case kType_news_2:
                    viewHolder2 = new ViewHolder2();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_type2_layout, parent,false);
                    viewHolder2.textView = convertView.findViewById(R.id.text3);
                    convertView.setTag(viewHolder2);
                    break;
            }

        } else {
            switch (type) {
                case kType_news_1:
                    viewHolder = (ViewHolder) convertView.getTag();
                    break;
                case  kType_news_2:
                    viewHolder2 = (ViewHolder2) convertView.getTag();
                    break;
            }
        }

        switch (type) {
            case kType_news_1:
                viewHolder.textView1.setText(mData.get(position).getTitle());
                viewHolder.textView2.setText(mData.get(position).getContent());
                viewHolder.textView.setText(mData.get(position).getCurrentIndex());
                break;
            case kType_news_2:
                viewHolder2.textView.setText(mData.get(position).getTitle());
                break;
        }

        return convertView;
    }

    static class ViewHolder {
        TextView textView;
        TextView textView1;
        TextView textView2;
    }

    static class ViewHolder2 {
        TextView textView;
    }
}
