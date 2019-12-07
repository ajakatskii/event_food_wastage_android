package com.evely.necfood.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.evely.necfood.FeedView;
import com.evely.necfood.R;
import com.evely.necfood.data.collections.FeedCollection;

public class FeedAdapter extends RecyclerView.Adapter<FeedViewHolder> {

    private FeedCollection feeds;

    public FeedAdapter(FeedCollection col){
        super();
        this.feeds = col;
    }

    @NonNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_item, parent, false);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txt = view.findViewById(R.id.editText2);
                String desc = txt.getText().toString();
                Intent intent = new Intent(view.getContext(), FeedView.class);
                intent.putExtra("feed_desc", desc);
                view.getContext().startActivity(intent);
            }
        });
        FeedViewHolder vh = new FeedViewHolder(cv);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull FeedViewHolder holder, int position) {
        if(position > this.feeds.feeds.size()) {
            return;
        }
        holder.update(this.feeds.feeds.get(position));
    }

    @Override
    public int getItemCount() {
        return this.feeds.feeds.size();
    }
}
