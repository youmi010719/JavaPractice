package com.Interface;
//如果一个抽象类没有字段，所有方法全部都是抽象方法，他就是一个接口
//在Java中，一个类只能继承自另一个类，不能从多个类继承。但是，一个类可以实现多个interface
//一个interface可以继承自另一个interface。interface继承自interface使用extends，它相当于扩展了接口的方法
interface Person {
    String getName();
    default void run() {
        System.out.println(getName() + " run");
    }
}
