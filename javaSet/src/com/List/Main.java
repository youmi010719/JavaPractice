package com.List;
//List的行为和数组几乎完全相同：
// List内部按照放入元素的先后顺序存放，每个元素都可以通过索引确定自己的位置，List的索引和数组一样，从0开始
//https://www.liaoxuefeng.com/wiki/1252599548343744/1265112034799552
//我们考察List<E>接口，可以看到几个主要的接口方法：
//
//在末尾添加一个元素：boolean add(E e)
//在指定索引添加一个元素：boolean add(int index, E e)
//删除指定索引的元素：E remove(int index)
//删除某个元素：boolean remove(Object e)
//获取指定索引的元素：E get(int index)
//获取链表大小（包含元素的个数）：int size()

//实现List接口并非只能通过数组（即ArrayList的实现方式）来实现，
// 另一种LinkedList通过“链表”也实现了List接口。在LinkedList中，它的内部每个元素都指向下一个元素：

//Java的for each循环本身就可以帮我们使用Iterator遍历

//List 和 Array互换
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 构造从start到end的序列：
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        // 随机删除List中的一个元素:
        int removed = list.remove((int) (Math.random() * list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");
    }

    static int findMissingNumber(int start, int end, List<Integer> list) {
        for (int i = start; i <= end; i++) {
            if (!list.contains(i)) {
                return i;
            }
        }
        return 0;}
}
