package com.Equals;

import java.util.Objects;

class Person {
    String firstName;
    String lastName;
    int age;
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    //编写一个Person类的equals方法
    //我们总结一下equals()方法的正确编写方法：
    //
    //先确定实例“相等”的逻辑，即哪些字段相等，就认为实例相等；
    //用instanceof判断传入的待比较的Object是不是当前类型，如果是，继续比较，否则，返回false；
    //对引用类型用Objects.equals()比较，对基本类型直接用==比较。
    public boolean equals(Object o) {
    if (o instanceof Person p) {
        return Objects.equals(this.firstName, p.firstName) &&Objects.equals(this.lastName,p.lastName)&& this.age == p.age;
    }
    return false;
}
}
