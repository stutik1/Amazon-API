package com.stuti.amazon;

public class User {
    private Long userid ;
    private String name;
    private String email;
    private String address;
    private Long phone ;

    public User(Long userid, String name, String email, String address, Long phone) {
        this.userid = userid;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
