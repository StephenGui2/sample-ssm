package com.junda.common;

public enum ResultEnum {

    EMPTY_USER_LIST(1, "当前没有用户"),
    DELETE_NO_CURRENT_USER(2, "删除失败，没有当前用户！"),
    ADD_USER_FAIL(3, "添加用户失败！"),
    UPDATE_NO_CURRENT_USER(4, "更新用户失败，没有该用户！"),
    UPDATE_USER_FAIL(5, "更新用户失败！"),
    FIND_USER_ERROR(6, "查询失败"),
    NAME_EMPTY(7, "用户名不能为空"),
    SEX_EMPTY(8, "性别不能为空"),
    AGE_EMPTY(9, "年龄不能为空"),
    SATTUS_EMPTY(10, "用户状态不能为空");

    public final int status;
    public final String desc;

    ResultEnum(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
