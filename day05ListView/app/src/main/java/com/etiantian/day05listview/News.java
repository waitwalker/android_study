package com.etiantian.day05listview;

public class News {
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

    String title;
    String content;

    public String getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(String currentIndex) {
        this.currentIndex = currentIndex;
    }

    String currentIndex;
    News(String title, String content, String currentIndex) {
        this.title = title;
        this.content = content;
        this.currentIndex = currentIndex;
    }


}
