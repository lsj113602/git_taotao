package com.taotao.search.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
//@Order(1)
@Aspect
//@Component
public class AspectjLog {
    private Logger logger = LoggerFactory.getLogger(AspectjLog.class);
    //此处定义一个通用的切点,以便下方4个通知使用* com.taotao.search.service.*.*(..)
    @Pointcut("execution(* com.taotao.search.service.*.*(..))")
    public void logAop() {
    }

    // 如果没有定义公用的切点或者需要单独指定其他切点,可以使用表达式指定
    // @Before("execution(* com.sam.aop.service.AspectService.*(..)) && args(email)")
    @Before("logAop() && args(email)")
    public void logBefore(JoinPoint joinPoint,String email) {

        System.out.println("前置通知Before>>{}"+email);
    }
    @AfterReturning("logAop() && args(email)")
    public void logAfterReturning(String email) {

        System.out.println("返回通知AfterReturning>>{}"+ email);
    }

    @After("logAop() && args(email)")
    public void logAfter(String email) {

        System.out.println("后置通知After>>{}"+ email);
    }
    @AfterThrowing("logAop() && args(email)")
    public void logAfterThrow(String email) {

        System.out.println("异常通知AfterThrowing>>{}"+email);
    }

    //环绕通知功能很强,可以替代上面的所有通知
    @Around("logAop() && args(email)")
    public void logAround(ProceedingJoinPoint jp, String email) {
        try {
            System.out.println("自定义前置通知Before>>>{}"+email);
            jp.proceed();//将控制权交给被通知的方法，也就是执行sayHello方法
            System.out.println("自定义返回通知AfterReturning>>>{}"+email);
        } catch (Throwable throwable) {
            System.out.println("异常处理>>>>{}"+ email);
            throwable.printStackTrace();
        }
        System.out.println("自定义后置通知After>>>{}"+email);
    }
}
