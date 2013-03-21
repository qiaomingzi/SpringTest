package spring.jdk_cglib_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-8
 * Time: 下午7:00
 * To change this template use File | Settings | File Templates.
 */
public class JDKProxyFactory implements InvocationHandler {
    private Object targetObject;
    public Object createProxyInstance(Object targetObject){
        this.targetObject = targetObject;
        /*
        * 第一个参数设置代码使用的类装载器,一般采用跟目标类相同的类装载器
        * 第二个参数设置代理类实现的接口
        * 第三个参数设置回调对象,当代理对象的方法被调用时,会委派给该参数指定对象的invoke方法
        */
        return Proxy.newProxyInstance(this.targetObject.getClass().getClassLoader(),
                this.targetObject.getClass().getInterfaces(),this);

    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       //todo
        Object result = null;
        //..... advice()-->前置通知
        try {
            result = method.invoke(this.targetObject, args);
            // afteradvice() -->后置通知
        } catch (RuntimeException e) {
            //exceptionadvice()--> 例外通知
        } finally {
            //finallyadvice(); -->最终通知
        }
        return result;
    }
    
    public static void main(String[] args) {
        JDKProxyFactory factory = new JDKProxyFactory();
        UserManager service = (UserManager)factory.createProxyInstance(new UserMangerImpl());
        service.save();
    }
}
