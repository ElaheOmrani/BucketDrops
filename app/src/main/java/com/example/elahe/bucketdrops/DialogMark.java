package com.example.elahe.bucketdrops;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by Elahe on 8/20/2017.
 */

public class DialogMark extends DialogFragment {
    private ImageButton mBtnClose;
    private Button mBtnCompled;
    private View.OnClickListener mBtnClickListner= new View.OnClickListener() {
        @Override
        public void onClick(View view) {

           switch (view.getId()){
               case R.id.btn_close:
                //TODO do some action here to handle when an item is completed

                   break;
           }
            dismiss();
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_mark,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBtnClose= (ImageButton) view.findViewById(R.id.btn_close);
        mBtnCompled= (Button) view.findViewById(R.id.btn_completed);
    }
}
