package Code.easy;

public class q83 {
    //    83. 删除排序链表中的重复元素
    public static void main(String[] args) {

    }
}

class Solution83 {
    //    很简单的思想，我们可以使用双指针，一个记录当前一个遍历全部
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        ListNode q = head.next;
        while (q != null) {
            if (p.val != q.val) {
                p.next = q;
                p = p.next;
            }
            q = q.next;
        }
        p.next = null;
        return head;
    }

//    参考一波大神的写法
    public ListNode deleteDuplicates1(ListNode head){
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            if(cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}


