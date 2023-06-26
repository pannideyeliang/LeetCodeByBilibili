package Code.easy0;

import java.util.Stack;

public class q234 {
    //    234. 回文链表
    public static void main(String[] args) {

    }
}


class Solution234 {
    //    快慢指针找中点，然后逆序比较
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return true;

        ListNode slow = head;
        ListNode quick = head.next;
        while (quick.next != null && slow.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
//       头插法逆转
        ListNode temp = new ListNode();
        slow = slow.next;
        while (slow != null) {
            ListNode temp2 = slow;
            slow = slow.next;
            temp2.next = temp.next;
            temp.next = temp2;
        }
        while (temp.next != null) {
            if (temp.next.val != head.val) {
                return false;
            }
            temp = temp.next;
            head = head.next;
        }

        return true;
    }

    //    快慢指针找中点，但是不逆序，而是使用栈作为工具
    public boolean isPalindrome1(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return true;

        ListNode slow = head;
        ListNode quick = head.next;
        while (quick.next != null && slow.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        Stack<Integer> stack = new Stack<>();
        slow = slow.next;
        while (slow != null) {
            stack.add(slow.val);
            slow = slow.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}