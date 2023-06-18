package easy0;

import java.util.Arrays;
import java.util.HashMap;

public class q169 {
    //    169. 多数元素
    public static void main(String[] args) {

    }
}


class Solution169 {
    //    注意条件
//    你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//    这里我们可以使用最常见的hashmap
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        HashMap<Integer, Integer> res = new HashMap<>();
        int temp;
        for (int i : nums) {
            if (!res.containsKey(i)) {
                res.put(i, 0);
            } else {
//                因为说了必定存在，所以直接在这里判断并返回既可，不需要后面冗余的代码
                temp = res.get(i) + 1;
                if (temp >= nums.length / 2) {
                    return i;
                }
                res.put(i, temp);
            }
        }
//        接着返回多数元素, 其实
//        Set<Integer> integers = res.keySet();
//        for (int i : integers) {
//            if (res.get(i) >= nums.length / 2) {
//                return i;
//            }
//        }
        return 0;
    }

    //    时间复杂度还是比较高，所以我们参考一下大佬们的代码
//    排序
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //Boyer-Moore 投票算法
    public int majorityElement2(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
















