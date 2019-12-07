package com.evely.necfood.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.evely.necfood.EventViewActivity;
import com.evely.necfood.R;
import com.evely.necfood.data.Event;
import com.evely.necfood.data.Registry;

import java.util.ArrayList;

public class UpcomingEventsAdapter extends RecyclerView.Adapter<UpcomingEventsViewHolder> {

    private ArrayList<Event> upcomingEvents;

    public UpcomingEventsAdapter(ArrayList<Event> upcomingEvents){
        super();
        this.upcomingEvents = upcomingEvents;
    }


    @NonNull
    @Override
    public UpcomingEventsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent, false);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //find the event name
                TextView txtEventName = view.findViewById(R.id.txtEventName);
                //open new activity
                String eventName = txtEventName.getText().toString();
                Intent intent = new Intent(view.getContext(), EventViewActivity.class);
                intent.putExtra("event_name", eventName);
                Registry.getInstance().context.startActivity(intent);
            }
        });
        UpcomingEventsViewHolder vh = new UpcomingEventsViewHolder(cv);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingEventsViewHolder holder, int position) {
        if(upcomingEvents.size() < position) {
            return;
        }
        holder.update(upcomingEvents.get(position));
    }


    @Override
    public int getItemCount() {
        return this.upcomingEvents.size();
    }
}
