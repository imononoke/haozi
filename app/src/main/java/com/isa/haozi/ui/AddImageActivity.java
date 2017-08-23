package com.isa.haozi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.isa.haozi.R;

/**
 * Created by Izumi on 17/8/21.
 */

public class AddImageActivity extends AppCompatActivity {

    private GridView gvImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_image);
    }
}
