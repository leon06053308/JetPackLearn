package com.example.databindingdemo;

import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.databindingdemo.databinding.ActivityMain3Binding;

import java.util.*;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main3);
        ActivityMain3Binding activityMain3Binding = DataBindingUtil.setContentView(this, R.layout.activity_main3);
        activityMain3Binding.setList(new ArrayList<String>());
        Map<String, String> map = new HashMap<>();
        map.put("Leo", "ccc");
        activityMain3Binding.setMap(map);
        activityMain3Binding.setKey("Leo");
        Set<String> set = new HashSet<>();
        set.add("xxx");
        activityMain3Binding.setSet(set);
        activityMain3Binding.setArray(new String[]{"hi", "hello"});
    }
}
