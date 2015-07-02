package com.daimajia.slider.demo.util;

import com.daimajia.slider.demo.R;
import com.daimajia.slider.demo.model.GridViewItem;

import java.util.ArrayList;

/**
 * Created by soulivanh on 6/28/15 AD.
 */
public class UiHelper {

    public static ArrayList<GridViewItem> getHomeScreenItems() {

        GridViewItem weather = new GridViewItem(R.drawable.weather, GridViewItem.ItemType.WEATHER, "Weather");
        GridViewItem guest_service = new GridViewItem(R.drawable.guest_service, GridViewItem.ItemType.GUEST_SERVICE, "Guest Services");
        GridViewItem map = new GridViewItem(R.drawable.map, GridViewItem.ItemType.MAP, "Map");
        GridViewItem kodi = new GridViewItem(R.drawable.google_play, GridViewItem.ItemType.KODI, "Google Play");
        GridViewItem browser = new GridViewItem(R.drawable.browser, GridViewItem.ItemType.BROWSER, "Browser");
        GridViewItem logo = new GridViewItem(R.drawable.bird, GridViewItem.ItemType.LOGO, "");

        GridViewItem spacer = new GridViewItem(R.drawable.icon_spacer, GridViewItem.ItemType.NONE, "");
        GridViewItem exit = new GridViewItem(R.drawable.exit, GridViewItem.ItemType.EXIT, "Exit");


        ArrayList<GridViewItem> items = new ArrayList<GridViewItem>();
        items.add(logo);
        items.add(weather);
        items.add(guest_service);
        items.add(map);
        items.add(kodi);
        items.add(browser);
        items.add(exit);

        return items;

    }
}
