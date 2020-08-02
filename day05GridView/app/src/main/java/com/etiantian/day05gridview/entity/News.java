package com.etiantian.day05gridview.entity;

public class News {
    String title;
    String content;
    String currentItemIndex;

    public News(String title, String content, String currentItemIndex) {
        this.title = title;
        this.content = content;
        this.currentItemIndex = currentItemIndex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCurrentItemIndex() {
        return currentItemIndex;
    }

    public void setCurrentItemIndex(String currentItemIndex) {
        this.currentItemIndex = currentItemIndex;
    }
}
