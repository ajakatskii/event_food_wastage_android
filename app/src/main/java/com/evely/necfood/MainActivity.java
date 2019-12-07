package com.evely.necfood;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.evely.necfood.adapters.UpcomingEventsAdapter;
import com.evely.necfood.data.Event;
import com.evely.necfood.data.Registry;
import com.evely.necfood.data.collections.EventCollection;
import com.evely.necfood.utils.Utils;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtRewards;

    public ImageView ivUserProfile;

    private EventCollection eventCol;

    ///[start] ongoing event related views

    private CardView cvOngoingEvent;

    private ImageView ivCurEventImage;

    private TextView txtCurEventName;

    private TextView txtCurEventMenuSelected;

    private ImageView ivCurEventMenuSelected;

    private LinearLayout llStarsSelected;

    private TextView txtPeopleComing;

    //[end] ongoing event related views

    //[start] current calories from event

    private TextView txtCurEventCalorieCount;

    private TextView txtCalorieGoal;

    private ImageView ivCalorieStatus;

    //[end] current calories from event

    private TextView txtStatsCurEventName;

    private TextView txtCurEventScore;

    private TextView txtAvgCalories;

    private RecyclerView rvEvents;

    private RecyclerView.LayoutManager layoutManager;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            //directly launch activities from here
            Intent intent = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    intent = new Intent(getApplicationContext(), CalorieUploadActivity.class);
//                    mTextMessage.setText(R.string.title_home);
//                    return true;
                    break;
                case R.id.navigation_dashboard:
//                    intent = new Intent(getApplicationContext(), CalorieUploadActivity.class);
//                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    intent = new Intent(getApplicationContext(), FlavorActivity.class);
//                    mTextMessage.setText(R.string.title_notifications);
//                    return true;
                    break;
            }
            if(intent == null) {
                return false;
            } else {
                startActivity(intent);
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Registry.getInstance().context = this;
        this.eventCol = Registry.getInstance().getEventCol();
        //no user so can't proceed forward
        if(Registry.getInstance().user == null) {
            finish();
        }
        this.getViews();
        this.setUser();
        this.setCurrentEventData();
    }

    protected void getViews()
    {
        this.txtRewards = this.findViewById(R.id.txtReward);
        this.ivUserProfile = this.findViewById(R.id.ivProfileImg);
        this.ivUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //clear current user
                Registry.getInstance().user = null;
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //ongoing event related views
        this.cvOngoingEvent = this.findViewById(R.id.cvOngoingEvent);
        this.cvOngoingEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EventViewActivity.class);
                intent.putExtra("event_name", eventCol.ongoingEvent.name);
                startActivity(intent);
            }
        });
        this.ivCurEventImage = this.findViewById(R.id.imageView2);
        this.txtCurEventName = this.findViewById(R.id.txtEventName);
        this.txtCurEventMenuSelected = this.findViewById(R.id.textView4);
        this.ivCurEventMenuSelected = this.findViewById(R.id.imageView3);
        this.llStarsSelected = this.findViewById(R.id.llStars);
        this.txtPeopleComing = this.findViewById(R.id.textView5);


        //current consumed calories card
        this.txtCurEventCalorieCount = this.findViewById(R.id.textView13);
        this.txtCalorieGoal = this.findViewById(R.id.textView14);
        this.ivCalorieStatus = this.findViewById(R.id.imageView13);

        //food wastage in current event card
        this.txtStatsCurEventName = this.findViewById(R.id.textView26);
        this.txtCurEventScore = this.findViewById(R.id.textView25);

        //total average calorie score
        this.txtAvgCalories = this.findViewById(R.id.textView20);

        this.rvEvents = this.findViewById(R.id.rvUpcomingEvents);
        this.layoutManager = new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false);
        this.rvEvents.setLayoutManager(this.layoutManager);
        this.rvEvents.setAdapter(new UpcomingEventsAdapter(this.eventCol.upcomingEvents));
    }

    protected void setUser()
    {
        this.txtRewards.setText(String.valueOf(Registry.getInstance().user.rewardPoints));
        this.ivUserProfile.setImageResource(Registry.getInstance().user.profileDrawableResourceId);
    }




    protected void setCurrentEventData()
    {
        Event e = this.eventCol.ongoingEvent;
        if(e == null) {
            return;
        }
        this.ivCurEventImage.setImageResource(e.profileResourceId);
        this.setCurrentEventCalories(e.curCalories, Registry.getInstance().user.currentCalorieGoal);
        this.setCurEventWastage(e.name, e.curWastageScore);
        this.txtAvgCalories.setText(String.valueOf(Registry.getInstance().user.avgEventCalories));
        this.txtPeopleComing.setText(String.valueOf(e.peopleComing));
        Utils.setStars(e.avgStars, this.llStarsSelected);
    }

    protected void setCurrentEventCalories(int curCalories, int goalCalories)
    {
        this.txtCurEventCalorieCount.setText(String.valueOf(curCalories));
        this.txtCalorieGoal.setText(String.format("/ %d kCal", goalCalories));
        int colorId;
        if(curCalories < goalCalories) {
            colorId = R.color.calorie_count_color;
            this.ivCalorieStatus.setVisibility(View.INVISIBLE);
        } else {
            colorId = R.color.calorie_count_bad_color;
            this.ivCalorieStatus.setVisibility(View.INVISIBLE);
        }
        txtCurEventCalorieCount
                .setTextColor(getResources().getColor(colorId, null));
    }

    protected void setCurEventWastage(String eventName, double score)
    {
        this.txtStatsCurEventName.setText(eventName);
        this.txtCurEventScore.setText(String.format("%s/10", score));
    }

    @Override
    protected void onResume() {
        super.onResume();
        setCurrentEventData();
        setUser();
    }

    public void txtReport_Click(View vw)
    {
        Intent intent = new Intent(this, FeedUploadActivity.class);
        startActivity(intent);
    }

    public void txtMenu_Click(View vw)
    {
        Intent intent = new Intent(this, FoodMenuActivity.class);
        intent.putExtra("event_name", txtCurEventName.getText().toString());
        startActivity(intent);
    }

    public void rewards_click(View vw)
    {
        Intent intent = new Intent(this, RewardsActivity.class);
        startActivity(intent);
    }

}
