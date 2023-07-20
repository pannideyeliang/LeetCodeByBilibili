package Code.easy1;

import java.util.Arrays;
import java.util.HashSet;

public class q345 {
    //    345. 反转字符串中的元音字母
    public static void main(String[] args) {

    }
}

class Solution345 {
    //    朴实无华的思想
//    元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次
//    大部分能过，但是还是有问题的代码
    public String reverseVowels(String s) {
        if (s.length() == 1) return s;
        char[] chars = s.toCharArray();
        char temp;
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            while (left <= right && s.charAt(left) != 'a' && s.charAt(left) != 'e' &&
                    s.charAt(left) != 'i' && s.charAt(left) != 'o' &&
                    s.charAt(left) != 'u' && s.charAt(left) != 'A' &&
                    s.charAt(left) != 'E' && s.charAt(left) != 'I' && s.charAt(left) != 'O'
                    && s.charAt(left) != 'U'
            ) {
                left++;
            }

            while (left <= right && s.charAt(right) != 'a' && s.charAt(right) != 'e' &&
                    s.charAt(right) != 'i' && s.charAt(right) != 'o' &&
                    s.charAt(right) != 'u' && s.charAt(right) != 'A' &&
                    s.charAt(right) != 'E' && s.charAt(right) != 'I' && s.charAt(left) != 'O'
                    && s.charAt(right) != 'U'
            ) {
                right--;
            }
            if (left <= right) {
                temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            } else {
                return new String(chars);
            }
        }
        return new String(chars);
    }


    //    查看大佬代码
//    由于元音字母相对固定，因此我们可以使用容器将其存储，并使用 static 修饰，确保整个容器的创建和元音字母的填入在所有测试样例中只会发生一次。
//
//    我们期望该容器能在 O(1)O(1)O(1) 的复杂度内判断是否为元音字母，可以使用语言自带的哈希类容器（P2P2P2 代码）或是使用数组模拟（P1P1P1 代码）。
//
//    一些细节：由于题目没有说字符串中只包含字母，因此在使用数组模拟哈希表时，我们需要用当前字符减去 ASCII 码的最小值（空字符），而不是 'A'
    static boolean[] hash = new boolean[128];
    static char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};

    static {
        for (char c : vowels) {
            hash[c - ' '] = hash[Character.toUpperCase(c) - ' '] = true;
        }
    }

    public String reverseVowels1(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        int l = 0, r = n - 1;
        while (l < r) {
            if (hash[cs[l] - ' '] && hash[cs[r] - ' ']) {
                swap(cs, l++, r--);
            } else {
//                保证一次走一步
//                确保就像是单纯的翻转一个纯元音字母组成的字符串
                if (!hash[cs[l] - ' ']) l++;
                if (!hash[cs[r] - ' ']) r--;
            }
        }
        return String.valueOf(cs);
    }

    void swap(char[] cs, int l, int r) {
        char c = cs[l];
        cs[l] = cs[r];
        cs[r] = c;
    }
}
