package com.mongodb.base;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Administrator on 2016/10/30.
 */
@Document
public class Users extends Person {

    @Id
    private String id;

    private String job;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id='" + id + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
