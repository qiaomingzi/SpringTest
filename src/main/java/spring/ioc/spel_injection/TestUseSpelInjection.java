package spring.ioc.spel_injection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-17
 * Time: 下午5:29
 * To change this template use File | Settings | File Templates.
 */
@Service("testUseSpelInjection")
public class TestUseSpelInjection {
    @Value("#{injectSimpleConfig.name}")
    private String name;

    @Value("#{injectSimpleConfig.age + 1}")
    private int age;

    @Value("#{injectSimpleConfig.height}")
    private float height;

    @Value("#{injectSimpleConfig.programmer}")
    private boolean programmer;

    @Value("#{injectSimpleConfig.ageInSeconds}")
    private Long ageInSeconds;

    public String toString() {
        return    "Name :" + name + "\n"
                + "Age:" + age + "\n"
                + "Age in Seconds: " + ageInSeconds + "\n"
                + "Height: " + height + "\n"
                + "Is Programmer?: " + programmer;
    }
    @Test
    public void test01(){
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(InjectSimpleConfig.class,"injection-xml.xml");
        context.refresh();

        TestUseSpelInjection spelSimple = (TestUseSpelInjection)context.getBean("testUseSpelInjection");
        System.out.println(spelSimple.toString());
    }
    @Test
    public void test02(){
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(InjectSimpleConfig.class,"injection-annotation.xml");
        context.refresh();

        TestUseSpelInjection spelSimple = (TestUseSpelInjection)context.getBean("testUseSpelInjection");
        System.out.println(spelSimple.toString());
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setProgrammer(boolean programmer) {
        this.programmer = programmer;
    }

    public void setAgeInSeconds(Long ageInSeconds) {
        this.ageInSeconds = ageInSeconds;
    }
}
