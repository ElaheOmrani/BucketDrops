package com.example.elahe.bucketdrops.Adapters;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.elahe.bucketdrops.R;
import com.example.elahe.bucketdrops.beans.Drop;

import java.util.ArrayList;

import io.realm.RealmResults;

/**
 * Created by Elahe on 8/14/2017.
 */
public class AdapterDrops extends RecyclerView.Adapter<AdapterDrops.DropHolder> {
    private LayoutInflater mInflater;
   // RealmResults<Drop> mResults;

    public AdapterDrops(Context context){
        mInflater=LayoutInflater.from(context);
      //  mResults=results;

    }

    private ArrayList<String> generateValues() {
        ArrayList<String> dummyValues=new ArrayList<>();
        for(int i=0;i<100;i++){
            dummyValues.add("item"+i);
        }
        return dummyValues;
    }

    @Override
    public DropHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.row_drop,parent ,false);
        DropHolder holder =new DropHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(DropHolder holder, int position) {
      //  Drop drop=mResults.get(position);
        holder.mTextWhat.setText(generateValues().get(position));

    }

    @Override
    public int getItemCount() {
        return 99;
    }

    public class DropHolder extends RecyclerView.ViewHolder{
        TextView mTextWhat;
        public DropHolder(View itemView) {
            super(itemView);
            mTextWhat= (TextView) itemView.findViewById(R.id.tv_what);

        }
    }
}