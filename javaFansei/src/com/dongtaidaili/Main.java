package com.dongtaidaili;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//动态代码，我们仍然先定义了接口Hello，但是我们并不去编写实现类，
// 而是直接通过JDK提供的一个Proxy.newProxyInstance()创建了一个Hello接口对象。
// 这种没有实现类但是在运行期动态创建了一个接口对象的方式，我们称为动态代码。
// JDK提供的动态创建接口对象的方式，就叫动态代理
public class Main {
    public static void main(String[] args) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("morning")) {
                    System.out.println("Good morning, " + args[0]);
                }
                return null;
            }
        };
        Hello hello = (Hello) Proxy.newProxyInstance(
            Hello.class.getClassLoader(), // 传入ClassLoader
            new Class[] { Hello.class }, // 传入要实现的接口
            handler); // 传入处理调用方法的InvocationHandler
        hello.morning("Bob");
    }
}
