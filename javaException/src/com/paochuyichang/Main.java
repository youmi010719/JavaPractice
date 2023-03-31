package com.paochuyichang;
//当某个方法抛出了异常时，如果当前方法没有捕获异常，
// 异常就会被抛到上层调用方法，直到遇到某个try ... catch被捕获为止：
public class Main {
    public static void main(String[] args) {
        try {
            process1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void process1() {
        try {
            process2();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }

    static void process2() {
        throw new NullPointerException();
    }
}
