package Code.easy2;

public class q509 {
    //    509. 斐波那契数
    public static void main(String[] args) {

    }
}


class Solution509 {
    //    采用递归的方式时间复杂度太高了
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    //    查看大佬代码
//    滑动窗口的思想，不断往前计算需要计算的数，该方式是从前往后计算结果
//    递归是从后往前计算
    public int fib1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int p = 0, q = 1, res = 0;
        for (int i = 2; i <= n; i++) {
            res = p + q;
            p = q;
            q = res;
        }
        return res;
    }
}