package com.mongodb.repository;


import com.mongodb.base.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Administrator on 2016/10/30.
 */

public interface UserRepository extends MongoRepository<Users, String> {


    void test();

    List<Users> findAll();

    List<Users> findByName(String name);

}
