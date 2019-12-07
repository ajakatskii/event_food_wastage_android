package com.evely.necfood.data;

import com.evely.necfood.R;

public class User {

    public String name;

    public String password;

    public int profileDrawableResourceId;

    public int rewardPoints;

    public boolean isOrganizer;

    public double avgEventCalories;

    public int currentCalorieGoal;

    public User(String name, String password, int profileResourceId) {
        this.name = name;
        this.password = password;
        this.profileDrawableResourceId = profileResourceId;
        this.isOrganizer = false;
        this.avgEventCalories = Math.round(Math.random() * 100000.0) / 10.0;
        this.currentCalorieGoal = 2500;
    }

    public static User initUser(String username, String password) {
        username = username.toLowerCase();
        password = password.toLowerCase();

        if(username.equals("ankit") && password.equals("123"))
        {
            User user = new User("ankit", "123", R.drawable.man);
            user.rewardPoints = 400;
            return user;
        } else if(username.equals("anya") && password.equals("123"))
        {
            User organizer = new User("anya","123",R.drawable.woman);
            organizer.isOrganizer = true;
            organizer.rewardPoints = 500;
            return organizer;
        }
        return null;
    }

}
