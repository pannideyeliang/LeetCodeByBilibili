package day1;

/**
 * @author 陈佳乐
 * @create 2023-02-06-14:14
 */
public class q10 {
    //    10. 正则表达式匹配
    public static void main(String[] args) {

        System.out.println(new Solution10().isMatch("abcd", "abc*"));
    }
}

class Solution10 {
    //    半成品答案，不能解决所有的案例。
    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] panter = p.toCharArray();
        boolean flag = true;
        for (int i = 0, k = 0; i < s.length(); i++) {
            if (k > panter.length - 1) return false;
            if (str[i] == panter[k]) {
                k++;
            } else if (str[i] != panter[k] && panter[k] == '.') {
                k++;
                if (k < p.length() && panter[k] == '*') {
                    return true;
                }
            } else if (str[i] != panter[k] && panter[k] == '*') {
                if (k == 0 || k != 0 && str[i] != panter[k - 1]) return false;
            } else {
                return false;
            }
        }
        return flag;
    }

    //    正确使用方法，应该采取动态规划
    public boolean isMatchV2(String s, String p) {

        return true;
    }
}