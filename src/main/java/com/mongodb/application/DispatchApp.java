package com.mongodb.application;

import com.mongodb.domain.base.bill.Bill;
import com.mongodb.infrastructure.DispatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispatchApp {
    @Autowired
    DispatchRepository dispatchRepository;


    /**
     * @param bill
     * @return
     */
    public Bill save(Bill bill) {

        return dispatchRepository.saveDispatchBill(bill);
    }


}
