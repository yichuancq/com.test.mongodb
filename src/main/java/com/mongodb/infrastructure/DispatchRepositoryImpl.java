package com.mongodb.infrastructure;

import com.mongodb.domain.base.bill.Bill;
import com.mongodb.infrastructure.JPA.JpaDispatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DispatchRepositoryImpl implements DispatchRepository {
    @Autowired
    JpaDispatchRepository jpaDispatchRepository;

    @Override
    public Bill saveDispatchBill(Bill dispatchBill) {
        return jpaDispatchRepository.save(dispatchBill);
    }
}
