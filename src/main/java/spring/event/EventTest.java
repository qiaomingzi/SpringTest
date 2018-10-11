package spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EventTest {
    public static void main(String args[]) {
        ApplicationContext context = new ClassPathXmlApplicationContext("eventTest.xml",EventTest.class);
//创建一个ApplicationEvent对象
        EmailEvent event = new EmailEvent("hello", "abc@163.com", "This is a test");
 //主动触发该事件
        context.publishEvent(event);
    }
}
