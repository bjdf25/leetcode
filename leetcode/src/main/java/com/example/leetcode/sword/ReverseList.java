package sword;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        return recur(head, null);
        // ListNode cur = head;
        // ListNode pre = null;
        // while (cur != null) {
        //     ListNode temp = cur.next;
        //     cur.next = pre;
        //     pre = cur;
        //     cur = temp;
        // }
        // return pre;

    }
    ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) return pre;
        ListNode lastNode = recur(cur.next, cur);
        cur.next = pre; // 回溯过程反转链表
        return lastNode; // 始终返回的是尾节点
    }
}
