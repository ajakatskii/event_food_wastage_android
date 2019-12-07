package com.evely.necfood.adapters;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.evely.necfood.R;
import com.evely.necfood.data.FoodItem;
import com.evely.necfood.utils.Utils;

public class FoodItemViewHolder extends RecyclerView.ViewHolder {

    private CardView container;

    private ImageView ivImage;

    private LinearLayout llRating;

    private TextView txtName;

    private CheckBox cbFood;

    private FoodItem item;

    public FoodItemViewHolder(@NonNull View itemView) {
        super(itemView);
        container = (CardView) itemView;
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbFood != null)
                {
                    cbFood.setChecked(!cbFood.isChecked());
                    item.selected = cbFood.isChecked();
                }
            }
        });
        loadViews();
    }

    public void loadViews()
    {
        ivImage = container.findViewById(R.id.imageView27);
        llRating = container.findViewById(R.id.llReviewGiven);
        txtName = container.findViewById(R.id.textView30);
        cbFood = container.findViewById(R.id.cbFoodItem);
        cbFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do something here?
                item.selected = cbFood.isChecked();
            }
        });
    }

    public void update(FoodItem item)
    {
        this.item = item;
        ivImage.setImageResource(item.imgResId);
        txtName.setText(item.desc);
        Utils.setStars(item.rating, llRating);
        cbFood.setChecked(item.selected);
    }

}
