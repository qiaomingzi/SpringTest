package spring.aop_Annotation;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-7
 * Time: 下午3:43
 * To change this template use File | Settings | File Templates.
 */

import org.aspectj.lang.annotation.*;
//
/**
 * UserManager 的却面类
 *   里包含了pointcut和advice
 *
 *   @Aspect用来标注切面类。
 *   @Pointcut标注一个空的方法，用来代表一个pointcut，这个方法必须是public的。
 *          @Pointcut注解括号内是pointcut expression，例子中的表达式表示com.psjay.example.spring.aop的所有方法都是join point。
 *   而@Before,@After等注解对应着几种不同类型的Advice。被标注的方法就是一个Advice。
 *   @Advice注解括号内是一个pointcut。
 *   例子中的
 *            @afterReturningAdvice()，
 *            @AfterAdviceWithArg()
 *           和afterThrowingAdvice()分别演示了Advice得到join point的返回值，Advice使用join point的参数，
 *           Advice使用join point抛出的异常对象几种操作
 */
@Aspect
public class UserManagerAscept {

    @Pointcut("execution(* spring.aop_Annotation.UserManagerService.*(..))")
    public void aPointcut() {
    }

    @Before("aPointcut()")
    public void beforeAdvice() {
        System.out.println("before advice is executed!");
    }

    @AfterReturning(pointcut = "aPointcut()", returning="r")
    public void afterReturningAdvice(String r) {
        if (r != null)
            System.out.println("after returning advice is executed! returning String is : " + r);
    }

    @After("aPointcut()")
    public void AfterAdvice() {
        System.out.println("after advice is executed!");
    }

    @After("aPointcut() && args(str)")
    public void AfterAdviceWithArg(String str) {
        System.out.println("after advice with arg is executed!arg is : " + str);
    }

    @AfterThrowing(pointcut="aPointcut()",throwing="e")
    public void afterThrowingAdvice(Exception e) {
        System.out.println("after throwing advice is executed!exception msg is : " + e.getMessage());
    }

}
