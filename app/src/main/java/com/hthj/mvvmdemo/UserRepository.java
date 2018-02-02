package com.hthj.mvvmdemo;

import android.arch.lifecycle.LiveData;
import android.content.Context;

/**
 * Created by Henry_yw on 2018/2/2.
 */

public class UserRepository {
//    private static final UserRepository instance = new UserRepository();
//
//    private UserRepository() {
//    }
//
//    public static UserRepository getInstance() {
//        return instance;
//    }
//
//    private UserApi userApi = RetrofitFactory.getInstance().create(UserApi.class);
//
//    public LiveData<User> getUser(String username) {
//        final MutableLiveData<User> user = new MutableLiveData<>();
//        userApi.queryUserByUsername(username)
//                .enqueue(new Callback<User>() {
//                    @Override
//                    public void onResponse(Call<User> call, Response<User> response) {
//                        user.setValue(response.body());
//                    }
//
//                    @Override
//                    public void onFailure(Call<User> call, Throwable t) {
//                        t.printStackTrace();
//                    }
//                });
//        return user;
//    }


    private static final UserRepository instance = new UserRepository();
    private UserRepository() {
    }
    public static UserRepository getInstance() {
        return instance;
    }


    private Context context;
    private UserDataSource remoteUserDataSource = RemoteUserDataSource.getInstance();
    private UserDataSource localUserDataSource = LocalUserDataSource.getInstance();

    public void init(Context context) {
        this.context = context.getApplicationContext();
    }

    public LiveData<User> getUser(String username) {
        if (NetworkUtils.isConnected(context)) {
            return remoteUserDataSource.queryUserByUsername(username);
        } else {
            return localUserDataSource.queryUserByUsername(username);
        }
    }

}
