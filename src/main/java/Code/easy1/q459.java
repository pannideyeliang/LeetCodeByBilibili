package Code.easy1;

public class q459 {
    //    459. 重复的子字符串
    public static void main(String[] args) {

    }
}


class Solution459 {
    //    无脑方法，依次遍历所有可能的子串
//    106 / 129 个通过的测试用例
    public boolean repeatedSubstringPattern(String s) {
//        考虑到所有可能的子串长度
        int len = 1;
        while (len <= s.length() / 2) {
//            当可能是子串时
            if (s.length() % len == 0) {
                int i;
                for (i = 0; i < s.length() / len - 1; i++) {
                    if (s.substring(i * len, i * len + len).equals(s.substring(i * len + len, i * len + len + len))) {
                        break;
                    }
                }
                if (i * len + len + len == s.length()) {
                    return true;
                }
            }
            len++;
        }
        return false;
    }

    //    查看大佬代码
    public boolean repeatedSubstringPattern1(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

//    暴力法经典算法-滑动窗口
    public boolean repeatedSubstringPattern2(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
//                    暴力法经典算法-滑动窗口 画图就懂了
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }
}