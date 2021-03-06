package com.example.elahe.bucketdrops;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by Elahe on 8/19/2017.
 */

public class SimpleTouchCallback extends ItemTouchHelper.Callback {
    private SwipeListner mListner;

    public SimpleTouchCallback(SwipeListner listner) {
        mListner=listner;

    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(0,ItemTouchHelper.END);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
    mListner.onSwipe(viewHolder.getAdapterPosition());
    }
}
