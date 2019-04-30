package com.example.databindingdemo;

import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.example.databindingdemo.databinding.ActivityMainBinding;
import com.example.databindingdemo.modle.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        User user = new User("Leo", "123456");
        activityMainBinding.setUserInfo(user);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Log.d("Leo", "onTouchEvent...");

        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                startActivity(new Intent(this, Main2Activity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(this, Main3Activity.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(this, Main4Activity.class));
                break;
            case R.id.btn4:
                startActivity(new Intent(this, Main5Activity.class));
                break;
            case R.id.btn5:
                startActivity(new Intent(this, Main6Activity.class));
                break;
            case R.id.btn6:
                startActivity(new Intent(this, Main7Activity.class));
                break;
            case R.id.btn7:
                startActivity(new Intent(this, Main9Activity.class));
                break;
        }
    }
}
