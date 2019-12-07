package com.evely.necfood.utils;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.evely.necfood.data.Registry;

public class Utils {

    public static Toast MsgObj;

    public static void showMessage(String msg) {
        Context c = Registry.getInstance().context;
        if (c == null) {
            return;
        }
        //cancel previous toast message
        if(MsgObj != null) {
            MsgObj.cancel();
        }
        MsgObj = Toast.makeText(c, msg, Toast.LENGTH_SHORT);
        MsgObj.show();
    }

    public static void setStars(int starCount, LinearLayout ll)
    {
        //first enable all views
        int i =0;
        ImageView iv;
        for(i = 0; i < ll.getChildCount() && i < starCount; i++)
        {
            iv = (ImageView) ll.getChildAt(i);
            iv.setVisibility(View.VISIBLE);
        }
        for(;i < ll.getChildCount();i++)
        {
            iv = (ImageView) ll.getChildAt(i);
            iv.setVisibility(View.INVISIBLE);
        }
    }

}
