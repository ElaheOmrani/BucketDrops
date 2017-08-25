package com.example.elahe.bucketdrops.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;


import com.example.elahe.bucketdrops.exteras.Util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Elahe on 8/15/2017.
 */

public class BucketRecyclerView extends RecyclerView {

    private List<View> mNonEmptyViews= Collections.emptyList();
    private List<View> mEmptyViews=Collections.emptyList();

    private AdapterDataObserver mObserver=new AdapterDataObserver() {
        @Override
        public void onChanged() {
            toggleViews();

        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount) {
            toggleViews();

        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
            toggleViews();

        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            toggleViews();

        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            toggleViews();

        }

        @Override
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            toggleViews();

        }
    };

    private void toggleViews() {
        if(getAdapter()!=null&& !mEmptyViews.isEmpty()&& !mNonEmptyViews.isEmpty()){
      //      if(getAdapter().getItemCount()==0){
              //  show all the empty views
//                Util.showViews(mEmptyViews);
               // hide the recyclerview
//                for(View view:mEmptyViews){
//                    view.setVisibility(View.VISIBLE);
//                }
//                setVisibility(View.GONE);
           //     hide all the views which are meant tobe hidden
//                Util.hideVies(mNonEmptyViews);
//                for(View view:mNonEmptyViews){
//                    view.setVisibility(View.GONE);
//                }
           }else {
//                for(View view:mEmptyViews){
//                    view.setVisibility(GONE);
//                }

               // show all the Nonempty views
             //   Util.showViews(mNonEmptyViews);
              //  show the recyclerview
              //  setVisibility(View.VISIBLE);
              //  show all the views which are meant tobe hidden
              //  Util.hideVies(mEmptyViews);
//                for(View view:mNonEmptyViews){
//                    view.setVisibility(View.VISIBLE);
               }
          //  }
      //  }
    }

    public BucketRecyclerView(Context context) {
        super(context);
    }

    public BucketRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BucketRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
        if(adapter!=null){
            adapter.registerAdapterDataObserver(mObserver);
        }
        mObserver.onChanged();
    }

    public void showIfEmpty(View ...mEmptyView) {
        mEmptyViews= Arrays.asList(mEmptyView);
    }

    public void hideIfEmpty(View ...mViews) {
       mNonEmptyViews=Arrays.asList(mViews);
    }
}
