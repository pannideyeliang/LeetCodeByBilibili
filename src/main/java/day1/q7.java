package day1;

import java.util.Stack;

/**
 * @author 陈佳乐
 * @create 2023-01-31-9:54
 */
public class q7 {
    public static void main(String[] args) {
//        7. 整数反转
        int reverse = new Solution7().reverseV3(-12345600);
        System.out.println(reverse);
    }
}

class Solution7 {

    //    自己写的狗屎代码，狗屎方法
    public int reverse(int x) {
        if (x == 0) return 0;
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        if (x < 0) res.append('-');
        Integer s = new Integer(x);
        char[] chars = s.toString().toCharArray();
        for (char c : chars) stack.push(c);

//        提前把后面的 0 全部pop出来，防止 109 这种逆转成 91
        char temp;
        temp = stack.pop();
        while (temp == '0') {
            temp = stack.pop();
        }
        res.append(temp);
        while (!stack.isEmpty()) {
            Character c = stack.pop();
            if (c != '-') res.append(c);
        }
        long l = Long.parseLong(res.toString());
//        int的上下线
        if (l < -2147483648 || l > 2147483647) return 0;
        int result = Integer.parseInt(res.toString());
        return result;
    }

    //    大佬们使用的方法；
    public int reverseV2(int x) {
//        直接调API
        int flag = x >= 0 ? 1 : -1;
        int res;
        try {
//            这里比较好的是，Integer.parseInt 可以直接把 0000123101 前面的 0 给过滤掉
            res = Integer.parseInt(new StringBuilder(String.valueOf(x * flag)).reverse().toString());
        } catch (NumberFormatException e) {
            return 0;
        }
        return res * flag;
    }

    //    朴实且高效的方法，直接取模翻转就好
    public int reverseV3(int x) {
        int res = 0, temp = 0;
        while (x != 0) {
            temp = x % 10;
//            max   2147483647
            if (res>214748364 || (res==214748364 && temp>7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
//            min -2147483648
            if (res<-214748364 || (res==-214748364 && temp<-8)) {
                return 0;
            }
            res = res * 10 + temp;
            x = x / 10;

        }
        return res;
    }
}