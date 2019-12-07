package com.evely.necfood.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.evely.necfood.R;
import com.evely.necfood.data.Event;
import com.evely.necfood.utils.Utils;

public class UpcomingEventsViewHolder extends RecyclerView.ViewHolder {

    private CardView parent;

    private ImageView ivEventProfile;

    private TextView txtEventName;

    private TextView txtDate;

    private TextView txtMenuSelected;

    private ImageView ivMenuSelected;

    private LinearLayout llAttending;

    private LinearLayout llStars;

    public UpcomingEventsViewHolder(@NonNull View itemView) {
        super(itemView);
        this.parent = (CardView) itemView;
        this.ivEventProfile = itemView.findViewById(R.id.imageView2);
        this.txtEventName = itemView.findViewById(R.id.txtEventName);
        this.llStars = itemView.findViewById(R.id.llStars);
        this.txtDate = itemView.findViewById(R.id.textView2);
        this.ivMenuSelected = itemView.findViewById(R.id.imageView3);
        this.txtMenuSelected = itemView.findViewById(R.id.textView4);
        this.llAttending = itemView.findViewById(R.id.llAttending);
    }

    public void update(Event event)
    {
        this.ivEventProfile.setImageResource(event.profileResourceId);
        this.txtEventName.setText(event.name);
        this.txtDate.setText(event.getHRADate());
        this.llAttending.setVisibility(event.willAttend ? View.VISIBLE : View.INVISIBLE);
        int visibility = View.VISIBLE;
        if(!event.isMenuSelected) {
            visibility = View.INVISIBLE;
        }
        this.ivMenuSelected.setVisibility(visibility);
        this.txtMenuSelected.setVisibility(visibility);
        Utils.setStars(event.avgStars, this.llStars);
    }

}
