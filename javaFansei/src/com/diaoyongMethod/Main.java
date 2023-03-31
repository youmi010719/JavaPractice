package com.diaoyongMethod;


import java.lang.reflect.Method;

//https://www.liaoxuefeng.com/wiki/1252599548343744/1264803678201760
//可以通过Class实例获取所有Method信息。Class类提供了以下几个方法来获取Method：
//
//Method getMethod(name, Class...)：获取某个public的Method（包括父类）
//Method getDeclaredMethod(name, Class...)：获取当前类的某个Method（不包括父类）
//Method[] getMethods()：获取所有public的Method（包括父类）
//Method[] getDeclaredMethods()：获取当前类的所有Method（不包括父类）
public class Main {
    public static void main(String[] args) throws Exception {
        // String对象:
        String s = "Hello world";
        // 获取String substring(int)方法，参数为int:
        Method m = String.class.getMethod("substring", int.class);
        // 在s对象上调用该方法并获取结果:
        String r = (String) m.invoke(s, 6);
        // 打印调用结果:
        System.out.println(r);
    }
}

