package com.mongodb.repository;

import com.mongodb.base.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by yichuan on 2017/5/27.
 */
public interface PersonRepository   extends MongoRepository<Person, String> {
}
