package com.example.leetcode.hot100.easy;

import com.example.leetcode.common.ListNode;

import java.util.List;

/**
 * 回文链表
 */
public class HuiWenLianBiao {
    ListNode node;
    public boolean isPalindromeByRecur(ListNode head) {
        this.node = head;
        return recur(head);
    }

    public boolean recur(ListNode head) {
        if (head != null) {
            if (!recur(head.next)) {
                // 为false直接剪枝
                return false;
            }
            if (head.val != node.val) {
                return false;
            }
            node = node.next;
        }
        // head为null时为true保证递归到最后一个节点时为true
        return true;
    }

    // 通过快慢指针找到中间节点，把中间节点以后的链表反转进行比较
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode mid = findMid(head);
        ListNode last = reverseList(mid.next);
        ListNode headNode = head;
        ListNode lastNode = last;
        while (lastNode != null) {
            if (headNode.val != lastNode.val) {
                // 还原链表
                reverseList(last);
                return false;
            }
            headNode = headNode.next;
            lastNode = lastNode.next;
        }
        reverseList(last);
        return true;
    }

    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
