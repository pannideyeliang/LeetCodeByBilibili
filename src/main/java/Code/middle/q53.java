package Code.middle;

public class q53 {
    //   53. 最大子数组和
    public static void main(String[] args) {

    }
}

class Solution53 {

    //    可以采用动态规划
    public int maxSubArray(int[] nums) {
//返回其最大和。
//        dp[i]表示以i结尾的子数组的最大值是多少
//        所以记录前i个最大和的子序列没有意义，要是不以第i个结尾，加上第n个元素之后也不是连续子序列。
//        答案肯定在这里
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    //    当然上述代码可以在过程中优化
    public int maxSubArray1(int[] nums) {
        int pre = nums[0];
        pre = nums[0];
        int max = pre;
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }

}

