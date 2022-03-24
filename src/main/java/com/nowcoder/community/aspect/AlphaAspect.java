package com.nowcoder.community.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * AOP示例
 * @author hpr
 * @date 2022-03-24 10:25
 */
//@Component
//@Aspect
public class AlphaAspect {

    /**
     * 切入点表达式作用：知道对哪个类里面的哪个方法进行增强
     * 语法结构： execution([权限修饰符] [返回类型] [类全路径] [方法名称]([参数列表])) [权限修饰符]一般省略
     */
    @Pointcut("execution(* com.nowcoder.community.service.*.*(..))")
    public void pointcut() {

    }

    @Before("pointcut()")  // 以此为切点 在其之前
    public void before() {
        System.out.println("before");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("after");
    }

    @AfterReturning("pointcut()")
    public void afterRetuning() {
        System.out.println("afterRetuning");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }

    @Around("pointcut()") // 这个要有返回值
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around before");
        // joinPoint.proceed()是调目标对象（原始对象）的方法
        Object obj = joinPoint.proceed();
        System.out.println("around after");
        return obj;
    }

}
