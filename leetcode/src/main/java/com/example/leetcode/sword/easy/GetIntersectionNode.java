package com.example.leetcode.sword.easy;

import com.example.leetcode.common.ListNode;

/**
 * 两个链表的第一个公共节点
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        while(A != B) {
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
    }
}
