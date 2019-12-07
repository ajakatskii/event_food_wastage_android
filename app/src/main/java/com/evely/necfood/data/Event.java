package com.evely.necfood.data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * an event
 */
public class Event {

    public boolean isOngoing;

    public boolean willAttend;

    public String name;

    public boolean isMenuSelected;

    public int peopleComing;

    public int avgStars;

    public int userStars;

    public Date date;

    public int profileResourceId;

    public int curCalories;

    public double curWastageScore;

    public String description;

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
        this.isMenuSelected = isMenuSelected;
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

}
