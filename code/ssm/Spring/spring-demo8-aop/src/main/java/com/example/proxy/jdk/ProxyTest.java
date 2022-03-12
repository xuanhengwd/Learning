package com.example.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {

        //创建目标对象
        Target target = new Target();
        //增强对象
        Adivce adivce = new Adivce();
        //返回值是动态代理对象 代理的是接口
        TargetInterface proxy= (TargetInterface) Proxy.newProxyInstance(
                //目标对象类加载器
                target.getClass().getClassLoader(),
                //目标对象相同接口字节码对象数组
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    //调用代理对象的任何方法，实质执行的都是invoke方法
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //前置增强
                        adivce.before();
                        //执行目标方法
                        Object invoke = method.invoke(target, args);
                        //后置增强
                        adivce.after();
                        return invoke;
                    }
                }
        );


        //调用代理对象的方法
        proxy.save();
    }
}
