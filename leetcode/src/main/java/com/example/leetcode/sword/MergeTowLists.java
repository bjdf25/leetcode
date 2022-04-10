package com.example.leetcode.sword;

import com.example.leetcode.common.ListNode;

/**
 * 合并两个有序链表
 */
public class MergeTowLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        cur.next = l1 == null ? l2 : l1;
        return res.next;
    }
}
