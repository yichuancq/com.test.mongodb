package com.mongodb.base;

/**
 * Created by yichuan on 2017/5/27.
 */
public class Street {
    private String roadName;
    private String postCode;

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "Street{" +
                "roadName='" + roadName + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }
}
