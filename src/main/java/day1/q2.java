package day1;

/**
 * @author 陈佳乐
 * @create 2022-12-27-11:20
 */
public class q2 {
    //    两数相加，链表方式
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        new Solution2().addTwoNumbers(l1,l2);
    }
}


//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


class Solution2 {
    //    使用普通的迭代法
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode q = head;
        int count = 0;
        int val = 0;
        while (l1 != null && l2 != null) {
            val = (l1.val + l2.val) % 10;
            q.next = new ListNode(val + count);
            q = q.next;
            count = (l1.val + l2.val) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null) {
            q.next = new ListNode(l2.val + count);
            q.next.next = l2.next;
        }
        if (l2 == null) {
            q.next = new ListNode(l1.val + count);
            q.next.next = l1.next;
        }
        return head.next;
    }
}
