package Code.easy1;

public class q389 {
    //    389. 找不同
    public static void main(String[] args) {
        new Solution389().findTheDifference("abcd", "abcde");
    }
}


class Solution389 {
    //    非常简单的题目
//
    public char findTheDifference(String s, String t) {
//        题目说了，字符串 t 由字符串 s 随机重排 ，所以下面的算法是不对的
//        if (s.length() == 0) return t.charAt(0);
//        int index = 0;
//        while (index < s.length()) {
//            if (s.charAt(index) != t.charAt(index)) {
//                return t.charAt(index);
//            }
//            index++;
//        }
//        return t.charAt(t.length() - 1);

//        以下才是正确算法，注意只有一个不同，所以
        if (s.length() == 0) return t.charAt(0);
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            map[c - 'a']--;
            if (map[c - 'a'] == -1) {
                return c;
            }
        }
        return 'a';
    }

    //    和只出现一次的数字一样，可以采用异或操作
//    大佬代码
    public char findTheDifference1(String s, String t) {
        char res = 0;
        for (char c : s.toCharArray()) {
            res ^= c;
        }
        for (char c : t.toCharArray()) {
            res ^= c;
        }
        return res;
    }
}
