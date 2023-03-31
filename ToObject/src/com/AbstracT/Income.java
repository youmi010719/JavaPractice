package com.AbstracT;
//抽象类就是把一个类只作为子类继承的对象、覆写的
abstract class Income {
    protected double income;

    public Income(double income) {
        this.income = income;
    }

    public  abstract double getTax() ;
}