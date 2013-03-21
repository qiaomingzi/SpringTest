package spring.lifecycle;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*@ContextConfiguration(locations = "classpath:lifecycle.xml")*/
public class TestLifeCycle {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Test
    public void test_01(){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"lifecycle.xml"},TestLifeCycle.class);
        MyFactoryBean bean1 = (MyFactoryBean)context.getBean("factoryBean");
        log.debug(bean1.getMessage("MST_1"));

        MyFactoryBean bean2 = (MyFactoryBean)context.getBean("factoryBean");
        log.debug(bean2.getMessage("MST_2"));
        ((AbstractApplicationContext)context).registerShutdownHook();
    }
}
