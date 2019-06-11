package com.mongodb.domain.base.bill;

import com.mongodb.domain.base.BaseEntity;
import org.springframework.data.mongodb.core.mapping.Field;

public class BillItem extends BaseEntity {

    @Field(value = "bill_id")
    private String billId;

    @Field(value = "h_Id")
    private String hId;

    @Field(value = "h_isbn")
    private String hIsbn;
    public BillItem(){}
    public BillItem(String billId, String hId, String hIsbn) {
        this.billId = billId;
        this.hId = hId;
        this.hIsbn = hIsbn;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String gethId() {
        return hId;
    }

    public void sethId(String hId) {
        this.hId = hId;
    }

    public String gethIsbn() {
        return hIsbn;
    }

    public void sethIsbn(String hIsbn) {
        this.hIsbn = hIsbn;
    }

    @Override
    public String toString() {
        return "BillItem{" +
                "billId='" + billId + '\'' +
                ", hId='" + hId + '\'' +
                ", hIsbn='" + hIsbn + '\'' +
                '}';
    }
}
