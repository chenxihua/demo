package com.example.demo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: User
 * @Create By: chenxihua
 * @Author: Administrator
 * @Date: 2019/12/4 9:28
 **/
@Data
public class User implements Serializable {

    private Integer id;

    private String username;

    private String password;



}
