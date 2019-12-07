package com.evely.necfood.data;

import android.content.Context;

import com.evely.necfood.data.collections.EventCollection;
import com.evely.necfood.data.repository.SeedDataMemory;

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

    public EventCollection getEventCol()
    {
        if(this.eventCol == null)
        {
            this.eventCol = SeedDataMemory.getEvents();
        }
        return this.eventCol;
    }

}
