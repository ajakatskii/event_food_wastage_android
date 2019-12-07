package com.evely.necfood.data.collections;

import com.evely.necfood.data.Feed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FeedCollection {

    public ArrayList<Feed> feeds;

    public FeedCollection() {
        this.feeds = new ArrayList<>();
    }

    public void add(Feed feed) {
        this.feeds.add(feed);
    }

    public void sort()
    {
        this.feeds.sort(new Comparator<Feed>() {

            @Override
            public int compare(Feed o, Feed t1) {
                return o.postDate.compareTo(t1.postDate);
            }
        });
    }

}
