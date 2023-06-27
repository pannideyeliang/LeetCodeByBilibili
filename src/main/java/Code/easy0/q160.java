package Code.easy0;

public class q160 {
    //    160. 相交链表
    public static void main(String[] args) {

    }
}

class Solution160 {
    //    首先，链表问题，也是可以用递归的方式解决的
//    下面方法虽然通过了，但是时间复杂度和空间复杂度都极低，跟狗屎一样
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        if (headA == headB) {
            return headA;
        }
        ListNode temp = headB;
        while (temp != null) {
            if (temp == headA) return temp;
            temp = temp.next;
        }
        return getIntersectionNode(headA.next, headB);
    }

    //    下面查看大佬写的代码
//    其实我们只需要从长度差开始遍历就好了，如果有的话，那末尾的长度一定是一样的
//    但是这是自己写的消除长度差的算法，非常的丑陋，遍历了很多次，而且有点问题
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int LenA = 0;
        int LenB = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null) {
            LenA++;
            tempA = tempA.next;
        }
        while (tempB != null) {
            LenB++;
            tempB = tempB.next;
        }
        int start = LenA > LenB ? LenA - LenB : LenB - LenA;

        tempA = headA;
        tempB = headB;
        while (start != 0) {
            tempA = tempA.next;
            tempB = tempB.next;
            start--;
        }
        while (tempA != null && tempB != null) {
            if (tempA == tempB) return tempA;
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;
    }

    //    下面是大佬写的消除长度差的算法
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
//            谁先走到头，谁就从另一个人的头开始
//            换句话说
//             4  +   3   +   2   公共的 3
//             2  +   3   +   4   公共的 3
//             走到最后要不就是都是null 要不就是公共前缀节点
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode() {

    }
}