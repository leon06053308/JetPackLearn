package com.example.viewmodleandlivedata;

import android.app.Application;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class LiveDataTimerViewModel extends AndroidViewModel {
    private static final int ONE_SECOND = 1000;

    private MutableLiveData<Long> mElapsedTime = new MutableLiveData<>();

    private long mInitialTime;


    public LiveDataTimerViewModel(@NonNull Application application) {
        super(application);

        mInitialTime = SystemClock.elapsedRealtime();

        Disposable subscribe = Observable.interval(0, ONE_SECOND, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                final long newValue = (SystemClock.elapsedRealtime() - mInitialTime) / 1000;
                //postValue是在子线程中执行
                Log.d("Leo", "newValue: " + newValue);
                mElapsedTime.postValue(newValue);
            }
        });
    }

    public LiveData<Long> getElapsedTime(){
        return mElapsedTime;
    }
}
