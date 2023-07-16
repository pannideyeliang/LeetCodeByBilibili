package Code.easy1;

public class q409 {
    //    409. 最长回文串
    public static void main(String[] args) {

    }
}

class Solution409 {
    //    注意是构造，所以实际上是字符串统计
//    但是注意又包括大写和小写字母，且不能看做同一个字符
//    需要注意的是大写和小写字母的ascii不是连在一起的
//    通过但狗屎代码
//    单只有一个字符，可以作为中心，一个奇数字符可以取一个作为中心
//    以上两种情况不能叠加，只能二选一
    public int longestPalindrome(String s) {
        int[] mapL = new int[26];
        int[] mapH = new int[26];
        for (char c : s.toCharArray()) {
//            大写字母的ascii比较小，小写的比较大
            if (c - 'a' < 0) {
                mapH[c - 'A']++;
            } else {
                mapL[c - 'a']++;
            }
        }
        int res = 0;
        int mid = 0;
        for (int i : mapL) {
            if (i == 1) {
                mid = 1;
            }
            if (i != 0 && i % 2 == 0) {
                res += i;
            }
            if (i % 2 != 0) {
                mid = 1;
                res += i - 1;
            }
        }
        for (int i : mapH) {
            if (i == 1) {
                mid = 1;
            }
            if (i != 0 && i % 2 == 0) {
                res += i;
            }
            if (i % 2 != 0) {
                mid = 1;
                res += i - 1;
            }
        }
        return res + mid;
    }

    //    查看大佬的代码
//    区分个毛线的大小写，直接整个ASCII表
    public int longestPalindrome1(String s) {
        char[] occurs = new char[128];
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            occurs[c]++;
//            只要字符出现的次数是偶数个，就直接给加上去
            if (occurs[c] == 2) {
                ans += 2;
                occurs[c] = 0;
            }
        }

//        如果小，说明肯定存在奇数字符，直接加一就可以了
        if (ans < s.length()) ans++;
        return ans;
    }
}
