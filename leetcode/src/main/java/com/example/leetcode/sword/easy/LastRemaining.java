package com.example.leetcode.sword.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 圆圈中最后剩下的数字(约瑟夫环问题)
 */
public class LastRemaining{
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while(list.size() > 1) {
            // -1是因为最开始从0开始算的第一个，后面移除一个数字后尾的数字会跟着跑到前面来
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
            /**
             * index = (index + m - 1) % list.size();
             * list.remove(index);
             */
        }
        return list.get(0);
    }
}
