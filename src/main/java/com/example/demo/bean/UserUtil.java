package com.example.demo.bean;

import lombok.Data;

/**
 * @ClassName: UserUtil
 * @Create By: chenxihua
 * @Author: Administrator
 * @Date: 2019/12/4 10:18
 **/
@Data
public class UserUtil {

    private Message message;


    @Data
    public class Message {

        private Integer id;

        private String username;

        private String password;
    }

}
