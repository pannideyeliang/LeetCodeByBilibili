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
//        dp[i]表示到达i的最大值是多少
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
}

