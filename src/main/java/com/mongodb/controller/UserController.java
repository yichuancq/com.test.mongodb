package com.mongodb.controller;

import com.mongodb.base.Users;
import com.mongodb.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2016/10/30.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository; // 属性注入

    @Autowired
    private MongoTemplate mongoTemplate;


    @RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
    public boolean deleteAll() {
        try {

            userRepository.deleteAll();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping(value = "addOne", method = RequestMethod.GET)
    @ApiOperation("添加单个用户")
    public String save() {
        try {
            Users demoInfo = new Users();
            demoInfo.setName("张三");
            demoInfo.setAge(20);
            userRepository.save(demoInfo);
            return "添加成功";
        } catch (Exception e) {

            e.printStackTrace();
            // return "添加失败";
        }
        return "添加失败";
    }


    @ApiOperation("get By age")
    @RequestMapping(value = "/getByAge", method = RequestMethod.GET)
    public List<Users> findOne(Integer age) {

        Query query = new Query();
        query.addCriteria(new Criteria("age").is(age));
        return mongoTemplate.find(query, Users.class);
    }

    @ApiOperation("获取所有的Users")
    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public List<Users> findTwo() {

        return userRepository.findAll();
    }


    @ApiOperation(value = "获取UserRepository信息", notes = "UserRepository获取用户详细信息")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll() {

        String str;
        str = userRepository.findAll().toString();
        System.out.println("val:" + str);
        return str;

    }

    /**
     * @return
     */

    @ApiOperation(value = "addAll", notes = "addAll")
    @RequestMapping(value = "/addAll", method = RequestMethod.GET)
    public String addAll() {

        String str = "";
        //
        // final List<Users> usersList = new ArrayList<>();
//        for (int i = 0; i < 50; i++) {
//            Users user = new Users(null, "name" + i, 10 + i);
//            userRepository.save(user);
//            System.out.println("" + user.toString());
//        }

        return str;
    }


}
