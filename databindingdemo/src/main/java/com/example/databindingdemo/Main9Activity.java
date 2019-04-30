package com.example.databindingdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.databindingdemo.databinding.ActivityMain9Binding;
import com.example.databindingdemo.modle.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main9Activity extends AppCompatActivity {
    private List<User> users;
    private ActivityMain9Binding main9Binding;
    DataBindingDemoAdapter dataBindingDemoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main9);
        main9Binding = DataBindingUtil.setContentView(this, R.layout.activity_main9);
        main9Binding.setClickmanager(new ClickManager());

        main9Binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        users = new ArrayList<>();
        for (int i= 0; i < 20; ++i){
            User user = new User("Leo", "111" + i);
            users.add(user);
        }

        dataBindingDemoAdapter = new DataBindingDemoAdapter(users, this);
        main9Binding.recyclerView.setAdapter(dataBindingDemoAdapter);
    }

    public class ClickManager{
        public void addMyClickListenner(){
            User user = new User();
            Random random = new Random();
            int randomInt = random.nextInt(100);
            user.setName("新增用户" + randomInt);
            user.setPassword(String.valueOf(randomInt));
            users.add(user);
            dataBindingDemoAdapter.notifyDataSetChanged();
        }
    }

    public class DataBindingDemoAdapter extends RecyclerView.Adapter<DataBindingDemoAdapter.BindingViewHolder>{
        private List<User> list;
        private Context mContext;
        private LayoutInflater mInflater;

        public DataBindingDemoAdapter(List<User> list, Context context){
            this.list = list;
            this.mContext = context;
            mInflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

        }

        @NonNull
        @Override
        public BindingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ViewDataBinding dataBinding = DataBindingUtil.inflate(mInflater, R.layout.item_list, parent, false);

            return new BindingViewHolder(dataBinding);
        }

        @Override
        public void onBindViewHolder(@NonNull BindingViewHolder holder, int position) {
            User user = list.get(position);
            ViewDataBinding dataBinding = holder.getBinding();
            dataBinding.setVariable(BR.user, user);
            dataBinding.executePendingBindings();
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder{
            private T mBinding;

            public T getBinding(){
                return mBinding;
            }

            public BindingViewHolder(@NonNull T binding) {
                super(binding.getRoot());
                this.mBinding = binding;
            }
        }
    }
}
