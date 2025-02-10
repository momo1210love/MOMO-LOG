package com.example.momolog.data.model;

public class StoreInfo {

    // 店舗ID
    private long id;

    // 店舗名
    private String name;

    // 住所
    private String address;

    // 電話番号
    private String tel;

    // 営業時間
    private String openTime;

    // 定休日
    private String holiday;

    // カテゴリーID
    private long categoryId;

    // 画像名
    private String imageName;

    public StoreInfo(int id, String name, String address, String tel, String openTime, String holiday, int categoryId, String imageName) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.openTime = openTime;
        this.holiday = holiday;
        this.categoryId = categoryId;
        this.imageName = imageName;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getHoliday() {
        return holiday;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
