package com.example.elahe.bucketdrops;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by Elahe on 8/14/2017.
 */
public class DialogAdd extends DialogFragment {
    private ImageButton mBtnClose;
    private EditText mInputWhat;
    private DatePicker mInputWhen;
    private Button mBtnAdd;

    private View.OnClickListener mBtnClickListner=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id=view.getId();

            switch (id){
                case R.id.btn_add_it:
                    addAction();
                    break;
            }

            dismiss();
        }
    };


    public DialogAdd() {
    }

    private void addAction() {
        String what=mInputWhat.getText().toString();
        long now =System.currentTimeMillis();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_dialog,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBtnClose= (ImageButton) view.findViewById(R.id.btn_close);
        mInputWhat=(EditText)view.findViewById(R.id.ed_drop);
        mInputWhen=(DatePicker)view.findViewById(R.id.bpv_data);
        mBtnAdd=(Button)view.findViewById(R.id.btn_add_it);

        mBtnClose.setOnClickListener(mBtnClickListner);
        mBtnAdd.setOnClickListener(mBtnClickListner);
    }
}
