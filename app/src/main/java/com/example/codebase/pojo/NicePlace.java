package com.example.codebase.pojo;

public class NicePlace {
    String imagePath;
    String placeDesc;

    public NicePlace(String imagePath, String placeDesc) {
        this.imagePath = imagePath;
        this.placeDesc = placeDesc;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getPlaceDesc() {
        return placeDesc;
    }

    public void setPlaceDesc(String placeDesc) {
        this.placeDesc = placeDesc;
    }
}
