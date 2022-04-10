package com.example.leetcode.sword;

public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cur = head;
        ListNode pre = cur;
        while(cur != null) {
            if(k > 0) {
                cur = cur.next;
                k--;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return pre;
    }

}
