package com.example.databindingdemo;

import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingConversion;
import androidx.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import com.example.databindingdemo.databinding.ActivityMain7Binding;
import com.example.databindingdemo.modle.Image;

import java.util.Random;

public class Main7Activity extends AppCompatActivity {
    private ActivityMain7Binding activityMain7Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main7);
        activityMain7Binding = DataBindingUtil.setContentView(this, R.layout.activity_main7);
        activityMain7Binding.setImage(new Image("xxxxxxx"));
        activityMain7Binding.setHandler(new Handler());
    }
    public class Handler {

        public void onClick(Image image) {
            image.getUrl().set("xxxxx" + new Random().nextInt(1000));
        }

    }

    @BindingAdapter("url")
    public static void loadImage(ImageView view, String url) {
        Log.d("Leo", "loadImage url : " + url);
    }

    @BindingConversion
    public static Drawable convertStringToDrawable(String str) {
        if (str.equals("红色")) {
            return new ColorDrawable(Color.parseColor("#FF4081"));
        }
        if (str.equals("蓝色")) {
            return new ColorDrawable(Color.parseColor("#3F51B5"));
        }
        return new ColorDrawable(Color.parseColor("#344567"));
    }

    @BindingConversion
    public static int convertStringToColor(String str) {
        if (str.equals("红色")) {
            return Color.parseColor("#FF4081");
        }
        if (str.equals("蓝色")) {
            return Color.parseColor("#3F51B5");
        }
        return Color.parseColor("#344567");
    }
}
