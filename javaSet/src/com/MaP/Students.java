package com.MaP;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Students {
    List<Student> list;
    Map<String, Integer> cache;

    Students(List<Student> list) {
        this.list = list;
        cache = new HashMap<>();
    }

    /**
     * 根据name查找score，找到返回score，未找到返回-1
     */
    int getScore(String name) {
        // 先在Map中查找:
        Integer score = this.cache.get(name);
        if (score == null) {
            score = findInList(name);
            if(score != null) {
                // 存在，缓存到MAP，下次查找则直接查询MAP
                this.cache.put(name, score);
            }else {
                System.out.println("学生名：%s, 系统中不存在!".formatted(name));
            }
        }
        return score == null ? -1 : score.intValue();
    }

    Integer findInList(String name) {
        for (var ss : this.list) {
            if (ss.name.equals(name)) {
                return ss.score;
            }
        }
        return null;
    }
}
