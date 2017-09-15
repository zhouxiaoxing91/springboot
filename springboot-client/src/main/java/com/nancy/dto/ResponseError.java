package com.nancy.dto;

import com.alibaba.fastjson.JSON;

/**
 * All rights Reserved, Designed By guangfeng.zhou
 *
 * @version V1.0
 * @Project: springboot
 * @Package: com.nancy.dto
 * @Description: (用一句话描述该文件做什么)
 * @author: guangfeng.zhou
 * @date: 2017/9/14 10:28
 */
public class ResponseError<T> {
    private String code;
    private String message;
    private String url;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override public String toString() {
        return JSON.toJSONString(this);
    }
}
