package com.example.demo.model;

public class Blog {
    int id;
    String text;
    int userid;

    public Blog() {
    }

    public Blog(int id, String text){
        this.id = id;
        this.text = text;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
