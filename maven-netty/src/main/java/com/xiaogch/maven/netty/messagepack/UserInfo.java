package com.xiaogch.maven.netty.messagepack;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/14 17:50 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class UserInfo {

    private int id;
    private String name;
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
