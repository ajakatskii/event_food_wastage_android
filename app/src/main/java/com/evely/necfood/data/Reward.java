package com.evely.necfood.data;

public class Reward {

    public String name;

    public String desc;

    public int coins;

    public boolean selected;

    public int imgResId;

    public Reward(String name, String desc,
                  int coins, boolean selected,
                  int imgResId)
    {
        this.name = name;
        this.desc = desc;
        this.coins = coins;
        this.selected = selected;
        this.imgResId = imgResId;
    }

}
