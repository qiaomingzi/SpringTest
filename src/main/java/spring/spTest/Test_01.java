package spring.spTest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

public class Test_01 {
    private static final Log logger = LogFactory.getLog(Test_01.class);
    public void methodA(int a,String... names) {
        logger.debug(a);
        for (String name : names) {
            logger.debug(name);
        }
    }
    public static void main(String[] args) {
        Assert.isNull(null);
        Assert.hasLength("plmz");
        logger.debug("...array here...");

        /*
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        System.out.println(context);
        */
        Test_01 test = new Test_01();
        test.methodA(1,"11","22");
        test.methodA(1,new String[]{"33","44"});
    }
}
