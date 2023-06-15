package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈佳乐
 * @create 2023-06-15-22:24
 */
public class q141 {
    //    141. 环形链表
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        boolean b = new Solution141().hasCycle1(l1);
        System.out.println(b);
    }
}

class Solution141 {
    //    链表中节点的数目范围是 [0, 10^4] 投机取巧，利用题目给限定的范围
//    但是投机取巧的结果是超时
    public boolean hasCycle(ListNode head) {
        if (head == null) return true;
        int wc = 0;
        while (head.next != null) {
            head = head.next;
            wc++;
        }
        if (wc <= 10000) {
            return true;
        }
        return false;
    }

    //    正确的笨蛋方法如下：
//    我们可以采用List去存已有的
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) return false;
        ArrayList<ListNode> room = new ArrayList<ListNode>();
        ListNode temp = head;
        head = head.next;
        room.add(temp);
        temp.next = null;
        while (true) {
            if (head == null) return true;
            temp = head;
            head = head.next;
            temp.next = null;
            if (room.contains(temp)) {
                return true;
            } else {
                room.add(temp);
            }
        }
    }
}