package com.hthj.mvvmdemo;

import android.arch.lifecycle.LiveData;

/**
 * Created by Henry_yw on 2018/2/2.
 */

public class LocalUserDataSource implements UserDataSource {
    private static final LocalUserDataSource instance = new LocalUserDataSource();
    private LocalUserDataSource() {
    }
    public static LocalUserDataSource getInstance() {
        return instance;
    }


    private UserService userService = UserServiceImpl.getInstance();

    @Override
    public LiveData<User> queryUserByUsername(String username) {
        return userService.queryByUsername(username);
    }

    public LiveData<Long> addUser(User user) {
        return userService.add(user);
    }
}
