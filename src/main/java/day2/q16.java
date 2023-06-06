package day2;

import java.util.Arrays;
import java.util.DuplicateFormatFlagsException;

public class q16 {
    //16. 最接近的三数之和
//    给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
//    返回这三个数的和。
//    假定每组输入只存在恰好一个解。
    public static void main(String[] args) {
        int nums[] = {-1, 2, 1, -4};
        System.out.println(new Solution16().threeSumClosest2(nums, 1));
    }
}


class Solution16 {
    //    下面这个写法有问题
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int step, sum;
        sum = nums[0] + nums[1] + nums[2];
        step = Math.min(Math.abs(sum - target), Math.abs(target - sum));
        int total;

        for (int i = 0; i <= nums.length - 3; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (sum == target) {
                    return sum;
                }
                if (sum > target) {
                    right--;
                    total = nums[i] + nums[left] + nums[right];
                    sum = Math.min(Math.abs(total - target), Math.abs(target - total))
                            < step ? nums[i] + nums[left] + nums[right] : sum;
                    step = Math.min(Math.abs(sum - target), Math.abs(target - sum));
                }
                if (sum < target) {
                    left++;
                    total = nums[i] + nums[left] + nums[right];
                    sum = Math.min(Math.abs(total - target), Math.abs(target - total))
                            < step ? nums[i] + nums[left] + nums[right] : sum;
                    step = Math.min(Math.abs(sum - target), Math.abs(target - sum));
                }
            }
        }

        return sum;
    }

    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }
                if(sum > target)
                    right--;
                else if(sum < target)
                    left++;
                else
                    return res;

            }
        }
        return res;
    }
}

