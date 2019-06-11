package com.mongodb.application;

import com.mongodb.domain.base.bill.Bill;
import com.mongodb.domain.base.bill.BillItem;
import com.mongodb.infrastructure.DispatchRepository;
import com.mongodb.infrastructure.JPA.JpaDispatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispatchApp {
    @Autowired
    DispatchRepository dispatchRepository;

    @Autowired
    JpaDispatchRepository jpaDispatchRepository;

    @Autowired
    protected MongoTemplate mongoTemplate;


    /**
     * @param oldId
     * @param newhId
     */
    public void findAndUpdate(String oldId, String newhId) {
        Query query = Query.query(Criteria.where("dispatchBillItemList.h_Id").is(oldId));
        //Query query = Query.query(Criteria.where("bill_id").is(bill_id));
        List<Bill> billList = mongoTemplate.find(query, (Bill.class));
        for (Bill bill : billList) {
            for (BillItem billItem : bill.getDispatchBillItemList()) {
                billItem.sethId(newhId);
            }
        }
        jpaDispatchRepository.save(billList);
    }

    /**
     * @param bill
     * @return
     */
    public Bill save(Bill bill) {

        return dispatchRepository.saveDispatchBill(bill);
    }


}
