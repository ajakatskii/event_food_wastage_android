package com.evely.necfood.data.collections;

import com.evely.necfood.data.Event;

import java.util.ArrayList;
import java.util.HashMap;

public class EventCollection {

    public ArrayList<Event> allEvents;

    public ArrayList<Event> upcomingEvents;

    public HashMap<String, Event> nameEvents;

    public Event ongoingEvent;

    public EventCollection()
    {
        this.allEvents = new ArrayList<>();
        this.nameEvents = new HashMap<>();
        this.upcomingEvents = new ArrayList<>();
    }

    public void add(Event e)
    {
        this.allEvents.add(e);
        if(!this.nameEvents.containsKey(e.name))
        {
            this.nameEvents.put(e.name, e);
        }
        if(e.isOngoing) {
            this.ongoingEvent = e;
        } else {
            this.upcomingEvents.add(e);
        }
    }

}
