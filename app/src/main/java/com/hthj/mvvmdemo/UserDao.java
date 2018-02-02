package com.hthj.mvvmdemo;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

/**
 * Created by Henry_yw on 2018/2/2.
 */


@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
// cache need update
    Long add(User user);

    @Query("select * from user where login = :username")
    LiveData<User> queryByUsername(String username);
}

