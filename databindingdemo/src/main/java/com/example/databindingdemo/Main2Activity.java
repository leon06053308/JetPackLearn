package com.example.databindingdemo;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.databindingdemo.databinding.ActivityMain2Binding;
import com.example.databindingdemo.modle.Goods;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {
    private Goods goods;
    private ActivityMain2Binding activityMain2Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main2);
        activityMain2Binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
        goods = new Goods("code", "hi", 24);
        activityMain2Binding.setGoods(goods);
        activityMain2Binding.setGoodsHandler(new GoodsHandler());

        goods.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                switch (propertyId){
                    /*case BR.name:
                        Log.d("Leo", "BR.name");
                        break;
                    case BR.details:
                        Log.d("Leo", "BR.details");
                        break;
                    case BR._all:
                        Log.d("Leo", "BR._all");
                        break;
                    default:
                        Log.d("Leo", "unknown");
                        break;*/
                }
            }
        });
    }

    public class GoodsHandler{
        public void changeGoodsName(){
            goods.setName("code" + new Random().nextInt(100));
            goods.setPrice(new Random().nextInt(100));
        }

        public void changeGoodsDetails(){
            goods.setDetails("hi" + new Random().nextInt(100));
            goods.setPrice(new Random().nextInt(100));
        }
    }
}
