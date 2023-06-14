package easy;

import java.util.Arrays;

public class q121 {
    //    121. 买卖股票的最佳时机
    public static void main(String[] args) {

    }
}

class Solution121 {

    //    暴力求解, 但是会超出时间限制
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (max < prices[j] - prices[i]) {
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
    }

    //    动态规划
    public int maxProfit1(int[] prices) {
//        dp表示前 i 天的最大利润
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int minprice = prices[0];//minprice代表历史最低价格，
        // 所以i从1开始历史最低价格肯定是prices[0]
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - minprice);
            minprice = Math.min(minprice, prices[i]);

        }
        return dp[prices.length - 1];
    }

    //    大佬优化的代码，一遍遍历既可
    public int maxProfit2(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}

