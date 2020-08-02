package com.etiantian.day05expandablelistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.etiantian.day05expandablelistview.R;
import com.etiantian.day05expandablelistview.entity.Group;
import com.etiantian.day05expandablelistview.entity.Item;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MExpandableListAdapter extends BaseExpandableListAdapter {
    ArrayList <Group> gData;
    ArrayList <ArrayList<Item>> iData;
    Context context;

    public MExpandableListAdapter(Context context, ArrayList<Group> gData, ArrayList<ArrayList<Item>> iData) {
        this.gData = gData;
        this.iData = iData;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return gData.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return iData.get(groupPosition).size();
    }

    @Override
    public Group getGroup(int groupPosition) {
        return gData.get(groupPosition);
    }

    @Override
    public Item getChild(int groupPosition, int childPosition) {
        return iData.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.group_layout,parent,false);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.textView = convertView.findViewById(R.id.text_group);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        groupViewHolder.textView.setText(gData.get(groupPosition).getgName());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
            viewHolder.textView = convertView.findViewById(R.id.text_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(iData.get(groupPosition).get(childPosition).getiName());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    static class GroupViewHolder {
        TextView textView;
    }

    static class ViewHolder {
        TextView textView;
    }
}
