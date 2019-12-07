package com.evely.necfood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.evely.necfood.data.Feed;
import com.evely.necfood.data.Registry;

import java.text.SimpleDateFormat;

public class FeedView extends AppCompatActivity {

    private Feed feed;

    private ImageView ivFeedImage;

    private EditText etDesc;

    private ImageView ivUserImage;

    private TextView txtUsername;

    private TextView txtDate;

    private TextView txtPublicViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_view);
        loadFeed();
        initViews();
        loadData();
    }

    protected void loadFeed()
    {
        String feedDesc = getIntent().getStringExtra("feed_desc");
        feed = Registry.getInstance().getFeedCol().findByDesc(feedDesc);
    }

    protected void initViews()
    {
        ivFeedImage = findViewById(R.id.imageView33);
        etDesc = findViewById(R.id.editText7);
        ivUserImage = findViewById(R.id.imageView26);
        txtUsername = findViewById(R.id.textView9);
        txtDate = findViewById(R.id.textView55);
        txtPublicViews = findViewById(R.id.textView56);
    }

    protected void loadData()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd / MM / yyyy");
        this.ivFeedImage.setImageBitmap(feed.image);
        this.ivUserImage.setImageResource(feed.profileImgResId);
        txtUsername.setText(feed.name);
        etDesc.setText(feed.description);
        txtDate.setText(formatter.format(feed.postDate));
        txtPublicViews.setText(String.valueOf(feed.publicViews));
    }
}
