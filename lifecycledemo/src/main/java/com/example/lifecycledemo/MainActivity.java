package com.example.lifecycledemo;

import androidx.lifecycle.LifecycleObserver;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Leo";
    private IPresent mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "UI onCreate: ");

        setContentView(R.layout.activity_main);
        mPresenter = new MainPresent(this);
        getLifecycle().addObserver((LifecycleObserver) mPresenter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "UI onStart: ");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "UI onResume: ");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "UI onPause: ");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "UI onStop: ");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "UI onDestroy: ");
    }
}
