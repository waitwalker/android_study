package com.etiantian.day05expandablelistview.entity;

public class Item {
    int itemId;
    String iName;

    public Item(int itemId, String iName) {
        this.itemId = itemId;
        this.iName = iName;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }
}
