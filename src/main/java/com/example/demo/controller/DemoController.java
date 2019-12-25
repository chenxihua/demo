package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.Dept;
import com.example.demo.bean.User;
import com.example.demo.bean.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: DemoController
 * @Create By: chenxihua
 * @Author: Administrator
 * @Date: 2019/12/3 14:36
 **/
@Slf4j
@RestController
@RequestMapping(value = "/demo")
public class DemoController {



    @GetMapping(value = "/docker")
    public Map<String, Object> getDatas(){
        Map<String, Object> result = new HashMap<>();

        String msg = "我陈喜华， 曾想过要考研，可失败了。。。";
        result.put("code", 0);
        result.put("msg", msg);
        return result;
    }

    /**
     * 如果使用 阿里巴巴的 fastjson 插件，就不要使用像类 UserUtil 这种高度包装的类。
     *      1：先获取 Message。
     *      2：再转换成对应的 实体。
     */


    @GetMapping(value = "/jenkins")
    public String getDemo(){
        return "chenxihua, you can do docker success!";
    }


    /**
     * {
     * 	"Message": {
     * 		"id": 12,
     * 		"username": "chenxihua"
     *        }
     * }
     * @param msg
     * @return
     */
    @PostMapping(value = "/json")
    public String postJson(@RequestBody String msg){
        log.warn("message:-->: {}", msg);
        JSONObject jsonObject = JSONObject.parseObject(msg);

        JSONObject message = jsonObject.getJSONObject("Message");
        log.info("message:--> : {}", message);

        User user = JSONObject.toJavaObject(message, User.class);
        log.info("user: {}", user.toString());

        return user.toString();
    }

    /**
     * {
     * 	"Message": {
     * 		"username": null,
     * 		"desption": "陈喜华",
     * 		"password": null
     *        }
     * }
     * @param msg
     * @return
     */
    @PostMapping(value = "/dept")
    public String postDept(@RequestBody String msg){

        Dept dept;

        log.warn("1: {}", msg);
        JSONObject jsonObject = JSONObject.parseObject(msg);

        JSONObject message = jsonObject.getJSONObject("Message");
        log.warn("2: {}", message);

        dept = JSONObject.toJavaObject(message, Dept.class);
        log.info("3: {}", dept.toString());

        return dept.toString();
    }


    /***
     * {
     * 	"Message": {
     * 		"id": 12,
     * 		"username": "chenxihua",
     * 		"password": "12346",
     * 		"Dept": [{
     * 			"username": "zhong chuying",
     * 			"desption": "null"
     *                },
     *        {
     * 			"username": "zhong 111",
     * 			"desption": "zhong 222"
     *        }]    * 	}
     * }
     *
     * @param msg
     * @return
     */
    @PostMapping(value = "/user")
    public String postList(@RequestBody String msg){
        log.info("1: {}", msg);
        JSONObject jsonObject = JSONObject.parseObject(msg);

        JSONObject message = jsonObject.getJSONObject("Message");
        log.info("2: {}", message);

        UserVo userVo = JSONObject.toJavaObject(message, UserVo.class);
        log.info("3: {}", userVo.toString());

        JSONArray jsonArray = message.getJSONArray("Dept");
        log.info("4: {}", jsonArray);

        List<Dept> dept = userVo.getDept();
        for (Dept d : dept) {
            log.info("循环： {}", d.toString());
        }

        return jsonArray.toString();
    }

}
