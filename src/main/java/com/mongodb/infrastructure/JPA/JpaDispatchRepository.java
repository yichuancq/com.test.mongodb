package com.mongodb.infrastructure.JPA;

import com.mongodb.domain.base.bill.Bill;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaDispatchRepository  extends MongoRepository<Bill, String> {

    /**
     * @param dispatchBill
     * @return
     */
    Bill save(Bill dispatchBill);


}
