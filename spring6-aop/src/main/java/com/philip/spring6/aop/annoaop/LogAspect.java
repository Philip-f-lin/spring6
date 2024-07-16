package com.philip.spring6.aop.annoaop;


import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

// 切面類
@Aspect // 切面類
@Component // 給IOC容器管理
public class LogAspect {

    // 設置切入點和通知類型
    // 切入點表達式：execution（訪問修飾符 增強方法返回類型 增強方法所在類全路徑.方法名稱（方法參數 ））
    // 通知類型：
    // 前置 @Before(value="切入點表達式配置切入點")
    @Before(value = "execution(public int com.philip.spring6.aop.annoaop.CalculatorImpl.*(..))")
    public void beforeMethod(){
        System.out.println("Logger --> 前置通知");
    }
    // 返回 @AfterReturning
    // 異常 @AfterThrowing
    // 後置 @After()
    // 環繞 @Around()


}
