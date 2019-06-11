import com.mongodb.App;
import com.mongodb.application.DispatchApp;
import com.mongodb.domain.base.bill.Bill;
import com.mongodb.domain.base.bill.BillItem;
import com.mongodb.infrastructure.JPA.JpaDispatchRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)

public class DispBillTests {
    @Autowired
    JpaDispatchRepository jpaDispatchRepository;

    @Autowired
    private DispatchApp dispatchApp;

    /**
     * 通过明细的hid 查询 单号,修改后保存单据
     */
    @Test
    public void findAndUpdate() {
        String oldhId = "";
        String newhId = "";
        dispatchApp.findAndUpdate(oldhId, newhId);
    }

    @Test
    public void testAdd() {
        Bill bill = new Bill();
        List<BillItem> billItems = new ArrayList<>();
        bill.setBillId("B001");
        for (int i = 0; i < 5; i++) {
            BillItem billItem = new BillItem();
            billItem.setBillId(bill.getBillId());
            billItem.sethId("H001");
            billItem.sethIsbn("111");
            billItems.add(billItem);
        }
        bill.setDispatchBillItemList(billItems);
        dispatchApp.save(bill);

        Bill bill2 = new Bill();
        List<BillItem> billItems2 = new ArrayList<>();
        bill2.setBillId("B002");
        for (int i = 0; i < 5; i++) {
            BillItem billItem = new BillItem();
            billItem.setBillId(bill2.getBillId());
            billItem.sethId("H002");
            billItem.sethIsbn("222");
            billItems2.add(billItem);
        }
        bill2.setDispatchBillItemList(billItems2);
        dispatchApp.save(bill2);


    }

    @Test
    public void deleteAll() {
        jpaDispatchRepository.deleteAll();
//        mongoTemplate.dropCollection("dispatch_bill");
    }


//    //修改多个文档
//    @Test
//    public void updateManyTest() {
//        //获取数据库连接对象
//        MongoDatabase mongoDatabase = MongoDBUtil.getConnect();
//        //获取集合
//        MongoCollection<Document> collection = mongoDatabase.getCollection("dispatch_bill");
//        //修改过滤器
//        Bson filter = Filters.eq("dispatchBillItemList.$.h_id", "H001");
//        //指定修改的更新文档
//        Document document = new Document("$set", new Document("dispatchBillItemList.h_Id", "test"));
//        //修改多个文档
//        collection.updateMany(filter, document);
//    }

//    @Test
//    public void testUpdate() {
//        String hid = "wwww";
//        String bill_id = "B00";
//        try {
//            Query query = Query.query(Criteria.where("dispatchBillItemList.h_Id").is(hid));
//            Update update = new Update();
//            update.set("dispatchBillItemList.$.h_Id", "test");
//            //   update.set("dispatchBillItemList.$.h_Id", "test");
//            //   update.set("dispatchBillItemList.$.h_Id", "test");
//            //WriteResult writeResult = mongoTemplate.updateMulti(query, update, "dispatch_bill");
//            WriteResult writeResult = mongoTemplate.updateMulti(query, update, Bill.class);
//            System.out.println(writeResult.toString());
////          mongoTemplate.updateMulti(query, update, Bill.class);
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//    }


//    @Test
//    public void updateAll() {
//// 连接到 mongodb 服务
//        MongoClient mongoClient = new MongoClient("localhost", 27017);
//        // 连接到数据库hello
//        // 如果指定的数据库不存在，MongoDB会自动创建数据库
//        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
//        System.out.println("连接到数据库hello");
//        // 创建集合
////        mongoDatabase.createCollection("students");
////        System.out.println("集合students创建成功");
//        // 选择集合
//        MongoCollection<Document> collection = mongoDatabase.getCollection("dispatch_bill");
//        System.out.println("集合students选择成功");
//        // 插入文档
//        // 更新文档
//        // 将文档中age=31的文档修改为age=32
//        //"grades.$[element]
//        collection.updateMany(Filters.eq("dispatchBillItemList.h_id", "H001"),
//                new Document("$set", new Document("dispatchBillItemList.$.h_Id", "test")));
//        System.out.println("文档更新成功");
//        // 检索所有文档
//        /**
//         * 1. 获取迭代器FindIterable<Document> 2. 获取游标MongoCursor<Document> 3.
//         * 通过游标遍历检索出的文档集合
//         */
//        FindIterable<Document> findIterable = collection.find();
//        MongoCursor<Document> mongoCursor = findIterable.iterator();
//        while (mongoCursor.hasNext()) {
//            System.out.println(mongoCursor.next());
//        }
//        // 关闭连接
//        mongoClient.close();
//
//
//    }
}
