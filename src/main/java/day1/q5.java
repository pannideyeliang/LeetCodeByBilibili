package day1;


/**
 * @author 陈佳乐
 * @create 2023-01-10-14:04
 */
public class q5 {
    //5. 最长回文子串
    public static void main(String[] args) {
        System.out.println(new Solution5().longestPalindrome("abcdcba"));
    }
}

class Solution5 {

    //第一种方法，遍历整个字符串，分为奇数，偶数情况，他们都有可能是回文串的中心，由中心向两边寻找
//    直到不是回文串，每次保留最长的回文串。这种方法也可以称之为中心扩散法，
    public String longestPalindrome(String s) {
        String res  = "";
        int i = 0;
        while (i >= 0 && i < s.length()) {
            String s1 = findHuiWen(s, i, i);
            String s2 = findHuiWen(s, i, i + 1);
            i++;
            res = s1.length() > res.length() ? s1 : res;
            res = s2.length() > res.length() ? s2 : res;
        }
        return res;
    }

    public String findHuiWen(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return s.substring(left + 1, right);
    }

    //    2.采用万能方法，动态规划,动态转移方程实际上就是推导方程
    public String longestPalindromeV2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
//        动态数组，用于存储从i 到 j 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] chars = s.toCharArray();
//        初始化，所有长度为1的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

//       开始进行动态规划的推导表达式
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (chars[j] != chars[i]) {
                    dp[j][i] = false;
                } else {
                    if (i - j < 3) {
                        dp[j][i] = true;
                    } else {
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                }

//                只要dp[j][i] == true，就表示是回文串，所以要记录下回文串的长度和起始位置
                if (dp[j][i] && i - j + 1 > maxLen) {
                    maxLen = i - j + 1;
                    begin = j;
                }
            }

        }
        return s.substring(begin, begin + maxLen);
    }
}


