package com.etiantian.day05gridview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.etiantian.day05gridview.R;
import com.etiantian.day05gridview.entity.News;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {
    Context context;
    List<News> data;
    public GridViewAdapter(Context context, List<News> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
            viewHolder.title = convertView.findViewById(R.id.text_title);
            viewHolder.textImage = convertView.findViewById(R.id.text_image);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.title.setText(data.get(position).getTitle());
        viewHolder.textImage.setText(data.get(position).getContent());
        return convertView;
    }

    static class ViewHolder {
        TextView title;
        TextView textImage;
    }
}
