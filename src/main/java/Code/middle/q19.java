package Code.middle;


public class q19 {
    //    19. 删除链表的倒数第 N 个结点
    public static void main(String[] args) {

    }
}

class Solution19 {
    //    典型的快慢指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < n; i++) {
            q = q.next;
        }

        while (q != null && q.next != null) {
            q = q.next;
            p = p.next;
        }
        if (q == null) {
            return p.next;
        }
        p.next = p.next.next;
        return head;
    }
}


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