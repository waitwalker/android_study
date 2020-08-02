package com.etiantian.day05listviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.etiantian.day05listviewdemo.R;
import com.etiantian.day05listviewdemo.entity.Fruit;

import java.util.List;

public class FruitAdapter extends ArrayAdapter {

    int resourceId;
    List<Fruit> data;
    Context context;

    public FruitAdapter(Context context, int resourceId, List<Fruit> data) {
        super(context, resourceId, data);
        this.context = context;
        this.resourceId = resourceId;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = (Fruit) getItem(position);
        View view;
        ViewHolder viewHolder = null;
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resourceId,null);
            viewHolder = new ViewHolder();
            viewHolder.fruitName = view.findViewById(R.id.fruit_item);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }

    class ViewHolder {
        TextView fruitName;
    }
}
