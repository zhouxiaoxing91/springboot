package com.nancy.exception;

import com.nancy.enums.ResponseEnum;

/**
 * All rights Reserved, Designed By guangfeng.zhou
 *
 * @version V1.0
 * @Project: springboot
 * @Package: com.nancy.exception
 * @Description: (用一句话描述该文件做什么)
 * @author: guangfeng.zhou
 * @date: 2017/9/14 10:15
 */
public class ResponException extends Exception {
   private String code ;
   private String msg ;

    public ResponException(String code, String msg) {
        super(msg);
        this.code = code ;
    }

    public ResponException(String msg) {
        this(ResponseEnum.FAIL.getCode(), msg) ;
    }

    public ResponException() {
        this(ResponseEnum.FAIL.getCode(), null) ;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
