package com.evely.necfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.evely.necfood.adapters.FeedAdapter;
import com.evely.necfood.adapters.FoodItemAdapter;
import com.evely.necfood.data.Event;
import com.evely.necfood.data.FoodItem;
import com.evely.necfood.data.Registry;

import java.util.ArrayList;

public class FoodMenuActivity extends AppCompatActivity {

    private Event event;

    private RecyclerView rvFoodItems;

    private RecyclerView.LayoutManager lManager;

    private FoodItemAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);
        getEventFromArg();
        loadViews();
//        (new AttendanceDialog()).execute();
    }

    private void getEventFromArg()
    {
        String eventName = getIntent().getStringExtra("event_name");
        event = Registry.getInstance().getEventCol().nameEvents.get(eventName);
        this.event.loadFoodOptions();
    }

    private void loadViews()
    {
        rvFoodItems = findViewById(R.id.rvFoodItems);
        lManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rvAdapter  = new FoodItemAdapter(event.veg);
        rvFoodItems.setLayoutManager(lManager);
        rvFoodItems.setAdapter(rvAdapter);
    }

    public void btnVeg_Click(View vw)
    {
        rvAdapter.changeData(event.veg);
    }

    public void btnNonVeg_Click(View vw)
    {
        rvAdapter.changeData(event.nonVeg);
    }

    public void btnBeverages_Click(View vw)
    {
        rvAdapter.changeData(new ArrayList<FoodItem>());
    }


    class AttendanceDialog extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPostExecute(Void aVoid) {
            Intent intent = new Intent(getApplicationContext(), AttendanceActivity.class);
            startActivity(intent);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(10000);
            }catch (InterruptedException ex)
            {

            }
            return null;
        }
    }

}
