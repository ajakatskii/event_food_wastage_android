package com.evely.necfood.data.repository;

import com.evely.necfood.R;
import com.evely.necfood.data.Event;
import com.evely.necfood.data.collections.EventCollection;

import java.util.ArrayList;
import java.util.Calendar;

public class SeedDataMemory {

    public static EventCollection getEvents()
    {
        EventCollection col = new EventCollection();
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
        col.add(e);

        return col;
    }

}
