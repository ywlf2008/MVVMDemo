package com.hthj.mvvmdemo;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.hthj.mvvmdemo.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private TextView tvId;
    private TextView tvName;
    private Button btnGet;
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
//        tvId = (TextView) findViewById(R.id.tv_id);
//        tvName = (TextView) findViewById(R.id.tv_name);
//        btnGet = (Button) findViewById(R.id.btn_get);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    private void initData() {
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.getUser("ittianyu").observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                Log.i("update","update");
                updateView(user);
            }
        });
//        userViewModel.setUsername("ittianyu");
//        binding.btnGet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                userViewModel.setUsername("get");
//            }
//        });

    }

    private void updateView(User user) {
        binding.tvId.setText(user.getId() + "");
        binding.tvName.setText(user.getName());
    }
}
