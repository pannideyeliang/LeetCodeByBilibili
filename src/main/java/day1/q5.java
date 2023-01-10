package day1;

/**
 * @author 陈佳乐
 * @create 2023-01-10-14:04
 */
public class q5 {
    //5. 最长回文子串
    public static void main(String[] args) {
        System.out.println(new Solution5().longestPalindrome("abb"));
    }
}

class Solution5 {

    //第一种方法，遍历整个字符串，分为奇数，偶数情况，他们都有可能是回文串的中心，由中心向两边寻找
//    直到不是回文串，每次保留最长的回文串。这种方法也可以称之为中心扩散法，
    public String longestPalindrome(String s) {
        String res = "";
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

    //    2.采用万能方法，动态规划
    public String longestPalindromeV2(String s) {

        return null;
    }
}


