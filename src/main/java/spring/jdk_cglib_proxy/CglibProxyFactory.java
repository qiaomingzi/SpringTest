package spring.jdk_cglib_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-8
 * Time: ����7:25
 * To change this template use File | Settings | File Templates.
 */
public class CglibProxyFactory implements MethodInterceptor {
    private Object targetObj;
    public Object newProxyInstance(Object targetObj) {
        this.targetObj = targetObj;
        //��enhancer���������������
        Enhancer enhancer = new Enhancer();
        //���ø���,��ΪĿ����
        enhancer.setSuperclass(this.targetObj.getClass());
        // cglib�����Ĵ��������ʵ���Ǽ̳���Ҫ�����Ŀ���࣬Ȼ���Ŀ���������з�final�������и��ǣ����ڸ��Ƿ���ʱ�����һЩ���ش��롣
        // ע��ص���,�ص�����intercept
        enhancer.setCallback(this);
        //���ش����Ĵ������
        return enhancer.create();
    }

    //�������δ���:���������,�����ص��ķ���,�����Ĳ���,�����Ĵ������
    //����,ָ�����Թ�ע��ĳ���,��������,�������ߵĹ�ע�㲻ͬ,���Ƕ����������ĳ���
    //���ӵ�:ָ��Щ�����ص��ĵ�,springֻ֧�ַ������͵����ӵ�
    //�����:ָ����Ҫ�����ӵ�������صĶ���
    //֪ͨ:���ص����ӵ���������鼴Ϊ֪ͨ
    //Target,Ŀ�����:�����Ŀ�����
    //֯��:��aspectJӦ�õ�target����,������proxy���󴴽��Ĺ���
    //����:�ڲ��޸������ǰ����,���������������Ϊ�ද̬�����һЩ��������field
    public Object intercept(Object proxy, Method method, Object[] args,
                            MethodProxy methodProxy) throws Throwable {//����֪ͨ
        Object result = null;
        // ǰ��֪ͨ advice()
        try {
            result = methodProxy.invoke(this.targetObj, args);
            // ����֪ͨ afterAdvice()
        } catch (Exception e) {
            e.printStackTrace();
            // ����֪ͨ exceptionAdvice
        } finally {
            // ����֪ͨ  finalyAdvice
        }
        return result;
    }

    public static void main(String[] args) {
        CglibProxyFactory factory = new CglibProxyFactory();
        UserMangerNoImpl userManger = (UserMangerNoImpl)factory.newProxyInstance(new UserMangerNoImpl());
        userManger.save();
    }
}
