package com.jicheng;

class PrimaryStudent extends Student {

    protected int grade;

    public  PrimaryStudent(String name,int age, int score, int grade){
           super(name, age, score);
       }

    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }

}
