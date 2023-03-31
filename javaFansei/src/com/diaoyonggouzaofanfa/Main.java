package com.diaoyonggouzaofanfa;
//https://www.liaoxuefeng.com/wiki/1252599548343744/1264802263123712

import java.lang.reflect.Constructor;

//为了调用任意的构造方法，Java的反射API提供了Constructor对象，它包含一个构造方法的所有信息，
// 可以创建一个实例。Constructor对象和Method非常类似，不同之处仅在于它是一个构造方法，并且，调用结果总是返回实例

//通过Class实例获取Constructor的方法如下：
//
//getConstructor(Class...)：获取某个public的Constructor；
//getDeclaredConstructor(Class...)：获取某个Constructor；
//getConstructors()：获取所有public的Constructor；
//getDeclaredConstructors()：获取所有Constructor。
public class Main {
    public static void main(String[] args) throws Exception {
        // 获取构造方法Integer(int):
        Constructor cons1 = Integer.class.getConstructor(int.class);
        // 调用构造方法:
        Integer n1 = (Integer) cons1.newInstance(123);
        System.out.println(n1);

        // 获取构造方法Integer(String)
        Constructor cons2 = Integer.class.getConstructor(String.class);
        Integer n2 = (Integer) cons2.newInstance("456");
        System.out.println(n2);
    }
}
