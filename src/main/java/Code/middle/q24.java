package Code.middle;

public class q24 {
    //    24. 两两交换链表中的节点
    public static void main(String[] args) {

    }
}


class Solution24 {

    //    直接递归做，比较简单
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        p.next = q.next;
        q.next = p;
        head = q;
        p.next = swapPairs(p.next);
        return head;
    }

    //    查看大佬代码
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

}
