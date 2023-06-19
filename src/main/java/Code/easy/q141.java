package Code.easy;

public class q141 {
    //    141. 环形链表   实际上是一个追及问题，可以采用双指针，快慢指针
    public static void main(String[] args) {

    }
}

class Solution141 {
    //    实际上是一个追及问题，可以采用双指针，快慢指针

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        if (head.next == head) return true;

        ListNode p = head, q = head.next;
        while (p.next != null && q.next != null && q.next.next != null) {
            if (p == q) return true;
            p = p.next;
            q = q.next.next;
        }
        return false;
    }
}