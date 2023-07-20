package Code.easy1;

import java.util.ArrayList;
import java.util.HashSet;

public class q349 {
    //    349. 两个数组的交集
    public static void main(String[] args) {

    }
}


class Solution349 {
    //    取交集
//    以下肯定能行的狗屎代码
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }
        for (int i : nums1) {
            if (set2.contains(i)) {
                set1.add(i);
            }
        }
        int[] resNum = new int[set1.size()];
        int count = 0;
        for (int i : set1) {
            resNum[count++] = i;
        }
        return resNum;
    }
}
