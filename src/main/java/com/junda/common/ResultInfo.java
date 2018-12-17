package com.junda.common;

import java.io.Serializable;

public class ResultInfo<T> implements Serializable {

    public int status;  // 0成功 ，其余失败
    public String message;  // 错误信息
    public T data;   // 成功返回的数据

    public ResultInfo(int status, String message) {
        this.status = status;
        this.message = message;
        this.data = null;
    }

    public ResultInfo(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static ResultInfo createSuccess() {
        return new ResultInfo(0, null, null);
    }

    public static <T> ResultInfo<T> createSuccess(T data) {
        return new ResultInfo(0, null, data);
    }
}
