package spring.ioc.set_injection;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-17
 * Time: 下午3:11
 * To change this template use File | Settings | File Templates.
 */
public class TestIocBean {
    @Test
    public void test01(){
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(TestIocBean.class,new String[]{"app-context-xml.xml"});
        context.refresh();

        MessageProvider messageProvider = context.getBean("messageProvider",MessageProvider.class);
        System.out.println(messageProvider.getMessage());

        MessageRender messageRender = context.getBean("messageRender",MessageRender.class);
        messageRender.render();
    }

    @Test
    public void test02(){
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        //context.load("classpath:app-context-annotation.xml");
        context.load(TestIocBean.class,"app-context-xml.xml");
        context.refresh();

        MessageProvider messageProvider = context.getBean("messageProvider",MessageProvider.class);
        System.out.println(messageProvider.getMessage());

        MessageRender messageRender = context.getBean("messageRender",MessageRender.class);
        messageRender.render();
    }
}
