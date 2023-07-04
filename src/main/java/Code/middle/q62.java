package Code.middle;

public class q62 {
    //    62. 不同路径
    public static void main(String[] args) {

    }
}


class Solution62 {
    //    经典动态规划问题
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
//        注意边界条件一定要找清楚
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}