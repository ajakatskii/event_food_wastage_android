package com.evely.necfood.data.repository;

import android.content.res.Resources;
import android.graphics.BitmapFactory;

import com.evely.necfood.R;
import com.evely.necfood.data.Event;
import com.evely.necfood.data.Feed;
import com.evely.necfood.data.FoodItem;
import com.evely.necfood.data.Registry;
import com.evely.necfood.data.collections.EventCollection;
import com.evely.necfood.data.collections.FeedCollection;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class SeedDataMemory {

    public static EventCollection getEvents()
    {
        EventCollection col = new EventCollection();
        HashMap<Integer, Boolean> veg, nonVeg;
        Event e;
        Calendar cal = Calendar.getInstance();
        cal.set(2019, 11, 8);
        //the ongoing event
        e = new Event(
                "Ferns Blossoms Banquet",
                true,
                true,
                true,
                156,
                3,
                4,
                cal.getTime(),
                R.drawable.bh_1,
                2067,
                3.6,
                "Farhan is marrying Farheen, the girl of his dreams and they both would love for your auspicious presence to grace and bless them. But are you coming?"
        );
        veg = new HashMap<>();
        nonVeg = new HashMap<>();
        veg.put(1,true);
        veg.put(4,false);
        veg.put(7,true);
        veg.put(8,true);
        veg.put(13,false);
        veg.put(15,true);
        veg.put(18,false);
        veg.put(19,false);
        nonVeg.put(1,true);
        nonVeg.put(2,false);
        nonVeg.put(3,false);
        nonVeg.put(7,false);
        nonVeg.put(4,true);
        nonVeg.put(9,false);
        nonVeg.put(10,false);
        nonVeg.put(14,false);
        e.addFoodOptions(veg, nonVeg);
        col.add(e);

        cal.set(2019, 11, 12);
        e = new Event(
                "Brigade Mahagun Farmhouse",
                false,
                true,
                true,
                345,
                2,
                4,
                cal.getTime(),
                R.drawable.bh_2,
                1089,
                3,
                "Julia French, daughter of Mr. Adam French and the late Iris French, " +
                        "and Austin Mahoney, son of Mr. Camden and Elizabeth Mahoney, " +
                        "request the honor of your presence " +
                        "at their wedding"
        );
        veg = new HashMap<>();
        nonVeg = new HashMap<>();
        veg.put(2,false);
        veg.put(8,false);
        veg.put(12,true);
        veg.put(11,false);
        veg.put(14,false);
        veg.put(16,true);
        nonVeg.put(19,false);
        nonVeg.put(18,true);
        nonVeg.put(16,false);
        nonVeg.put(3,false);
        nonVeg.put(1,true);
        nonVeg.put(4,true);
        nonVeg.put(5,false);
        nonVeg.put(12,false);
        nonVeg.put(11,false);
        e.addFoodOptions(veg, nonVeg);
        col.add(e);

        cal.set(2019, 11, 18);
        e = new Event(
                "DTU Hostel Mess",
                false,
                true,
                false,
                102,
                4,
                3,
                cal.getTime(),
                R.drawable.bh_3,
                0,
                7,
                ""
        );
        veg = new HashMap<>();
        nonVeg = new HashMap<>();
        veg.put(2,false);
        veg.put(3,false);
        veg.put(4,false);
        veg.put(5,false);
        veg.put(6,false);
        veg.put(7,false);
        veg.put(8,false);
        veg.put(9,false);
        veg.put(10,false);
        nonVeg.put(19,false);
        nonVeg.put(18,false);
        nonVeg.put(17,false);
        nonVeg.put(16,false);
        nonVeg.put(15,false);
        nonVeg.put(14,false);
        nonVeg.put(13,false);
        nonVeg.put(12,false);
        e.addFoodOptions(veg, nonVeg);
        col.add(e);

        cal.set(2019, 11, 19);
        e = new Event(
                "Milan banquets",
                false,
                false,
                false,
                89,
                5,
                2,
                cal.getTime(),
                R.drawable.bh_4,
                0,
                9,
                "Rohan's birthday celebration"
        );
        veg = new HashMap<>();
        nonVeg = new HashMap<>();
        veg.put(12,false);
        veg.put(13,false);
        veg.put(14,false);
        veg.put(16,false);
        veg.put(18,false);
        veg.put(15,false);
        veg.put(19,false);
        veg.put(17,false);
        veg.put(11,false);
        nonVeg.put(7,false);
        nonVeg.put(3,false);
        nonVeg.put(8,false);
        nonVeg.put(1,false);
        nonVeg.put(6,false);
        nonVeg.put(5,false);
        nonVeg.put(4,false);
        nonVeg.put(2,false);
        e.addFoodOptions(veg, nonVeg);
        col.add(e);

        return col;
    }

    public static FeedCollection getFeeds()
    {
        FeedCollection col = new FeedCollection();
        Feed feed;

        Resources res = Registry.getInstance().context.getResources();

        Calendar cal = Calendar.getInstance();
        cal.set(2019,11,8, 7, 45);
        //create 3 feeds for seeding.
        feed = new Feed(
                "Please atleast make sure that the food waste is atleast in the dustbin.",
                56.7,
                "Anonymous",
                cal.getTime(),
                BitmapFactory.decodeResource(res, R.drawable.fw_1),
                R.drawable.anon,
                23
        );
        col.add(feed);
        cal.set(2019,11,8, 8, 15);
        feed = new Feed(
                "Stack up the plates atleast guys!!",
                34.5,
                "Anonymous",
                cal.getTime(),
                BitmapFactory.decodeResource(res, R.drawable.fw_2),
                R.drawable.anon,
                45
        );
        col.add(feed);
        cal.set(2019,11,8, 8, 17);

        feed = new Feed(
                "I get the biryani is bad butthis is just too much of waste",
                77.45,
                "Anonymous",
                cal.getTime(),
                BitmapFactory.decodeResource(res, R.drawable.fw_3),
                R.drawable.anon,
                78
        );
        col.add(feed);
        col.sort();
        return  col;
    }

    public static ArrayList<FoodItem> createAllVegFoodOptions()
    {
        ArrayList<FoodItem> items = new ArrayList<>();
        //create 20 veg food options
        int index = 0;
        items.add(new FoodItem(
                "Panner Butter Masala",
                3,
                getVegImgResId(index),
                false
        ));
        //1
        index++;
        items.add(new FoodItem(
                "Shahi Panner",
                4,
                getVegImgResId(index),
                false
        ));
        //2
        index++;
        items.add(new FoodItem(
                "Paneer kofta",
                2,
                getVegImgResId(index),
                false
        ));
        //3
        index++;
        items.add(new FoodItem(
                "Daal Makhani",
                1,
                getVegImgResId(index),
                false
        ));
        //4
        index++;
        items.add(new FoodItem(
                "Shahi kebab",
                3,
                getVegImgResId(index),
                false
        ));
        //5
        index++;
        items.add(new FoodItem(
                "Soya Chaap",
                2,
                getVegImgResId(index),
                false
        ));
        //6
        index++;
        items.add(new FoodItem(
                "Handi Biryani",
                2,
                getVegImgResId(index),
                false
        ));
        //7
        index++;
        items.add(new FoodItem(
                "Soya Sabji",
                3,
                getVegImgResId(index),
                false
        ));
        //8
        index++;
        items.add(new FoodItem(
                "Aloo Subji",
                5,
                getVegImgResId(index),
                false
        ));
        //9
        index++;
        items.add(new FoodItem(
                "Stuffed Kulcha Naan",
                4,
                getVegImgResId(index),
                false
        ));
        //10
        index++;
        items.add(new FoodItem(
                "Butter Naan",
                2,
                getVegImgResId(index),
                false
        ));
        //11
        index++;
        items.add(new FoodItem(
                "Dal Fry",
                1,
                getVegImgResId(index),
                false
        ));
        //12
        index++;
        items.add(new FoodItem(
                "Kadi Chawal",
                4,
                getVegImgResId(index),
                false
        ));
        //13
        index++;
        items.add(new FoodItem(
                "Rajma Chawal",
                1,
                getVegImgResId(index),
                false
        ));
        //14
        index++;
        items.add(new FoodItem(
                "Lobhiya",
                1,
                getVegImgResId(index),
                false
        ));
        //15
        index++;
        items.add(new FoodItem(
                "Shahi Kofta",
                5,
                getVegImgResId(index),
                false
        ));
        //16
        index++;
        items.add(new FoodItem(
                "Manchurian",
                2,
                getVegImgResId(index),
                false
        ));
        //17
        index++;
        items.add(new FoodItem(
                "Masala Dosa",
                3,
                getVegImgResId(index),
                false
        ));
        //18
        index++;
        items.add(new FoodItem(
                "Rawa Dosa",
                1,
                getVegImgResId(index),
                false
        ));
        //19
        index++;
        items.add(new FoodItem(
                "Upama",
                5,
                getVegImgResId(index),
                false
        ));
        //20
        index++;
        items.add(new FoodItem(
                "Cheese Bread",
                1,
                getVegImgResId(index),
                false
        ));
        return items;
    }

    private static int getVegImgResId(int index)
    {
        switch (index) {
            default:
                return R.drawable.fruits;
        }
    }

    private static int getNonVegResId(int index) {
        switch (index) {
            default:
                return R.drawable.chicken;
        }
    }

    public static ArrayList<FoodItem> createAllNonVegFoodOptions()
    {
        ArrayList<FoodItem> items = new ArrayList<>();
        //create 20 veg food options
        int index = 0;
        items.add(new FoodItem(
                "Chicken Fried Rice",
                3,
                getNonVegResId(index),
                false
        ));
        //1
        index++;
        items.add(new FoodItem(
                "Chicken korma",
                1,
                getNonVegResId(index),
                false
        ));
        //2
        index++;
        items.add(new FoodItem(
                "Egg biryani",
                2,
                getNonVegResId(index),
                false
        ));
        //3
        index++;
        items.add(new FoodItem(
                "Chicken 65",
                3,
                getNonVegResId(index),
                false
        ));
        //4
        index++;
        items.add(new FoodItem(
                "Chicken kebab",
                4,
                getNonVegResId(index),
                false
        ));
        //5
        index++;
        items.add(new FoodItem(
                "Chicken Chaap",
                2,
                getNonVegResId(index),
                false
        ));
        //6
        index++;
        items.add(new FoodItem(
                "Tuna Biryani",
                5,
                getNonVegResId(index),
                false
        ));
        //7
        index++;
        items.add(new FoodItem(
                "Roghan Ghost Sabji",
                1,
                getNonVegResId(index),
                false
        ));
        //8
        index++;
        items.add(new FoodItem(
                "Fried Eggs",
                3,
                getNonVegResId(index),
                false
        ));
        //9
        index++;
        items.add(new FoodItem(
                "Fried Chicken",
                4,
                getNonVegResId(index),
                false
        ));
        //10
        index++;
        items.add(new FoodItem(
                "Chicken Naan",
                1,
                getNonVegResId(index),
                false
        ));
        //11
        index++;
        items.add(new FoodItem(
                "Fish Fry",
                3,
                getNonVegResId(index),
                false
        ));
        //12
        index++;
        items.add(new FoodItem(
                "Fish Chawal",
                4,
                getNonVegResId(index),
                false
        ));
        //13
        index++;
        items.add(new FoodItem(
                "Masala Chicken Burger",
                3,
                getNonVegResId(index),
                false
        ));
        //14
        index++;
        items.add(new FoodItem(
                "Fried Dum Chicken",
                1,
                getNonVegResId(index),
                false
        ));
        //15
        index++;
        items.add(new FoodItem(
                "Chicken Haryali Kofta",
                3,
                getNonVegResId(index),
                false
        ));
        //16
        index++;
        items.add(new FoodItem(
                "Fish Manchurian",
                1,
                getNonVegResId(index),
                false
        ));
        //17
        index++;
        items.add(new FoodItem(
                "Masala Egg Dosa",
                4,
                getNonVegResId(index),
                false
        ));
        //18
        index++;
        items.add(new FoodItem(
                "Chicken Pasta",
                1,
                getNonVegResId(index),
                false
        ));
        //19
        index++;
        items.add(new FoodItem(
                "Boiled Eggs",
                5,
                getNonVegResId(index),
                false
        ));
        //20
        index++;
        items.add(new FoodItem(
                "Chilli Cheese Chicken",
                1,
                getNonVegResId(index),
                false
        ));
        return items;
    }

}
