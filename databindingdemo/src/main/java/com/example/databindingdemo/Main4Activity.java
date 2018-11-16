package com.example.databindingdemo;

import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.databindingdemo.databinding.ActivityMain4Binding;
import com.example.databindingdemo.modle.ObservableGoods;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main4);
        ActivityMain4Binding activityMain4Binding = DataBindingUtil.setContentView(this, R.layout.activity_main4);
        ObservableGoods goods = new ObservableGoods("code", "hi", 23);
        activityMain4Binding.setGoods(goods);
    }
}
