package com.hthj.mvvmdemo;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hthj.mvvmdemo.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    private void initData() {
        DBHelper.getInstance().init(this);
        UserRepository.getInstance().init(this);
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.getUser("ittianyu").observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                Log.i("update","update");
                updateView(user);
            }
        });
    }

    private void updateView(User user) {
        binding.tvId.setText(user.getId() + "");
        binding.tvName.setText(user.getName());
    }
}
