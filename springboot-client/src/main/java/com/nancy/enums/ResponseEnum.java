package com.nancy.enums;

/**
 * All rights Reserved, Designed By guangfeng.zhou
 *
 * @version V1.0
 * @Project: springboot
 * @Package: com.nancy.enums
 * @Description: (用一句话描述该文件做什么)
 * @author: guangfeng.zhou
 * @date: 2017/9/14 10:17
 */
public enum ResponseEnum {

    FAIL("500","失败"),
    SUCCESS("200","成功"),
    EXCEPTION("999","异常");

    private String code ;
    private String msg ;

    ResponseEnum(String code, String msg ){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
