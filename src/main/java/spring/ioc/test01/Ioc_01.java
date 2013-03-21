package spring.ioc.test01;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;


/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-12
 * Time: 下午3:48
 * To change this template use File | Settings | File Templates.
 */
public class Ioc_01 {
    private static final Log log = LogFactory.getLog(Ioc_01.class);
    @Test
    public void iocWithodFile(){
        /*
        * 利用注解方式取得Bean
        *
        * 无配置文件调用
        * */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SummaryAnnotationClass.class);
        Summary summary = (Summary)context.getBean("getGameSummary");
        log.debug(summary.toString());
   }

    @Test
    public void iocWithFile(){
        /**
         * 利用配置文件加载
         */
        Resource resource = new InputStreamResource(this.getClass().getResourceAsStream("/spring/ioc/summaryIoc.xml"));
        BeanFactory factory = new MyXmlBeanFactory(resource);
        Summary summary = (Summary)factory.getBean("summary");
        log.debug(summary.toString());
    }
    @Test
    public void iocLoadFile(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //PropertiesBeanDefinitionReader prd = new PropertiesBeanDefinitionReader(factory);
        XmlBeanDefinitionReader rd = new XmlBeanDefinitionReader(factory);
        //rd.loadBeanDefinitions(new FileSystemResource("E:\\ideaWorkspace\\apexsoft\\SpringTest\\src\\main\\java\\spring\\ioc\\summaryIoc.xml"));
        rd.loadBeanDefinitions(new FileSystemResource("spring/ioc/summaryIoc.xml"));
        Summary summary = (Summary)factory.getBean("summary");
        log.debug(summary.toString());
    }
}
