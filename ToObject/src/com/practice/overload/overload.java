package com.practice.overload;

class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setName(String name1,String name2){
        this.name = name1+" "+name2;
    }
}