package com.lingyun.pojo;

import java.io.Serializable;

public class TBrand implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private String typename;

    private String brand;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }
}