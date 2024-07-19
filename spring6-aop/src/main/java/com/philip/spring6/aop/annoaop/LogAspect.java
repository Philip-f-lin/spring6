package com.philip.spring6.aop.annoaop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// 切面類
@Aspect // 切面類
@Component // 給IOC容器管理
public class LogAspect {

    // 設置切入點和通知類型
    // 通知類型：
    // 前置 @Before(value="切入點表達式配置切入點")
    // 切入點表達式：execution（訪問修飾符 增強方法返回類型 增強方法所在類全路徑.方法名稱（方法參數 ））
    @Before(value = "execution(public int com.philip.spring6.aop.annoaop.CalculatorImpl.*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        String MethodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger --> 前置通知" + "，方法名：" + MethodName + "參數：" + Arrays.toString(args));
    }
    // 後置 @After()
    @After(value = "execution(* com.philip.spring6.aop.annoaop.CalculatorImpl.add(..))")
    public void AfterMethod(JoinPoint joinPoint){
        String MethodName = joinPoint.getSignature().getName();
        System.out.println("Logger --> 後置通知" + "，方法名：" + MethodName);
    }

    // 返回 @AfterReturning
    @AfterReturning(value = "execution(* com.philip.spring6.aop.annoaop.CalculatorImpl.*(..))", returning = "result")
    public void AfterReturningMethod(JoinPoint joinPoint, Object result){
        String MethodName = joinPoint.getSignature().getName();
        System.out.println("Logger --> 返回通知" + "，方法名：" + MethodName + "，返回結果：" + result);
    }
    // 異常 @AfterThrowing 獲取到目標方法異常訊息
    // 目標方法出現異常，這個通知執行
    @AfterThrowing(value = "execution(* com.philip.spring6.aop.annoaop.CalculatorImpl.*(..))", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex){
        String MethodName = joinPoint.getSignature().getName();
        System.out.println("Logger --> 異常通知" + "，方法名：" + MethodName + "，異常訊息：" + ex);
    }


    // 環繞 @Around()
    @Around(value = "execution(* com.philip.spring6.aop.annoaop.CalculatorImpl.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint){
        String MethodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String argString = Arrays.toString(args);
        Object result = null;
        try{
            System.out.println("環繞通知 == 目標方法之前執行");

            // 調用目標方法
            result = joinPoint.proceed();

            System.out.println("環繞通知 == 目標方法返回值之後");
        }catch (Throwable throwable){
            throwable.printStackTrace();
            System.out.println("環繞通知 == 目標方法出現異常執行");
        }finally {
            System.out.println("環繞通知 == 目標方法執行完畢");
        }
        return result;
    }


}
