package com.evely.necfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.evely.necfood.adapters.RewardsAdapter;
import com.evely.necfood.data.Registry;

public class RewardsActivity extends AppCompatActivity {

    protected TextView txtRewards;

    protected RecyclerView rvAwards;

    protected RecyclerView.LayoutManager lManager;

    protected RewardsAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);
        initViews();
        loadData();
    }

    protected void loadData()
    {
        txtRewards.setText(
                String.valueOf(Registry.getInstance().user.rewardPoints)
        );
    }

    protected void initViews()
    {
        txtRewards = findViewById(R.id.textView38);
        rvAwards = findViewById(R.id.rvAwards);
        lManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rvAdapter = new RewardsAdapter(Registry.getInstance().getRewards());
        rvAwards.setLayoutManager(lManager);
        rvAwards.setAdapter(rvAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }
}
