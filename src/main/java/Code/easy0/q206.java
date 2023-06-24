package Code.easy0;

public class q206 {
    //    206. 反转链表
    public static void main(String[] args) {

    }
}


class Solution {
    //    基本功的考察
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode newHead = new ListNode();
        ListNode temp = null;
        while (head != null) {
            temp = head;
            head = head.next;
            temp.next = newHead.next;
            newHead.next = temp;
        }
        return newHead.next;
    }
}