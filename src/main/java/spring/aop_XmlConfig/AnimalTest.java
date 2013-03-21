package spring.aop_XmlConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-1
 * Time: 下午4:43
 * To change this template use File | Settings | File Templates.
 */
public class AnimalTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml",AnimalTest.class);
        AnimalService animalService = (AnimalService)context.getBean("pigService");
        animalService.sleep();
    }
}
