package day1;

/**
 * @author 陈佳乐
 * @create 2023-02-03-14:41
 */
public class q9 {

    //    9. 回文数
    public static void main(String[] args) {
        System.out.println(new Solution9().isPalindrome(12321));
    }
}


class Solution9 {
    //    最简单的方式，转换为字符串，使用字符串反转
    public boolean isPalindrome(int x) {
        StringBuilder rev = new StringBuilder();
        rev.append(Integer.toString(x));
//        System.out.println(Integer.toString(x));
//        System.out.println(rev.reverse().toString());
        return Integer.toString(x).equals(rev.reverse().toString());
    }

    //    不适用字符串的方式, 和之前找最长回文子串的思想一样的,从中心发散去找
    public boolean isPalindromeV2(int x) {
        char[] chars = Integer.toString(x).toCharArray();
        if (chars[0] == '-' || chars[0] == '+') return false;
        int left, right;

        return true;
    }
}