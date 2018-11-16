package com.example.viewmodleandlivedata;

import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {
    private LiveDataTimerViewModel mLiveDataTimerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLiveDataTimerViewModel = ViewModelProviders.of(this).get(LiveDataTimerViewModel.class);

        subscribe();
    }

    private void subscribe(){

        final Observer<Long> elapsedObserver = new Observer<Long>() {
            @Override
            public void onChanged(Long aLong) {
                String newText = MainActivity.this.getResources().getString(R.string.seconds, aLong);
                ((TextView) findViewById(R.id.text)).setText(newText);
                Log.d("Leo", "updating timer");
            }
        };

        mLiveDataTimerViewModel.getElapsedTime().observe(this, elapsedObserver);
    }
}
