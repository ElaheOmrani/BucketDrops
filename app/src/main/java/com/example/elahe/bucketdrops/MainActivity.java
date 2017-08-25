package com.example.elahe.bucketdrops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.elahe.bucketdrops.Adapters.AdapterDrops;
import com.example.elahe.bucketdrops.Adapters.AddListener;
import com.example.elahe.bucketdrops.beans.Drop;
import com.example.elahe.bucketdrops.widgets.BucketRecyclerView;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    Toolbar mToolbar;
    ImageView imgBackground;
    Button btnAddDrop;
    BucketRecyclerView mRecyclerView;
    RealmResults<Drop> mResults;
    AdapterDrops mAdapter;
    View mEmptyView;
    Realm mrealm;
    AddListener mAddListner=new AddListener() {
        @Override
        public void Add() {
            showDialogAdd();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        btnAddDrop = (Button) findViewById(R.id.btn_add_empty_drop);
        btnAddDrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogAdd();
            }
        });
         mrealm=Realm.getDefaultInstance();
        mResults =mrealm.where(Drop.class).findAllAsync();
        initBackgrindImage();

        mEmptyView=findViewById(R.id.ed_drop);
        mRecyclerView=(BucketRecyclerView)findViewById(R.id.rv_drop);
        mRecyclerView.addItemDecoration(new Divider(this,LinearLayoutManager.VERTICAL));
        mRecyclerView.hideIfEmpty(mToolbar);
        mRecyclerView.showIfEmpty(mEmptyView);
        mAdapter=new AdapterDrops(this,mResults,mAddListner,mMarkListner);
        mRecyclerView.setAdapter(mAdapter);



        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        SimpleTouchCallback callback=new SimpleTouchCallback(mAdapter);
        ItemTouchHelper helper =new ItemTouchHelper(callback);
        helper.attachToRecyclerView(mRecyclerView);


    }
    private RealmChangeListener mChangeListner=new RealmChangeListener() {
        @Override
        public void onChange(Object o) {
            mResults.addChangeListener(mChangeListner);
            mAdapter.update(mResults);

        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        mResults.addChangeListener(mChangeListner);

    }

    @Override
    protected void onStop() {
        super.onStop();
        mResults.removeChangeListener(mChangeListner);
    }
    MarkListner mMarkListner=new MarkListner() {
        @Override
        public void onMark(int Position) {
            showDialogMark();
        }
    };

    private void showDialogAdd() {
        DialogAdd dialogAdd = new DialogAdd();
        dialogAdd.show(getSupportFragmentManager(), "Add");
    }
    private void showDialogMark(){
        DialogMark dialogMark=new DialogMark();
        dialogMark.show(getSupportFragmentManager(),"Mark");
    }

    private void initBackgrindImage() {
        imgBackground = (ImageView) findViewById(R.id.iv_background);
        Glide.with(this).load(R.drawable.background).into(imgBackground);

    }
}
