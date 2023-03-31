package com.Equals;
//一般的类如果没有编写equals方法，其构成的list集合无法直接使用list.contains()方法。

import java.util.List;
import java.util.Objects;

//如何正确编写equals()方法？equals()方法要求我们必须满足以下条件：
//
//自反性（Reflexive）：对于非null的x来说，x.equals(x)必须返回true；
//对称性（Symmetric）：对于非null的x和y来说，如果x.equals(y)为true，则y.equals(x)也必须为true；
//传递性（Transitive）：对于非null的x、y和z来说，如果x.equals(y)为true，y.equals(z)也为true，那么x.equals(z)也必须为true；
//一致性（Consistent）：对于非null的x和y来说，只要x和y状态不变，则x.equals(y)总是一致地返回true或者false；
//对null的比较：即x.equals(null)永远返回false
public class Main {
    public static void main(String[] args) {
        List<Person> list = List.of(
            new Person("Xiao", "Ming", 18),
            new Person("Xiao", "Hong", 25),
            new Person("Bob", "Smith", 20)
        );
        boolean exist = list.contains(new Person("Bob", "Smith", 20));
        System.out.println(exist ? "测试成功!" : "测试失败!");
    }
}
