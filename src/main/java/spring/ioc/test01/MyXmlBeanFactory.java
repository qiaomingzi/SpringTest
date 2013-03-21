package spring.ioc.test01;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-12
 * Time: ÏÂÎç4:46
 * To change this template use File | Settings | File Templates.
 */
public class MyXmlBeanFactory extends DefaultListableBeanFactory {
    private final XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(this);

    public MyXmlBeanFactory(Resource resource) throws BeansException {
        this(resource, null);
    }

    public MyXmlBeanFactory(Resource resource, BeanFactory parentBeanFactory) throws BeansException {
        super(parentBeanFactory);
        System.out.println(XmlBeanDefinitionReader.VALIDATION_XSD);
        System.out.println("The parentBeanFactory of XmlFileInputStreamBeanFactory is: " + parentBeanFactory);
        this.reader.setValidationMode(XmlBeanDefinitionReader.VALIDATION_XSD);
        this.reader.loadBeanDefinitions(resource);
    }
}
