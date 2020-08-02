package com.etiantian.day05listviewdemo.entity;

public class Fruit {
    String name;
    public Fruit(String name){
        this.name = name;
    }

    public String getName() {
        if (name == null) return "";
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
