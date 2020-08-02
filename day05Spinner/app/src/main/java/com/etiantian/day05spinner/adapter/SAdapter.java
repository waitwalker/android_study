package com.etiantian.day05spinner.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.etiantian.day05spinner.R;
import com.etiantian.day05spinner.entity.RegionModel;

import java.util.List;

public class SAdapter extends BaseAdapter {

    Context context;
    List<RegionModel> data;
    public SAdapter(Context context, List<RegionModel> data) {
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
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_layout, parent,false);
            viewHolder.textView = convertView.findViewById(R.id.text_title);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(data.get(position).getTitle());
        return convertView;
    }

    static class ViewHolder {
        TextView textView;
    }
}
