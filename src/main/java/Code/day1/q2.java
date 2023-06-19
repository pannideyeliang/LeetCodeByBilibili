package Code.day1;

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
        new Solution2().addTwoNumbers(l1, l2);
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
            val = (l1.val + l2.val + count) % 10;
            q.next = new ListNode(val);
            q = q.next;
            count = (l1.val + l2.val + count) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 == null && count == 0) {
            return head.next;
        }
        if (l1 == null && l2 == null && count != 0) {
            q.next = new ListNode(count);
            return head.next;
        }
        while (l2 != null) {
            val = (l2.val + count) % 10;
            count = (l2.val + count) / 10;
            q.next = new ListNode(val);
            q = q.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            val = (l1.val + count) % 10;
            count = (l1.val + count) / 10;
            q.next = new ListNode(val);
            q = q.next;
            l1 = l1.next;
        }
        if (count != 0) {
            q.next = new ListNode(count);
            return head.next;
        }
        return head.next;
    }

    //    采用另外一种方式，当其中一个列表为null的时候，把他的数值补为0，使得两个链表的长度一直保持一致的状态。
    public ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode q = head;
        int count = 0;
        int val;
        int x1 = 0;
        int x2 = 0;
        while (l1 != null || l2 != null) {
//            对于链表长度不一致的情况，都可以采用补0的方式解决
            x1 = l1 == null ? 0 : l1.val;
            x2 = l2 == null ? 0 : l2.val;
            val = (x1 + x2 + count) % 10;
            q.next = new ListNode(val);
            count = (x1 + x2 + count) / 10;
            q = q.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (count != 0) {
            q.next = new ListNode(count);
        }
        return head.next;
    }

    //    采用递归的方式进行解决，大部分链表方面的题目都可以使用递归的方式进行解决
    public ListNode addTwoNumbersV3(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    //    递归结构
    private ListNode add(ListNode l1, ListNode l2, int count) {
//        递归的结束条件
        if (l1 == null && l2 == null && count == 0) {
            return null;
        }
        int val = count;
        if (l1 != null) {
            val += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            val += l2.val;
            l2 = l2.next;
        }
        ListNode node = new ListNode(val % 10);
        node.next = add(l1, l2, val / 10);
        return node;
    }
}
