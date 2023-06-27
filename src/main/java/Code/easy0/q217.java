package Code.easy0;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class q217 {
    //    217. 存在重复元素
    public static void main(String[] args) {

    }
}


class Solution217 {

    //    简单思想，排序后比较
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    //  显然这个算法非常的垃圾，下面我们还是看一下大佬的代码，这种判断直接
//    无脑hash表
    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }
}