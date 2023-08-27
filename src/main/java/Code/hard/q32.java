package Code.hard;

public class q32 {
    //    32. 最长有效括号
    public static void main(String[] args) {

    }
}

class Solution32 {
    //    使用DP
//    一般这种题目都是以每个字符结尾的情况下，答案是多少
//    子串问题
    public int longestValidParentheses(String s) {
//        dp【i】表示子串必须以 i 位置字符结尾，最长的有效长度能有多大
//        以左括号结尾则 一定为 0 ， 最后遍历 dp 中的最大值
//        求 dp【i】 ，首先 i 位置一定为 右括号 则需要求 dp 【i - 1】，
//        同时需要看  dp【i - 1】 最前面的 字符串是不是 （ ，如果是的话需要再加2，
//        同时还是需要再看一下 再往前一个的 dp
//        代码如下：
        if (s == null || s.equals("")) return 0;
        int[] dp = new int[s.length()];
        char[] chars = s.toCharArray();
        int pre = 0;
//        不断记录最大值
        int res = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && chars[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
