package com.evely.necfood.data;

public class Registry {

    private static Registry instance;

    public static Registry getInstance() {
        if(Registry.instance == null) {
            Registry.instance = new Registry();
        }
        return  Registry.instance;
    }

    public User user;

}
