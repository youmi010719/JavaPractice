package com.fangwenziduan;
import java.lang.reflect.Field;
//https://www.liaoxuefeng.com/wiki/1252599548343744/1264803033837024
//我们先看看如何通过Class实例获取字段信息。Class类提供了以下几个方法来获取字段：

//Field getField(name)：根据字段名获取某个public的field（包括父类）
//Field getDeclaredField(name)：根据字段名获取当前类的某个field（不包括父类）
//Field[] getFields()：获取所有public的field（包括父类）
//Field[] getDeclaredFields()：获取当前类的所有field（不包括父类）

//通过Field实例既然可以获取到指定实例的字段值，自然也可以设置字段的值。
public class Main {
    public static void main(String[] args) throws Exception {
        Class stdClass = Student.class;
        // 获取public字段"score":
        System.out.println(stdClass.getField("score"));
        // 获取继承的public字段"name":
        System.out.println(stdClass.getField("name"));
        // 获取private字段"grade":
        System.out.println(stdClass.getDeclaredField("grade"));
    }
}
