package Code.easy;

public class q67 {
    //    67. 二进制求和
    public static void main(String[] args) {
        System.out.println((char) (1 + '1'));
    }
}

class Solution67 {
    //    直接调用api,但是这个对int类型是有精度要求的，不能适用于所有的情况
    public String addBinary(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }

    //  所以我们可以采用模拟的情况，
    public String addBinary1(String a, String b) {
        StringBuilder res = new StringBuilder();
//找到两个的最长的
        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; i++) {
//            后面的0其实就是为了补全短的运算
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            res.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        if (carry > 0) {
            res.append('1');
        }
        res.reverse();
        return res.toString();
    }

    //    当然，如上方式不够优雅，判断语句的三目运算符过于丑陋，所以我们可以选择使用补全的方式
//    进行处理，但是这个的效率有点低，不过可以考虑把a,b换成stringBuilder
    public String addBinary2(String a, String b) {
        while (a.length() < b.length()) {
            a = "0" + a;
        }
        while (b.length() < a.length()) {
            b = "0" + b;
        }
        int carry = 0, len = a.length();

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < len; i++) {
            carry += (a.charAt(len - 1 - i) - '0') + (b.charAt(len - 1 - i) - '0');
            res.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        if (carry > 0) {
            res.append('1');
        }
        res.reverse();
        return res.toString();
    }
}
