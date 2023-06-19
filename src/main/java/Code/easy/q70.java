package Code.easy;

public class q70 {
    //    70. 爬楼梯
    public static void main(String[] args) {
        System.out.println(new Solution70().climbStairs(4));
    }
}

class Solution70 {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
//            难点在于这里是考虑的是方法数，而不是步骤数目
            dp[i] = dp[i - 1] + dp[i - 2] ;
        }
        return dp[n];
    }
}
