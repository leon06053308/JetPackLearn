package com.example.databindingdemo;

import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Toast;
import com.example.databindingdemo.databinding.ActivityMain5Binding;
import com.example.databindingdemo.modle.User;

public class Main5Activity extends AppCompatActivity {
    private ActivityMain5Binding activityMain5Binding;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main5);
        activityMain5Binding = DataBindingUtil.setContentView(this, R.layout.activity_main5);
        user = new User("leo", "12345");
        activityMain5Binding.setUserInfo(user);
        activityMain5Binding.setUserPresenter(new UserPresenter());
    }

    public class UserPresenter {

        public void onUserNameClick(User user) {
            Toast.makeText(Main5Activity.this, "用户名：" + user.getName(), Toast.LENGTH_SHORT).show();
        }

        public void onPwdClick(View view) {
            Toast.makeText(Main5Activity.this, "pwd：" + user.getPassword(), Toast.LENGTH_SHORT).show();
        }

        public void afterTextChanged(Editable s) {
            user.setName(s.toString());
            activityMain5Binding.setUserInfo(user);
        }

        public void afterUserPasswordChanged(Editable s) {
            user.setPassword(s.toString());
            activityMain5Binding.setUserInfo(user);
        }

    }
}
