package com.example.databindingdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import com.example.databindingdemo.databinding.ActivityMain8Binding;

public class Main8Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main8);
        ActivityMain8Binding activityMain8Binding = DataBindingUtil.setContentView(this, R.layout.activity_main8);
    }
}
