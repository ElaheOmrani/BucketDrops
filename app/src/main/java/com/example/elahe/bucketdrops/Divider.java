package com.example.elahe.bucketdrops;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.elahe.bucketdrops.Adapters.AdapterDrops;

import java.util.IllegalFormatException;

/**
 * Created by Elahe on 8/18/2017.
 */

public class Divider extends RecyclerView.ItemDecoration {
    Drawable mDivider;
    int mOreintation;



    public Divider(Context context, int orientation){
        mDivider= ContextCompat.getDrawable(context,R.drawable.divider);
        if(orientation!=LinearLayoutCompat.VERTICAL){
            throw new IllegalArgumentException("this item decoration cant be used cause the layoutmanager is not vertical ");
        }
        mOreintation=orientation;




    }
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if(mOreintation== LinearLayoutManager.VERTICAL){
            drawHorizontalDivider(c,parent,state);
        }
    }

    private void drawHorizontalDivider(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left ,top,right,bottom;
        left =parent.getPaddingLeft();
        right=parent.getWidth()-parent.getPaddingRight();
        int count=parent.getChildCount();
        for(int i=0;i<count;i++){
            if(AdapterDrops.FOOTER!=parent.getAdapter().getItemViewType(i)){
                View current=parent.getChildAt(i);
                RecyclerView.LayoutParams params= (RecyclerView.LayoutParams) current.getLayoutParams();
                top=current.getTop()-params.topMargin;
                bottom=top+mDivider.getIntrinsicHeight();
                mDivider.setBounds(left,top,right,bottom);
                mDivider.draw(c);
            }

        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
    }
}
