package com.philip.spring6.aop.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {

    // 目標對象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 返回代理對象
    public Object getTarget(){
        /**
         * Proxy.newProxyInstance()：建立一個代理實例
         * newProxyInstance()有三個參數：
         * 1、classLoader：載入動態產生的代理類別的類別載入器
         * 2、interfaces：目標物件實現的所有介面的class物件所組成的陣列
         * 3、invocationHandler：設定代理物件實作目標物件方法的過程，也就是代理類別中如何重寫介面中的抽象方法
         */

        // 1、classLoader：載入動態產生的代理類別的類別載入器
        ClassLoader classLoader = target.getClass().getClassLoader();
        // 2、interfaces：目標物件實現的所有介面的class物件所組成的陣列
        Class<?>[] interfaces = target.getClass().getInterfaces();
        // 3、invocationHandler：設定代理物件實作目標物件方法的過程，也就是代理類別中如何重寫介面中的抽象方法
        InvocationHandler invocationHandler = new InvocationHandler() {
            /**
             * proxy：代理對象
             * method：代理物件需要實現的方法，即其中需要重寫的方法
             * args：method所對應方法的參數
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 調用方法之前輸出
                System.out.println("[動態代理][日誌] "+method.getName()+"，參數："+ Arrays.toString(args));
                // 調用目標的方法
                Object result = method.invoke(target, args);
                // 調用方法之後輸出
                System.out.println("[動態代理][日誌] "+method.getName()+"，結果："+ result);
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
