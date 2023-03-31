package com.StatiC;

class Person {
    public String name;
    public int age;

    public static int number;
    public static  int count;

    public static int getCount (){
    return count;
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        count++;
    }
}
