import com.mongodb.App;
import com.mongodb.MongoClient;
import com.mongodb.application.DispatchApp;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.domain.base.bill.Bill;
import com.mongodb.domain.base.bill.BillItem;
import com.mongodb.infrastructure.JPA.JpaDispatchRepository;
import com.mongodb.utils.MongoDBUtil;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)// 指定spring-boot的启动类
public class DispBillTests {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    JpaDispatchRepository jpaDispatchRepository;

    @Autowired
    private DispatchApp dispatchApp;


    //修改多个文档
    @Test
    public void updateManyTest() {
        //获取数据库连接对象
        MongoDatabase mongoDatabase = MongoDBUtil.getConnect();
        //获取集合
        MongoCollection<Document> collection = mongoDatabase.getCollection("dispatch_bill");
        //修改过滤器
        Bson filter = Filters.eq("dispatchBillItemList.h_id", "H001");
        //指定修改的更新文档
        Document document = new Document("$set", new Document("dispatchBillItemList.h_Id", "test"));
        //修改多个文档
        collection.updateMany(filter, document);
    }


    @Test
    public void updateAll() {
// 连接到 mongodb 服务
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        // 连接到数据库hello
        // 如果指定的数据库不存在，MongoDB会自动创建数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
        System.out.println("连接到数据库hello");
        // 创建集合
//        mongoDatabase.createCollection("students");
//        System.out.println("集合students创建成功");
        // 选择集合
        MongoCollection<Document> collection = mongoDatabase.getCollection("dispatch_bill");
        System.out.println("集合students选择成功");
        // 插入文档
        // 更新文档
        // 将文档中age=31的文档修改为age=32
        //"grades.$[element]
        collection.updateMany(Filters.eq("dispatchBillItemList.h_id", "H001"),
                new Document("$set", new Document("dispatchBillItemList.$.h_Id", "test")));
        System.out.println("文档更新成功");
        // 检索所有文档
        /**
         * 1. 获取迭代器FindIterable<Document> 2. 获取游标MongoCursor<Document> 3.
         * 通过游标遍历检索出的文档集合
         */
        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()) {
            System.out.println(mongoCursor.next());
        }
        // 关闭连接
        mongoClient.close();


    }


    @Test
    public void testUpdate() {

        String billId = "B00";
        String hId = "H001";
        try {
            Query query = Query.query(Criteria.where("bill_id").is(billId).and("dispatchBillItemList.h_Id").is(hId));
            Update update = new Update();
            update.set("dispatchBillItemList.$.h_Id", "test");
            //   update.set("dispatchBillItemList.$.h_Id", "test");
            mongoTemplate.updateMulti(query, update, "dispatch_bill");
//          mongoTemplate.updateMulti(query, update, Bill.class);
        } catch (Exception e) {
            e.getStackTrace();
        }


    }


    @Test
    public void testAdd() {
        Bill bill = new Bill();
        List<BillItem> billItems = new ArrayList<>();
        bill.setBillId("B00");
        for (int i = 0; i < 5; i++) {
            BillItem billItem = new BillItem();
            billItem.setBillId(bill.getBillId());
            billItem.sethId("H001");
            billItem.sethIsbn("123");
            billItems.add(billItem);
        }
        bill.setDispatchBillItemList(billItems);
        dispatchApp.save(bill);
    }

    @Test
    public void deleteAll() {
        jpaDispatchRepository.deleteAll();
//        mongoTemplate.dropCollection("dispatch_bill");
    }
}
