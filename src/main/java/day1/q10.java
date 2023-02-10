package day1;

/**
 * @author 陈佳乐
 * @create 2023-02-06-14:14
 */
public class q10 {
    //    10. 正则表达式匹配
    public static void main(String[] args) {
        System.out.println(new Solution10().isMatchV2("", "a*b*c*"));
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
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();

//        dp[i][j]: 表示s的前i个字符，p的前j个字符是否匹配
//        因为数组下标是从0开始的，所以如果要能表示 dp[i][j] ,在定义数组的时候
//        数组的大小应该为 dp[i+1][j+1],如 a = new int[3],则 a[3] 会报错
        boolean[][] dp = new boolean[sc.length + 1][pc.length + 1];

//        初始值， s 为空   p 为空，是能匹配上的
        dp[0][0] = true;
//        p 为空 s 不为空， 则必定是false，初始化的boolean数组里面的值
//        默认都是空的，所以不需要处理

//        s 为空， p 不是空，由于*可以匹配0个字符，所以有可能为true
        for (int j = 1; j <= pc.length; j++) {
            if (pc[j - 1] == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
//        补充动态规划的格子
        for (int i = 1; i <= sc.length; i++) {
            for (int j = 1; j <= pc.length; j++) {
//              文本串和模式串的末尾字符能否匹配上，从后往前匹配
                if (sc[i - 1] == pc[j - 1] || pc[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc[j - 1] == '*') {  //如果模式串的结尾是 '*'
//                    判断模式串*的前一个字符是否能跟文本串的末位匹配上
                    if (sc[i - 1] == pc[j - 2] || pc[j - 2] == '.') {
                        dp[i][j] = dp[i][j - 2]     // * 匹配到0次的情况
                                || dp[i - 1][j];    // * 匹配1或多次的情况
                    } else {   //模式串*前的一个字符不能够跟文本串的末位匹配
                        dp[i][j] = dp[i][j - 2];   // * 只能匹配0次
                    }
                }
            }
        }

        return dp[sc.length][pc.length];
    }
}