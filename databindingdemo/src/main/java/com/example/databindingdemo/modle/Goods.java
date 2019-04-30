package com.example.databindingdemo.modle;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.example.databindingdemo.BR;

public class Goods extends BaseObservable {
    private String name;

    //如果是 private 修饰符，则在成员变量的 get 方法上添加 @Bindable 注解
    private String details;

    private float price;

    public Goods(String name, String details, float price){
        this.name = name;
        this.details = details;
        this.price = price;
    }

    @Bindable
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;

        notifyChange();
        //notifyPropertyChanged(BR.name);
    }

    public String getDetails(){
        return details;
    }

    public void setDetails(String details){
        this.details = details;
        //notifyChange();
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
