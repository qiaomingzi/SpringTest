package spring.jdk_cglib_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-8
 * Time: 下午7:25
 * To change this template use File | Settings | File Templates.
 */
public class CglibProxyFactory implements MethodInterceptor {
    private Object targetObj;
    public Object newProxyInstance(Object targetObj) {
        this.targetObj = targetObj;
        //用enhancer类来创建代理对象
        Enhancer enhancer = new Enhancer();
        //设置父类,即为目标类
        enhancer.setSuperclass(this.targetObj.getClass());
        // cglib创建的代理对象，其实就是继承了要代理的目标类，然后对目标类中所有非final方法进行覆盖，但在覆盖方法时会添加一些拦截代码。
        // 注册回调器,回调下面intercept
        enhancer.setCallback(this);
        //返回创建的代理对象
        return enhancer.create();
    }

    //参数依次代表:代理对象本身,被拦截到的方法,方法的参数,方法的代理对象
    //切面,指横切性关注点的抽象,与类相似,但是两者的关注点不同,类是对物体特征的抽象
    //连接点:指那些被拦截到的点,spring只支持方法类型的连接点
    //切入点:指我们要对连接点进行拦截的定义
    //通知:拦截到连接点后做的事情即为通知
    //Target,目标对象:代理的目标对象
    //织入:将aspectJ应用到target对象,并导致proxy对象创建的过程
    //引入:在不修改类代码前提下,引入可以在运行期为类动态地添加一些方法或者field
    public Object intercept(Object proxy, Method method, Object[] args,
                            MethodProxy methodProxy) throws Throwable {//环绕通知
        Object result = null;
        // 前置通知 advice()
        try {
            result = methodProxy.invoke(this.targetObj, args);
            // 后置通知 afterAdvice()
        } catch (Exception e) {
            e.printStackTrace();
            // 例外通知 exceptionAdvice
        } finally {
            // 最终通知  finalyAdvice
        }
        return result;
    }

    public static void main(String[] args) {
        CglibProxyFactory factory = new CglibProxyFactory();
        UserMangerNoImpl userManger = (UserMangerNoImpl)factory.newProxyInstance(new UserMangerNoImpl());
        userManger.save();
    }
}
