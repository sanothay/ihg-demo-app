package com.daimajia.slider.demo.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by soulivanh on 6/15/15 AD.
 */
public class GridViewItem {

    public enum ItemType {

        WEATHER,
        GUEST_SERVICE,
        MAP,
        PLAN,
        KODI,
        BROWSER,
        LOGO,
        EXIT,
        SUMMARY,
        NONE
    }

    private int imgRes;
    private ItemType type;
    private String title;

    public GridViewItem(int imgRes, ItemType type, String title) {
        this.imgRes = imgRes;
        this.type = type;
        this.title = title;
    }

    public int getImgRes() {
        return imgRes;
    }

    public ItemType getType() {
        return type;
    }
    public String getTitle() {return title;}

    @Override
    public String toString() {
        return "GridViewItem{" +
                "type=" + type.name() +
                '}';
    }
}