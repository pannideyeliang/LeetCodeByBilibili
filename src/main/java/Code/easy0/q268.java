package Code.easy0;

import java.util.Arrays;

public class q268 {
    //    268. 丢失的数字
    public static void main(String[] args) {

    }
}

class Solution268 {
    //    排序找谁不是
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] != 1) {
                return nums[i] + 1;
            }
        }
        if (nums[0] != 0) return 0;
        return nums[nums.length - 1] + 1;
    }

    //    数组hash
    public int missingNumber1(int[] nums) {
        int n = nums.length;
        boolean[] hash = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            hash[nums[i]] = true;
        }
        for (int i = 0; i < n; i++) {
            if (!hash[i]) return i;
        }
        return n;
    }

    //   数学方法，作差
    public int missingNumber2(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return (1 + nums.length) * nums.length / 2 - sum;
    }
}
