package com.mongodb.infrastructure;

import com.mongodb.domain.base.bill.Bill;

public interface DispatchRepository {

    Bill saveDispatchBill(Bill dispatchBill);

}
