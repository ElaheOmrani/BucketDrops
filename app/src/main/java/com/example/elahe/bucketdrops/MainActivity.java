package com.example.elahe.bucketdrops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.elahe.bucketdrops.Adapters.AdapterDrops;

public class MainActivity extends AppCompatActivity {
    Toolbar mToolbar;
    ImageView imgBackground;
    Button btnAddDrop;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar= (Toolbar) findViewById(R.id.toolbar);
        mRecyclerView=(RecyclerView)findViewById(R.id.rv_drop);
        setSupportActionBar(mToolbar);
        initBackgrindImage();
        btnAddDrop = (Button) findViewById(R.id.btn_add_empty_drop);
        btnAddDrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogAdd();
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new AdapterDrops(this));
    }
    private void showDialogAdd() {
        DialogAdd dialogAdd = new DialogAdd();
        dialogAdd.show(getSupportFragmentManager(), "Add");
    }

    private void initBackgrindImage() {
        imgBackground = (ImageView) findViewById(R.id.iv_background);
        Glide.with(this).load(R.drawable.background).into(imgBackground);

    }
}
