package com.evely.necfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.evely.necfood.adapters.FeedAdapter;
import com.evely.necfood.data.Event;
import com.evely.necfood.data.Registry;
import com.evely.necfood.utils.Utils;

public class EventViewActivity extends AppCompatActivity {

    private Event event;

    private TextView txtEventName;

    private LinearLayout llUserRatings;

    private LinearLayout llAvgRatings;

    private TextView txtVegCount;
    private TextView txtSelectedVegCount;

    private TextView txtNonVegCount;
    private TextView txtSelectedNonVegCount;

    private ImageView ivEventImage;

    private RecyclerView rvFeeds;

    private RecyclerView.LayoutManager manager;

    private CardView cvPostFeed;

    public FeedAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_view);
        getEvent();
        initViews();
        fillEventData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fillEventData();
        adapter.notifyDataSetChanged();
    }

    private void getEvent()
    {
        String eventName = this.getIntent().getStringExtra("event_name");
        //did we get an event name?
        this.event = Registry.getInstance().getEventCol()
                .nameEvents.get(eventName);
        this.event.isMenuSelected();
    }

    private void initViews()
    {
        txtEventName = findViewById(R.id.editText);
        ivEventImage = findViewById(R.id.imageView11);

        llUserRatings = findViewById(R.id.llReviewYour);
        llAvgRatings = findViewById(R.id.llReviewGiven);

        txtSelectedVegCount = findViewById(R.id.textView28);
        txtVegCount = findViewById(R.id.textView29);

        txtSelectedNonVegCount = findViewById(R.id.textView32);
        txtNonVegCount = findViewById(R.id.textView33);

        cvPostFeed = findViewById(R.id.cvPostFeed);
        if(!event.isOngoing)
        {
            cvPostFeed.setVisibility(View.INVISIBLE);
        } else {
            cvPostFeed.setVisibility(View.VISIBLE);
        }

        rvFeeds = findViewById(R.id.recyclerView);
        manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rvFeeds.setLayoutManager(manager);
        adapter = new FeedAdapter(Registry.getInstance().getFeedCol());
        //if the event is running only then show the live feed.
        if(event.isOngoing) {
            rvFeeds.setAdapter(adapter);
        }
    }

    private void fillEventData()
    {
        ivEventImage.setImageResource(event.profileResourceId);
        txtEventName.setText(event.name);
        Utils.setStars(event.userStars, llUserRatings,
                R.drawable.star, R.drawable.star_off);
        Utils.setStars(event.avgStars, llAvgRatings);

        txtVegCount.setText(String.format("/ %s",String.valueOf(event.veg.size())));
        txtSelectedVegCount.setText(String.valueOf(event.getSelectedVegCount()));

        txtNonVegCount.setText(String.format("/ %s",String.valueOf(event.nonVeg.size())));
        txtSelectedNonVegCount.setText(String.valueOf(event.getSelectedNonVegCount()));

    }

    public void rating_onClick(View vw)
    {
        int i;
        for(i = 0; i < llUserRatings.getChildCount(); i++)
        {
            ImageView iv = (ImageView)llUserRatings.getChildAt(i);
            iv.setImageResource(R.drawable.star);
            if(vw.getId() == llUserRatings.getChildAt(i).getId())
            {
                break;
            }
        }
        this.event.userStars = ++i;
        for(;i < llUserRatings.getChildCount(); i++)
        {
            ImageView iv = (ImageView)llUserRatings.getChildAt(i);
            iv.setImageResource(R.drawable.star_off);
        }
    }

    public void btnPostFeed_Click(View vw)
    {
        Intent intent = new Intent(this.getApplicationContext(), FeedUploadActivity.class);
        startActivity(intent);
    }

    public void btnFoodMenu_Click(View vw)
    {
        Intent intent = new Intent(this.getApplicationContext(), FoodMenuActivity.class);
        intent.putExtra("event_name", event.name);
        startActivity(intent);
    }

    public void btnYourPlate_Click(View vw)
    {
        Intent intent = new Intent(this.getApplicationContext(), CalorieUploadActivity.class);
        startActivity(intent);
    }

}
