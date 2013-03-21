package spring.aop_Annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml", UserManagerAscept.class);
        UserManagerService um = ctx.getBean("userManagerService", UserManagerService.class);
        System.out.println("------Case 1--------");
        um.addUser("limingzi");
        System.out.println("------Case 2--------");
        try {
            um.editUser();

        } catch (Exception e) {
        }
        System.out.println("------Case 3--------");
        um.getUser();
    }
}