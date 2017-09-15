package com.nancy.model;


import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by sh00912 on 2017/7/17.
 */

@Getter
@Setter
public class User implements Serializable {

    private int id;
    private int age ;
    private String username ;
    private String sex ;
    private String address ;
    private Date birthday ;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
