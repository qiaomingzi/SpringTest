package spring.ioc.constructor_injection;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import spring.ioc.set_injection.MessageProvider;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-17
 * Time: ÏÂÎç3:11
 * To change this template use File | Settings | File Templates.
 */
public class TestIocBean {
    @Test
    public void test01(){
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(TestIocBean.class,new String[]{"injection-xml.xml"});
        context.refresh();

        MessageProvider messageProvider = context.getBean("messageProvider",MessageProvider.class);
        System.out.println(messageProvider.getMessage());

        MessageRender messageRender = context.getBean("messageRender",MessageRender.class);
        messageRender.render();
    }

    @Test
    public void test02(){
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(TestIocBean.class,"injection-annotation.xml");
        context.refresh();

        MessageRender messageRender = context.getBean("messageRender",StandardOutMessageRender.class);
        messageRender.render();
    }
}
