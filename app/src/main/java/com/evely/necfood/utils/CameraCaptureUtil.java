package com.evely.necfood.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.ActionMenuView;

import androidx.core.content.FileProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * helps in capturing an image from the device's camera
 */
public class CameraCaptureUtil {

    private static final int CAMERA_CAPTURE = 708;

    private Activity activity;

    public Bitmap lastPicture;

    public String lastPicturePath;

    public CameraCaptureUtil(Activity activity)
    {
        this.activity = activity;
    }

    public void dispatchIntent()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(this.activity.getPackageManager()) != null)
        {
            File photoFile = null;
            photoFile = this.createImageFile();
            if(photoFile != null)
            {
                Uri photoURI = FileProvider.getUriForFile(this.activity,
                        "com.example.android.fileprovider",
                        photoFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
            }
            this.activity.startActivityForResult(intent, CAMERA_CAPTURE);
        }
    }

    public boolean retrieveImage(int requestCode, int resultCode, Intent data)
    {
        //we got an image
        if(requestCode== CAMERA_CAPTURE && resultCode == Activity.RESULT_OK)
        {
            Bundle args = data.getExtras();
            this.lastPicture = (Bitmap) args.get("data");
            return true;
        }
        return false;
    }

    public File createImageFile()
    {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = this.activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = null;
        try {
            image = File.createTempFile(
                    imageFileName,  /* prefix */
                    ".jpg",         /* suffix */
                    storageDir      /* directory */
            );
        }catch(IOException exception)
        {
            //why are you here?
            timeStamp.isEmpty();
            return null;
        }

        // Save a file: path for use with ACTION_VIEW intents
        this.lastPicturePath = image.getAbsolutePath();
        return image;
    }

}
