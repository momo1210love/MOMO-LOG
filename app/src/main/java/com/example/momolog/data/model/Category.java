package com.example.momolog.data.model;

public class Category {

    // カテゴリーID
    private int id;

    //カテゴリー名
    private String name;

    // 画像名
    private String imageName;

    public Category(int id, String imageName) {
        this.id = id;
        this.imageName = imageName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
