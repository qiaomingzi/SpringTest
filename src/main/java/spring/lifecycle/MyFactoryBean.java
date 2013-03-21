package spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-3-15
 * Time: 下午1:43
 * To change this template use File | Settings | File Templates.
 */
public class MyFactoryBean implements FactoryBean,BeanClassLoaderAware,DisposableBean,InitializingBean,BeanFactoryAware,ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Override
    public void destroy() throws Exception {
        System.out.println("FactoryBean is destory");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("FactoryBean is Initializing");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("set beanFactory");
    }
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("set applicationcontext");
        this.applicationContext = applicationContext;
    }

    @Override
    public Object getObject() throws Exception {
        System.out.println("get current factory obj");
        return new MyFactoryBean();
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("--setBeanClassLoader---");
    }

    @Override
    public Class<?> getObjectType() {
        return MyFactoryBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public String getMessage(String str){
         return "Hello "+str;
    }
}
