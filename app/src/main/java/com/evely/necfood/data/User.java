package com.evely.necfood.data;

import com.evely.necfood.R;

public class User {

    public String name;

    public String password;

    public int profileDrawableResourceId;

    public boolean isOrganizer;

    public User(String name, String password, int profileResourceId) {
        this.name = name;
        this.password = password;
        this.profileDrawableResourceId = profileResourceId;
        this.isOrganizer = false;
    }

    public static User initUser(String username, String password) {
        username = username.toLowerCase();
        password = password.toLowerCase();

        if(username.equals("ankit") && password.equals("123"))
        {
            return new User("ankit", "123", R.drawable.man);
        } else if(username.equals("anya") && password.equals("123"))
        {
            User organizer = new User("anya","123",R.drawable.woman);
            organizer.isOrganizer = true;
            return organizer;
        }
        return null;
    }

}
