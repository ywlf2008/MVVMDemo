package com.hthj.mvvmdemo;

import java.io.Serializable;

/**
 * Created by Henry_yw on 2018/2/2.
 */

public class User implements Serializable{

    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
