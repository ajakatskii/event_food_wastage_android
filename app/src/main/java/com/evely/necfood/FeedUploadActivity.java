package com.evely.necfood;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.evely.necfood.data.Feed;
import com.evely.necfood.data.Registry;
import com.evely.necfood.utils.CameraCaptureUtil;
import com.evely.necfood.utils.Utils;

import java.util.Calendar;

public class FeedUploadActivity extends AppCompatActivity {

    private CameraCaptureUtil camera;

    private CardView cameraContainer;

    private ImageView ivCamera;

    private EditText desc;

    private Button btnPost;

    private boolean hasCapturedImage;

    private Bitmap capturedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_upload);
        initViews();
        Registry.getInstance().context = this;
        hasCapturedImage = false;
        this.camera = new CameraCaptureUtil(this);
    }

    protected void initViews()
    {
        ivCamera = findViewById(R.id.ivFeedImg);
        cameraContainer = findViewById(R.id.cardView6);
        desc = findViewById(R.id.etFeed);
        btnPost = findViewById(R.id.btnPost);
    }

    public void btnPost_Click(View vw)
    {
        //check if we have a photo and a feed then post.
        if(!hasCapturedImage)
        {
            Utils.showMessage("Please capture a photo for feed.");
            return;
        }
        String feedData = desc.getText().toString();
        if(feedData == null || feedData.isEmpty())
        {
            Utils.showMessage("Please write something to post.");
            return;
        }
        Feed feed = new Feed(
                feedData, Utils.analyzeFoodWastage(),
                Registry.getInstance().user.name, Calendar.getInstance().getTime(),
                capturedImage, Registry.getInstance().user.profileDrawableResourceId,
                0);
        Registry.getInstance().getFeedCol().add(feed);
        Registry.getInstance().getFeedCol().sort();
        //purpose of this activity is over
        finish();
    }

    public void btnPicture_Click(View vw)
    {
        this.camera.dispatchIntent();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(this.camera.retrieveImage(requestCode, resultCode, data))
        {
            this.hasCapturedImage = true;
            this.capturedImage = BitmapFactory.decodeFile(this.camera.lastPicturePath);
            this.ivCamera.setImageBitmap(this.capturedImage);
            return;
        }
    }
}
