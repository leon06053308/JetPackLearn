package com.example.lifecycledemo;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

public class FragmentPresent implements IPresent{
    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        Log.d("Leo", "Fragment onCreate...");
    }
}
