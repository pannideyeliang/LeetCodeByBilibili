package day1;

/**
 * @author 陈佳乐
 * @create 2023-02-02-14:57
 */
public class q8 {
    //    8. 字符串转换整数 (atoi)
    public static void main(String[] args) {
        System.out.println(new Solution8().myAtoi("4193 with words"));
    }
}

class Solution8 {
    public int myAtoi(String s) {
        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '-' || c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' ||
                    c == '6' || c == '7' || c == '8' || c == '9') {
                res.append(c);
            }
        }

        return Integer.parseInt(res.toString());
    }
}