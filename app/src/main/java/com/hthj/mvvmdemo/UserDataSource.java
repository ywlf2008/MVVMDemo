package com.hthj.mvvmdemo;

import android.arch.lifecycle.LiveData;

/**
 * Created by Henry_yw on 2018/2/2.
 */

public interface UserDataSource {
    LiveData<User> queryUserByUsername(String username);
}
