package Code.day1;

import java.util.HashMap;

public class q1 {
//    两数之和
}

class Solution {

    //  使用暴力法破解
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return new int[]{0};
    }

    //    使用哈希表，节省查找效率
    public int[] twoSumV2(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
//       创建哈希表
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i]) && hashMap.get(target - nums[i]) != i){
                return new int[]{i, hashMap.get(target - nums[i])};
            }
        }
        return new int[]{0};
    }
}
