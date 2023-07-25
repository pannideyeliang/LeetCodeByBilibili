package Code.easy2;

public class q496 {
    //    496. 下一个更大元素 I
    public static void main(String[] args) {
        int[] n1 = {4, 1, 2};
        int[] n2 = {1, 3, 4, 2};
        int[] ints = new Solution496().nextGreaterElement(n1, n2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}


class Solution496 {
    //    标准的模拟
//    但是是直接去nums2中找的，所以可以直接在nums打表
//    算了，最垃圾的方法吧
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int index = 0;
        for (int i : nums1) {
            int s = 0;
            while (s < nums2.length && nums2[s] != i) {
                s++;
            }
            while (s < nums2.length && nums2[s] <= i) {
                s++;
            }
            if (s == nums2.length) {
                res[index++] = -1;
            } else {
                res[index++] = nums2[s];
            }
        }
        return res;
    }

    //    大佬代码，实际上是一个单调栈的问题
//    单调栈用途不太广泛，只处理一种典型的问题，叫做 Next Greater Element
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        return null;
    }
}
