package com.evely.necfood.data;

import com.evely.necfood.data.collections.FeedCollection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * an event
 */
public class Event {

    public boolean isOngoing;

    public boolean willAttend;

    public String name;

    private boolean menuSelected;

    public int peopleComing;

    public int avgStars;

    public int userStars;

    public Date date;

    public int profileResourceId;

    public int curCalories;

    public double curWastageScore;

    public String description;

    private HashMap<Integer, Boolean> vegOptions;

    private HashMap<Integer, Boolean> nonVegOptions;

    public ArrayList<FoodItem> veg;

    public ArrayList<FoodItem> nonVeg;

    public Event()
    {
    }

    public Event(
            String name, boolean isOngoing, boolean willAttend,
            boolean isMenuSelected, int peopleComing, int avgStars,
            int userStars, Date date, int profileResourceId, int curCalories,
            double curWastageScore, String description
            ) {
        this.name = name;
        this.isOngoing = isOngoing;
        this.willAttend = willAttend;
        this.menuSelected = isMenuSelected;
        this.peopleComing = peopleComing;
        this.avgStars = avgStars;
        this.userStars = userStars;
        this.date = date;
        this.profileResourceId = profileResourceId;
        this.curCalories = curCalories;
        this.curWastageScore = curWastageScore;
        this.description = description;

    }

    public String getHRADate()
    {
        SimpleDateFormat form = new SimpleDateFormat("dd-MM-yyyy");
        return form.format(this.date);
    }

    public boolean isMenuSelected()
    {
        this.loadFoodOptions();
        for(FoodItem v : this.veg) {
            if(v.selected) {
                return true;
            }
        }
        for(FoodItem nv : this.nonVeg) {
            if(nv.selected) {
                return true;
            }
        }
        return false;
    }

    public void addFoodOptions(HashMap<Integer, Boolean> veg,
                               HashMap<Integer, Boolean> nonVeg)
    {
        this.nonVegOptions = nonVeg;
        this.vegOptions = veg;
    }

    public void loadFoodOptions()
    {
        //load all food options
        if(this.veg == null || this.nonVeg == null)
        {
            ArrayList<FoodItem> allVeg = Registry.getInstance().getAllVeg();
            ArrayList<FoodItem> allNonVeg = Registry.getInstance().getAllNonVeg();
            FoodItem item;
            this.veg = new ArrayList<>();
            for(Map.Entry<Integer, Boolean> v : this.vegOptions.entrySet())
            {
                item = allVeg.get(v.getKey());
                item = item.getClone();
                item.selected = v.getValue();
                this.veg.add(item);
            }

            this.nonVeg = new ArrayList<>();
            for(Map.Entry<Integer, Boolean> v : this.nonVegOptions.entrySet())
            {
                item = allNonVeg.get(v.getKey());
                item = item.getClone();
                item.selected = v.getValue();
                this.nonVeg.add(item);
            }
        }
    }

    public FeedCollection getFeed()
    {
        if(this.isOngoing) {
            return Registry.getInstance().getFeedCol();
        } else {
            return new FeedCollection();
        }
    }

    public int getSelectedVegCount()
    {
        return this.getCount(this.veg);
    }

    public int getSelectedNonVegCount()
    {
        return this.getCount(this.nonVeg);
    }

    private int getCount(ArrayList<FoodItem> items)
    {
        int count = 0;
        for (FoodItem item : items)
        {
            if(item.selected)
            {
                count++;
            }
        }
        return count;
    }

}
