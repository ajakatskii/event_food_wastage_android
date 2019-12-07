package com.evely.necfood.data;

import android.graphics.Bitmap;
import android.media.Image;

import java.util.Date;

public class Feed {

    public String description;

    public double foodWastage;

    public String name;

    public Date postDate;

    public Bitmap image;

    public int profileImgResId;

    public Feed(String desc, double foodWastage,
                String name, Date postDate,
                Bitmap image, int profileImgResId)
    {
        this.description = desc;
        this.foodWastage = foodWastage;
        this.name = name;
        this.postDate = postDate;
        this.image = image;
        this.profileImgResId = profileImgResId;
    }

}
