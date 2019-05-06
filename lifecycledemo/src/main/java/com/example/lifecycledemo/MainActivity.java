package com.example.lifecycledemo;

import androidx.lifecycle.LifecycleObserver;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Leo";
    private IPresent mPresenter;

    /**
     *
     * Activity的Lifecycle.Event.ON_CREATE事在reportfragment的onActivityCreated里调用的，而Fragment的该事件实在performCreate里调用的
     *
     * commit是异步的，提交fragment事务后会在何时时机调用，所以此时MainFragment还没有被加入， 但是ReportFragment调用manager.executePendingTransactions()这个方法，这个方法会立即执行
     * 现有事务，所以这样ReportFragment就已经添加到FragmentManager, 所以会导致FragmentPresent的onCreate后执行的情况。
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.d(TAG, "UI onCreate: ");

        setContentView(R.layout.activity_main);
        mPresenter = new MainPresent(this);
        getLifecycle().addObserver((LifecycleObserver) mPresenter);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MainFragment()).commit();
        //getSupportFragmentManager().executePendingTransactions();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Log.d(TAG, "UI onStart: ");
    }
    @Override
    protected void onResume() {
        super.onResume();
        //Log.d(TAG, "UI onResume: ");
    }
    @Override
    protected void onPause() {
        super.onPause();
        //Log.d(TAG, "UI onPause: ");
    }
    @Override
    protected void onStop() {
        super.onStop();
        //Log.d(TAG, "UI onStop: ");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Log.d(TAG, "UI onDestroy: ");
    }
}
