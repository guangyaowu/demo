package com.example.demo.redis_cache_test;

import java.io.Serializable;

public class Model implements Serializable {
    private String name;//姓名
    private String tel;//电话
    private String address;//住址


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
