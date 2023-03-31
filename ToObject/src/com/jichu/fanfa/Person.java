package com.jichu.fanfa;
//阻止继承的方法,利用sealed 和permits修饰

//还有一种面向抽象编程，就是把父类作为一个抽象类，我们在对抽象类进行方法调用时，可以不用关注其子类的类型，
public sealed class Person permits Student, Teacher {
    protected    String name;//protected修饰的变量，在子类中是可以访问的，但是private修饰的就不行
    private  int age = 10;

    //一个构造函数，没有这个构造函数，系统会自动创建一个构造函数
    public Person(String name ,int age){
        this.name = name;
        this.age = age;
    }

    public Person() {

    }
    public  void run(){
        System.out.println("Person.run");
    }
    public String getName(){
        return this.name;
    }
    public  void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        if(age > 100 || age < 0){
            throw new IllegalArgumentException("age value is not right");
        }
        this.age = age;
    }

    //方法重载的有关细节
    public void hello(){
        System.out.println("hello world !");
    }
    public void hello(String name){
        System.out.println("hello," + name +"!");
    }
    public void hello(String name, int age){
        if(age <18){
            System.out.println("hi" +name +"!");
        }
        else{
            System.out.println(("hello" + name +"!"));
        }
    }
    /*public  static void main(String[] args){
        Person ming = new Person();
        ming.name ="xiaoming";
        ming.age = 12;
        System.out.println(ming.age);
    }*/
}
