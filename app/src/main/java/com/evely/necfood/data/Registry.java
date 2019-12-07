package com.evely.necfood.data;

import android.content.Context;
import android.graphics.Bitmap;

import com.evely.necfood.data.collections.EventCollection;
import com.evely.necfood.data.collections.FeedCollection;
import com.evely.necfood.data.repository.SeedDataMemory;

import java.util.ArrayList;

public class Registry {

    private static Registry instance;

    public static Registry getInstance() {
        if(Registry.instance == null) {
            Registry.instance = new Registry();
        }
        return  Registry.instance;
    }

    public User user;

    public Context context;

    private EventCollection eventCol;

    private FeedCollection feedCol;

    private ArrayList<FoodItem> allVeg;

    private ArrayList<FoodItem> allNonVeg;

    public EventCollection getEventCol()
    {
        if(this.eventCol == null)
        {
            this.eventCol = SeedDataMemory.getEvents();
        }
        return this.eventCol;
    }

    public FeedCollection getFeedCol()
    {
        if(this.feedCol == null)
        {
            this.feedCol = SeedDataMemory.getFeeds();
        }
        return this.feedCol;
    }

    public ArrayList<FoodItem> getAllVeg()
    {
        if(this.allVeg == null)
        {
            this.allVeg = SeedDataMemory.createAllVegFoodOptions();
        }
        return this.allVeg;
    }

    public ArrayList<FoodItem> getAllNonVeg()
    {
        if(this.allNonVeg == null) {
            this.allNonVeg = SeedDataMemory.createAllNonVegFoodOptions();
        }
        return  this.allNonVeg;
    }

    public Bitmap beforeDish;

    public void clearBeforeDishPic()
    {
        this.beforeDish = null;
    }

    public boolean hasBeforeDishPic()
    {
        return (this.beforeDish != null);
    }

    public int extraCoins = 0;

    private ArrayList<Reward> rewards;

    public ArrayList<Reward> getRewards()
    {
        if(rewards == null)
        {
            this.rewards = SeedDataMemory.getRewards();
        }
        return this.rewards;
    }

}
