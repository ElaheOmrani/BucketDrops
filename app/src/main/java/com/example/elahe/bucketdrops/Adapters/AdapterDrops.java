package com.example.elahe.bucketdrops.Adapters;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.elahe.bucketdrops.MarkListner;
import com.example.elahe.bucketdrops.R;
import com.example.elahe.bucketdrops.SwipeListner;
import com.example.elahe.bucketdrops.beans.Drop;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Elahe on 8/14/2017.
 */
public class AdapterDrops extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements SwipeListner {
    public static final int ITEM=0;
    public static final int FOOTER=1;
    private LayoutInflater mInflater;
    RealmResults<Drop> mResults;
    AddListener mAddListner;
    private Realm mRealm;
    MarkListner mMarkListner;




    public AdapterDrops(Context context,Realm realm,RealmResults<Drop> results){
        mInflater=LayoutInflater.from(context);
        mRealm=realm;
      update(results);

    }

    public AdapterDrops(Context context, RealmResults<Drop> results, AddListener listener, MarkListner markListner){
        mInflater=LayoutInflater.from(context);
        update(results);
mAddListner=listener;
        mMarkListner=markListner;
    }

    private ArrayList<String> generateValues() {
        ArrayList<String> dummyValues=new ArrayList<>();
        for(int i=0;i<100;i++){
            dummyValues.add("item"+i);
        }
        return dummyValues;
    }

    public void update(RealmResults<Drop> results){
        mResults=results;
        notifyDataSetChanged();

    }

    @Override
    public int getItemViewType(int position) {
        if(mResults==null||position<mResults.size()){
            return ITEM;
        }else{
            return FOOTER;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==FOOTER){
            View view=mInflater.inflate(R.layout.footer,parent ,false);
            return new FooterHolder(view);
        }else{
            View view=mInflater.inflate(R.layout.row_drop,parent ,false);
            return new DropHolder(view,mMarkListner);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof DropHolder){
            DropHolder dropHolder= (DropHolder) holder;

            Drop drop=mResults.get(position);
            dropHolder.mTextWhat.setText(drop.getWhat());
        }


    }

    @Override
    public int getItemCount() {
        return mResults.size()+1;
    }

    @Override
    public void onSwipe(int position) {
        if(position<mResults.size()){
            mRealm=Realm.getDefaultInstance();
            mRealm.beginTransaction();
            mResults.get(position).deleteFromRealm();
            mRealm.commitTransaction();
            notifyItemRemoved(position);
        }


    }

    public class DropHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mTextWhat;
        TextView mTextWhen;
        MarkListner mMarkListner;
        public DropHolder(View itemView,MarkListner listner) {
            super(itemView);
            itemView.setOnClickListener(this);
            mTextWhat= (TextView) itemView.findViewById(R.id.tv_what);
            mTextWhen=(TextView)itemView.findViewById(R.id.tv_when);
mMarkListner=listner;

        }

        @Override
        public void onClick(View view) {
mMarkListner.onMark(getAdapterPosition());
        }
    }
    public class FooterHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Button mBtnadd;
        public FooterHolder(View itemView) {
            super(itemView);
            mBtnadd= (Button) itemView.findViewById(R.id.btn_footer);
            mBtnadd.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mAddListner.Add();
        }
    }
}