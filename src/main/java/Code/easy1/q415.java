package Code.easy1;

import java.math.BigInteger;

public class q415 {
    //    415. 字符串相加
    public static void main(String[] args) {
        String n1 = "12";
        String n2 = "123";
        String s = new Solution415().addStrings1(n1, n2);
        System.out.println(s);
    }
}


class Solution415 {
    //不符合题目要求的做法
    public String addStrings(String num1, String num2) {
        BigInteger b1 = new BigInteger(num1);
        BigInteger b2 = new BigInteger(num2);
        BigInteger add = b1.add(b2);
        return add.toString();
    }

    //    下面我们使用算法
//    很明显，写的有问题
    public String addStrings1(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();
        int len = Math.min(num1.length(), num2.length());
        int count = 0;
        for (int i = 1; i <= len; i++) {
            char c1 = num1.charAt(len1 - i);
            char c2 = num2.charAt(len2 - i);
            int temp = c1 + c2 + count - '0' - '0';
            if (temp >= 10) {
                count = 1;
                temp -= 10;
            }
            sb.append((char) (temp + '0'));
        }

        return sb.reverse().toString();
    }

    //    查看大佬代码
    public String addStrings2(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while(i >= 0 || j >= 0){
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--; j--;
        }
        if(carry == 1) res.append(1);
        return res.reverse().toString();
    }

}
