package spring.jpa;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/jpa/jpa.xml"})
@Transactional
public class TestJpa {
    @Autowired
    private UserDaoRepository userDaoRepository;
    @Autowired
    private UserService userService;

    //http://z276356445t.iteye.com/blog/1596277
    //http://www.ibm.com/developerworks/cn/opensource/os-cn-spring-jpa/index.html
    @Before
    public void setUp() throws Exception {
        /*for ( int i = 0; i <= 6; i++ ) {
            userDaoRepository.save(new User("User "+i));
        }*/
    }

    @Test
    @Rollback(false)  //不然会自动回滚
    public void saveUser(){
       // ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"jpa.xml"},TestJpa.class);
        //userDaoRepository = (UserDaoRepository)context.getBean("userDaoRepository");
        System.out.println("saveUser");
        User u1 = new User();
        u1.setName("lmz");
        System.out.println("ID: "+u1.getId());
        u1 = userDaoRepository.save(u1);

        User u2 = new User();
        u2.setName("bbb");
        u2 = userDaoRepository.save(u2);
        System.out.println("ID: "+u2.getId());
    }
}
