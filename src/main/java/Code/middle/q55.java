package Code.middle;

public class q55 {
    //    55. 跳跃游戏
    public static void main(String[] args) {

    }
}


class Solution55 {
    //    无脑dp
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int[] dp = new int[nums.length];
//        dp[i] 表示到达 i 能跳到的最大距离
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] < i) return false;
            dp[i] = Math.max(i + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1] >= nums.length - 1;
    }

    //    优化过后, 直接计算能够跳到的最远距离
    public boolean canJump1(int[] nums) {
        if (nums.length == 1) return true;
        int max = 0;
        for (int i = 0; i <= max; i++) {
            max = Math.max(i + nums[i], max);
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

}