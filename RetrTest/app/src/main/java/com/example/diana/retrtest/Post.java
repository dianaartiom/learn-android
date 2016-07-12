package com.example.diana.retrtest;

/**
 * Created by diana on 7/12/16.
 */
public class Post {
    public int userId;
    public int id;
    public String title;
    public String body;

    public Post() { }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int user_Id) {
        this.userId = user_Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
