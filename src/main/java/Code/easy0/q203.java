package Code.easy0;


public class q203 {
    //    203. 移除链表元素
    public static void main(String[] args) {

    }
}


class Solution203 {

    //    自己写的狗屎一般方法
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    //    大佬写法：递归
    public ListNode removeElements1(ListNode head, int val) {
        if(head==null)
            return null;
        head.next=removeElements(head.next,val);
        if(head.val==val){
            return head.next;
        }else{
            return head;
        }
    }
}