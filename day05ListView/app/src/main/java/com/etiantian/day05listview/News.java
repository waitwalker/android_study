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
    News(String title, String content) {
        this.title = title;
        this.content = content;
    }


}
