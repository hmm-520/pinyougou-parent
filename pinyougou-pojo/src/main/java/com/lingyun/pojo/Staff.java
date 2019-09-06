package com.lingyun.pojo;

import java.io.Serializable;

public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private  String code;
    private  String  realname;
    private  Integer sex;
    private  Integer phone;
    private  Integer officephone;
    private   String email;
    private  Integer center;
    private  String description;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getOfficephone() {
        return officephone;
    }

    public void setOfficephone(Integer officephone) {
        this.officephone = officephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCenter() {
        return center;
    }

    public void setCenter(Integer center) {
        this.center = center;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
