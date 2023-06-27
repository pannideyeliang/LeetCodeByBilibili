package Code.easy0;

import java.util.HashSet;
import java.util.Set;

public class q219 {
    //    219. 存在重复元素 II
    public static void main(String[] args) {

    }
}

class Solution219 {

    //    但是这种做法超出了时间限制
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0) return false;
        if (nums.length <= k) return containsDuplicate2(nums, 0, nums.length - 1);
//        无脑for循环 X   子问题划分 对
        for (int i = 0; i < nums.length - k; i++) {
            if (containsDuplicate2(nums, i, i + k)) {
                return true;
            }
        }
        return false;
    }

    //    借用217的代码
    public boolean containsDuplicate2(int[] nums, int left, int right) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = left; i <= right; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    //    滑动窗口
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
//        特殊情况特殊处理
        if (nums.length == 0) return false;
        Set<Integer> set = new HashSet<Integer>();
        int initSize = Math.min(nums.length, k);
        for (int i = 0; i < initSize; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        for (int i = initSize; i < nums.length; i++) {

            if (!set.add(nums[i])) {
                return true;
            }
            set.remove(nums[i-k]);
        }
        return false;
    }
}