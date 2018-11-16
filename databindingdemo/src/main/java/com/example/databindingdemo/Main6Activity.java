package com.example.databindingdemo;

import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import com.example.databindingdemo.databinding.ActivityMain6Binding;
import com.example.databindingdemo.databinding.ViewStubBinding;
import com.example.databindingdemo.modle.User;

public class Main6Activity extends AppCompatActivity {
    ActivityMain6Binding activityMain6Binding;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main6);
        activityMain6Binding = DataBindingUtil.setContentView(this, R.layout.activity_main6);

        activityMain6Binding.setHandler(new Handler());
        user = new User("Leo", "123456");
        activityMain6Binding.setUserInfo(user);
        activityMain6Binding.viewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                //如果在 xml 中没有使用 bind:userInfo="@{userInf}" 对 viewStub 进行数据绑定
                //那么可以在此处进行手动绑定
                ViewStubBinding viewStubBinding = DataBindingUtil.bind(inflated);
                viewStubBinding.setUserInfo(user);
                Log.e("Leo", "onInflate:" + user.getName());
            }
        });
    }

    public class Handler {

        public void onClick(View v) {
            if (!activityMain6Binding.viewStub.isInflated()) {
                activityMain6Binding.viewStub.getViewStub().inflate();
            }
        }

    }
}
