import com.mongodb.App;
import com.mongodb.base.Address;
import com.mongodb.base.Person;
import com.mongodb.base.Street;
import com.mongodb.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2016/10/30.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)// 指定spring-boot的启动类
public class ApplicationTests {


    @Autowired
    protected PersonRepository personRepository;

    @Test
    public void findByPersonId() {
        Person p = personRepository.findOne("101");//
        System.out.println("p:" + p.toString());

    }

    /**
     *
     */
    @Test
    public void findALl() {
        List<Person> personList = personRepository.findAll();
        for (Person p : personList) {
            // System.out.println("" + p.toString());

        }
    }


    @Test
    public void testAddAll() {


        personRepository.deleteAll();
        //List<Person> personList = new ArrayList<>();//
        for (int i = 0; i <= 100; i++) {
            //
            long start = System.currentTimeMillis();
            Person person = new Person();
            Address address = new Address();
            address.setAddr("地址A" + i);
            address.setPro("地址B" + i);
            //
            person.setAge(20);
            person.setName("name" + i);
            person.setId("10001" + i);
            person.setAddress(address);

            personRepository.save(person);
            long end = System.currentTimeMillis();
            //
            System.out.println("row:" + i + " 耗时:" + (end - start) + " 毫秒");
            //  personList.add(person);
        }


    }


    @Test
    public void testMe() {

        personRepository.deleteAll();

        Street street = new Street();
        street.setPostCode("5002000");
        street.setRoadName("南开大道5002");

        //
        Person person = new Person();
        Address address = new Address();
        address.setAddr("合肥");
        address.setPro("安徽");
        address.setStreet(street);

        //
        person.setAge(20);
        person.setName("senssic");
        person.setId("1");
        person.setAddress(address);
        personRepository.save(person);
        System.out.println("1. " + personRepository.findAll());

        person.setId("101");

        personRepository.save(person);//

        //
        System.out.println("2. " + personRepository.findAll());//


        personRepository.delete("1");

        System.out.println("4. " + personRepository.findAll());

    }


}
