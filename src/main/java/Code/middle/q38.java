package Code.middle;

import java.util.Stack;

public class q38 {
    //    38. 外观数列
    public static void main(String[] args) {
        String s = new Solution38().countAndSay(4);
        System.out.println(s);
    }
}

class Solution38 {
    //    简单模拟
//    先正向模拟
    public String countAndSay(int n) {
        StringBuilder res = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            res = getNew(res.toString());
        }
        return res.toString();
    }

    private StringBuilder getNew(String res) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        StringBuilder r = new StringBuilder("");
        for (char c : res.toCharArray()) {
            if (stack.isEmpty() || stack.peek() == c) {
                stack.push(c);
                count++;
            } else {
                r.append(count).append(stack.peek());
                stack.clear();
                stack.push(c);
                count = 1;
            }
        }
        r.append(count).append(stack.peek());
        return r;
    }

    //查看大佬代码，简洁版本统计模拟
    public String countAndSay1(int n) {
        String str = "1";
        for (int i = 2; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int pos = 0;

            while (pos < str.length()) {
                while (pos < str.length() && str.charAt(pos) == str.charAt(start)) {
                    pos++;
                }
                sb.append(Integer.toString(pos - start)).append(str.charAt(start));
                start = pos;
            }
            str = sb.toString();
        }

        return str;
    }

    //    大佬版本，递归
//    实际上是把迭代优化成递归，提高时间效率
    public String countAndSay2(int n) {
        if (n == 1) {
            return "1";
        }
        String pre = countAndSay2(n - 1);
        return say(pre);

    }

    public String say(String str) {
        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            while (j < arr.length && arr[i] == arr[j]) {
                j++;
            }

            sb.append(j - i);
            sb.append(arr[i]);
            i = j;
        }
        return sb.toString();
    }
}
