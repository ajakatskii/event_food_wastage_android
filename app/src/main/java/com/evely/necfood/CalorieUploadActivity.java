package com.evely.necfood;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.evely.necfood.data.Registry;
import com.evely.necfood.utils.CameraCaptureUtil;
import com.evely.necfood.utils.Utils;

public class CalorieUploadActivity extends AppCompatActivity {

    private CameraCaptureUtil cameraHelper;

    private ImageView ivBefore;

    private ImageView ivAfter;

    private TextView txtCalories;

    private TextView txtPercent;

    private Bitmap beforeDish;

    private Bitmap afterDish;

    public boolean isAfter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_upload);
        initViews();
        loadBeforeDish();
        this.cameraHelper = new CameraCaptureUtil(this);
    }

    public void loadBeforeDish()
    {
        //check if we have already clicked a before dish picture then load it again.
        if(Registry.getInstance().hasBeforeDishPic())
        {
            this.beforeDish = Registry.getInstance().beforeDish;
            this.ivBefore.setImageBitmap(this.beforeDish);
        }
    }

    public void initViews()
    {
        ivBefore = findViewById(R.id.imageView35);
        ivAfter = findViewById(R.id.imageView34);
        txtCalories = findViewById(R.id.textView59);
        txtPercent = findViewById(R.id.textView61);
    }

    public void btnBefore_Click(View vw)
    {
        isAfter = false;
        this.cameraHelper.dispatchIntent();
    }

    public void brnAfter_Click(View vw)
    {
        isAfter = true;
        this.cameraHelper.dispatchIntent();
    }

    public void calculateCalories()
    {
        txtPercent.setText(String.format("%s %", String.valueOf(Utils.analyzeFoodWastage())));
        txtCalories.setText(String.format("%s kC.", String.valueOf(Utils.analyzeCalories())));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(this.cameraHelper.retrieveImage(requestCode, resultCode, data))
        {
            if(this.isAfter)
            {
                this.isAfter = false;
                //start calorie calculations
                Registry.getInstance().clearBeforeDishPic();
                this.afterDish = BitmapFactory.decodeFile(this.cameraHelper.lastPicturePath);
                this.calculateCalories();
            } else {
                this.beforeDish = BitmapFactory.decodeFile(this.cameraHelper.lastPicturePath);
                this.ivBefore.setImageBitmap(this.beforeDish);
                Registry.getInstance().beforeDish = this.beforeDish;
            }
        }
    }
}
