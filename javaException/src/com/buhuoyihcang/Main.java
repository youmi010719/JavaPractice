package com.buhuoyihcang;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

//在Java中，凡是可能抛出异常的语句，都可以用try ...
// catch捕获。把可能发生异常的语句放在try { ... }中，然后使用catch捕获对应的Exception及其子类。
//
//多catch语句
//可以使用多个catch语句，每个catch分别捕获对应的Exception及其子类。
// JVM在捕获到异常后，会从上到下匹配catch语句，匹配到某个catch后，执行catch代码块，然后不再继续匹配
//存在多个catch是，catch的顺序很重要，子类必须写在前面
//Java的try ... catch机制还提供了finally语句，finally语句块保证有无错误都会执行
/*public class Main {
    public static void main(String[] args) {
        try {
            process1();
            process2();
            process3();
        } catch (UnsupportedEncodingException e) {
            System.out.println("Bad encoding");
        } catch (IOException e) {
            System.out.println("IO error");
        } finally {
            System.out.println("END");
        }
    }
}*/
