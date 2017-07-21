package com.shenma.model;


import com.quick.mybatis.annotation.Column;
import com.quick.mybatis.annotation.Id;
import com.quick.mybatis.annotation.Table;
import com.quick.mybatis.constants.JavaType;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by sh00912 on 2017/7/17.
 */

@Getter
@Setter
@Table(tableName = "user")
public class User implements Serializable {

    @Id
    @Column(columnName = "id", javaType = JavaType.INTEGER, jdbcType = JdbcType.INTEGER, primaryKey = true)
    private int id;

    @Column(columnName = "age", javaType = JavaType.INTEGER, jdbcType = JdbcType.INTEGER)
    private int age ;

    @Column(columnName = "username", javaType = JavaType.STRING, jdbcType = JdbcType.VARCHAR)
    private String username ;

    @Column(columnName = "sex", javaType = JavaType.STRING, jdbcType = JdbcType.VARCHAR)
    private String sex ;

    @Column(columnName = "address", javaType = JavaType.STRING, jdbcType = JdbcType.VARCHAR)
    private String address ;

    @Column(columnName = "birthday", javaType = JavaType.DATE, jdbcType = JdbcType.TIMESTAMP)
    private Date birthday ;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
