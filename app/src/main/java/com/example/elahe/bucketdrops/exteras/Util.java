package com.example.elahe.bucketdrops.exteras;

import android.view.View;

import java.util.Collections;
import java.util.List;

/**
 * Created by Elahe on 8/15/2017.
 */

public class Util {
    public static List<View> mShowViews= Collections.emptyList();
    public static List<View> mHideViews=Collections.emptyList();
    public static View view;

    public static void showViews(List<View> views){
        mShowViews=views;
        if (!views.isEmpty()){
            for(int i=0;i<views.size();i++){
                views.get(i).setVisibility(View.VISIBLE);
        }

   }
}

    public static void hideVies(List<View> views){
        mHideViews=views;
        if(!views.isEmpty()){
            for(int i=0;i<views.size();i++){
                views.get(i).setVisibility(View.INVISIBLE);
            }
        }


    }
}
