package spring.jdk_cglib_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-8
 * Time: ����7:00
 * To change this template use File | Settings | File Templates.
 */
public class JDKProxyFactory implements InvocationHandler {
    private Object targetObject;
    public Object createProxyInstance(Object targetObject){
        this.targetObject = targetObject;
        /*
        * ��һ���������ô���ʹ�õ���װ����,һ����ø�Ŀ������ͬ����װ����
        * �ڶ����������ô�����ʵ�ֵĽӿ�
        * �������������ûص�����,���������ķ���������ʱ,��ί�ɸ��ò���ָ�������invoke����
        */
        return Proxy.newProxyInstance(this.targetObject.getClass().getClassLoader(),
                this.targetObject.getClass().getInterfaces(),this);

    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       //todo
        Object result = null;
        //..... advice()-->ǰ��֪ͨ
        try {
            result = method.invoke(this.targetObject, args);
            // afteradvice() -->����֪ͨ
        } catch (RuntimeException e) {
            //exceptionadvice()--> ����֪ͨ
        } finally {
            //finallyadvice(); -->����֪ͨ
        }
        return result;
    }
    
    public static void main(String[] args) {
        JDKProxyFactory factory = new JDKProxyFactory();
        UserManager service = (UserManager)factory.createProxyInstance(new UserMangerImpl());
        service.save();
    }
}
