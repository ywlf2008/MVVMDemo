package com.hthj.mvvmdemo;

import android.arch.lifecycle.LiveData;

/**
 * Created by Henry_yw on 2018/2/2.
 */

public interface UserService {
    LiveData<Long> add(User user);

    LiveData<User> queryByUsername(String username);
}
