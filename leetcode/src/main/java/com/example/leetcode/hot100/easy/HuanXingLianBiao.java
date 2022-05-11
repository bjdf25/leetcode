package com.example.leetcode.hot100.easy;

import com.example.leetcode.common.ListNode;

/**
 * 环形链表
 */
public class HuanXingLianBiao {
    public boolean hasCycle(ListNode head) {
        // 龟兔赛跑法
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast) {
            if(fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
