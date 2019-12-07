package com.evely.necfood.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.evely.necfood.R;
import com.evely.necfood.data.FoodItem;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FoodItemAdapter
        extends RecyclerView.Adapter<FoodItemViewHolder>
{

    private ArrayList<FoodItem> items;

    public FoodItemAdapter(ArrayList<FoodItem> items)
    {
        super();
        this.items = items;
    }

    public void changeData(ArrayList<FoodItem> items)
    {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FoodItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);
        FoodItemViewHolder vh = new FoodItemViewHolder(cv);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodItemViewHolder holder, int position) {
        if(position >= this.items.size())
        {
            return;
        }
        holder.update(this.items.get(position));
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }
}
