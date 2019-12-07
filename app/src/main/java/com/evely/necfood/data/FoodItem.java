package com.evely.necfood.data;

public class FoodItem {

    public int rating;

    public String desc;

    public int imgResId;

    public boolean selected;

    /**
     * get a similar but cloned object.
     * @return
     */
    public FoodItem getClone()
    {
        FoodItem item = new FoodItem();
        item.rating = rating;
        item.desc = desc;
        item.imgResId = imgResId;
        item.selected = selected;
        return item;
    }

    public FoodItem()
    {

    }

    public FoodItem(String desc, int rating,
                    int imgResId, boolean selected)
    {
        this.desc = desc;
        this.rating = rating;
        this.imgResId = imgResId;
        this.selected = selected;
    }

}
