package day1;

/**
 * @author 陈佳乐
 * @create 2023-02-02-14:57
 */
public class q8 {
    //    8. 字符串转换整数 (atoi)
    public static void main(String[] args) {
        System.out.println(new Solution8().myAtoi("+-12"));
    }
}

class Solution8 {
    public int myAtoi(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        int length = s.length();
        int temp = 0;
        while (temp < length && chars[temp] == ' ') {
            temp++;
        }
        int index = temp;
        int flag = 1;
        while (index < length) {
            if (index == temp && chars[index] == '-') {
                flag = -1;
                index++;
            } else if (index == temp && chars[index] == '+') {
                flag = 1;
                index++;
            } else if (Character.isDigit(chars[index])) {
                int num = chars[index] - '0';
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                }

                if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && -num < Integer.MIN_VALUE % 10)) {
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + flag * num;
                index++;
            } else {
                break;
            }
        }
        if (index == 0) return 0;
        return res;
    }
}