package com.hthj.mvvmdemo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by Henry_yw on 2018/2/2.
 */

public class UserViewModel extends ViewModel {

    private UserRepository userRepository = UserRepository.getInstance();
    private LiveData<User> user;

    public LiveData<User> getUser(String username) {
        if (null == user)
            user = userRepository.getUser(username);
        return user;
    }

//    private MutableLiveData<User> user;
//    private User mUser = new User(1, "");
//
//    public LiveData<User> getUser() {
//        if (user == null){
//            user = new MutableLiveData<>();
//            user = UserRepository.getInstance().getUser()
//        }
//
//        return user;
//    }
//
//    public void setUsername(String username) {
//        mUser.setName(username);
//        user.setValue(mUser);
//    }
}
