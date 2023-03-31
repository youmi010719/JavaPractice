package com.jichu.fanfa;
//Student 继承了Person的有关变量和方法，只是在构造函数上有一些特殊的讲究
public final class Student extends  Person{

    private  int score;

    public Student() {
        super();
    }
    @Override//覆写方法，一个子类定义的一个与父类相同的方法(签名相同，返回值相同)，就要用覆写
    public  void run(){
        System.out.println("Student.run");
    }
    public int gteScore(){
       return this.score;
    };
    public  void setScore(int score){
        this.score = score;
    };
    public Student(String name, int age, int score) {
        super(name, age);//任何构造方法，第一句都是调用父类的构造函数，如果没有明确的调用构造函数，系统会自动帮我们加一句，
        this.score = score;
    }
}

