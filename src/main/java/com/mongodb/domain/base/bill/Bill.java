package com.mongodb.domain.base.bill;

import com.mongodb.domain.base.BaseEntity;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Document(collection = "dispatch_bill")
public class Bill extends BaseEntity {

    @OneToMany
    private List<BillItem> dispatchBillItemList;

    @Id
    private String id;
    /**
     * 索引
     */
    @Indexed(unique = true)
    @Field(value = "bill_id")
    private String billId;

    public List<BillItem> getDispatchBillItemList() {
        return dispatchBillItemList;
    }

    public void setDispatchBillItemList(List<BillItem> dispatchBillItemList) {
        this.dispatchBillItemList = dispatchBillItemList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "dispatchBillItemList=" + dispatchBillItemList +
                ", id='" + id + '\'' +
                ", billId='" + billId + '\'' +
                '}';
    }
}
