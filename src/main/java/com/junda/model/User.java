package com.junda.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    Long id;
    Long userId;
    String name;
    String sex;
    Integer age;
    Integer status;
    Date createTime;
    Date updateTime;

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public User(Long id, Long userId, String name, String sex, Integer age, Integer status, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
