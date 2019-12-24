package com.example.demo.bean;

import lombok.Data;

import java.util.List;

/**
 * @ClassName: UserVo
 * @Create By: chenxihua
 * @Author: Administrator
 * @Date: 2019/12/4 10:56
 **/
@Data
public class UserVo {


    private Integer id;

    private String username;

    private String password;

    private List<Dept> dept;


}
