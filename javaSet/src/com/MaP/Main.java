package com.MaP;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


//https://www.liaoxuefeng.com/wiki/1252599548343744/1265118019954528
//使用List来实现存在效率非常低的问题，因为平均需要扫描一半的元素才能确定，
//而Map这种键值（key-value）映射表的数据结构，作用就是能高效通过key快速查找value（元素
/*public class Main {
    public static void main(String[] args) {
        Student s = new Student("Xiao Ming", 99);
        Map<String, Student> map = new HashMap<>();
        map.put("Xiao Ming", s); // 将"Xiao Ming"和Student实例映射并关联
        Student target = map.get("Xiao Ming"); // 通过key查找并返回映射的Student实例
        System.out.println(target == s); // true，同一个实例
        System.out.println(target.score); // 99
        Student another = map.get("Bob"); // 通过另一个key查找
        System.out.println(another); // 未找到返回null
    }
}*/
//通过上述代码可知：Map<K, V>是一种键-值映射表，
// 当我们调用put(K key, V value)方法时，就把key和value做了映射并放入Map。
// 当我们调用V get(K key)时，就可以通过key获取到对应的value。
// 如果key不存在，则返回null。和List类似，Map也是一个接口，最常用的实现类是HashMap。
//
//如果只是想查询某个key是否存在，可以调用boolean containsKey(K key)方法。
public class Main {
    public static void main(String[] args) {
        List<Student> list = List.of(
            new Student("Bob", 78),
            new Student("Alice", 85),
            new Student("Brush", 66),
            new Student("Newton", 99));
        var holder = new Students(list);
        System.out.println(holder.getScore("Bob") == 78 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Alice") == 85 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Tom") == -1 ? "测试成功!" : "测试失败!");
    }
}

