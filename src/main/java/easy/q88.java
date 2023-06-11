package easy;

import java.util.Arrays;

public class q88 {
    //    88. 合并两个有序数组
//    值得二刷，真的牛逼
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        new Solution88().merge1(nums1, 3, nums2, 3);
    }
}

class Solution88 {

    //    方法1：调用api , 当然你也可以合并两个数组后，自己写一个排序算法
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }

    //    实际上是一个插入排序
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            int p = m - 1;
            if (nums2[i] > nums1[p]) {
                nums1[p + 1] = nums2[i];
                m++;
                continue;
            }

            while (p >= 0 && nums2[i] < nums1[p]) {
                nums1[p + 1] = nums1[p];
                p--;
            }
            nums1[p + 1] = nums2[i];
            m++;
        }
    }

    //  参考大佬们写的代码
//    实际上的思想是从大到小进行排序，
//    两个数组中现存的最大位进行比较，谁比较大，谁就往nums1的最后面去占位子
//    **********************  666
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length;
        while (n > 0) {
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[i - 1] = nums1[m - 1];
                i--;
                m--;
            } else {
                nums1[i - 1] = nums2[n - 1];
                i--;
                n--;
            }
        }
    }

}