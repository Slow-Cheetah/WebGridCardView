package com.example.webgridcardview;

import android.net.Uri;

import java.io.Serializable;

public class GridViewModal implements Serializable{
    private String name;
    private int image;

    private String adress;

    public GridViewModal(String name, int image, String url) {
        this.name = name;
        this.image = image;
        this.adress = url;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getAdress() {return adress;}

}
