import com.mongodb.App;
import com.mongodb.application.DispatchApp;
import com.mongodb.domain.base.bill.Bill;
import com.mongodb.domain.base.bill.BillItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)// 指定spring-boot的启动类
public class DispBillTests {

    @Autowired
    private DispatchApp dispatchApp;

    @Test
    public void testAdd() {
        Bill bill = new Bill();
        List<BillItem> billItems = new ArrayList<>();
        bill.setBillId("B00");
        for (int i = 0; i < 10; i++) {
            BillItem billItem = new BillItem();
            billItem.setBillId(bill.getBillId());
            billItem.sethId("H001");
            billItem.sethIsbn("123");
            billItems.add(billItem);
        }
        bill.setDispatchBillItemList(billItems);
        dispatchApp.save(bill);
    }
}
