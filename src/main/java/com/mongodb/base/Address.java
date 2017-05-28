package com.mongodb.base;

/**
 * Created by yichuan on 2017/5/27.
 */
public class Address {

    private Street street;
    private String addr;
    private String pro;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street=" + street +
                ", addr='" + addr + '\'' +
                ", pro='" + pro + '\'' +
                '}';
    }
}
