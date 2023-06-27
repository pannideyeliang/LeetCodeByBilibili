package Code.easy0;

public class q202 {
    //    202. 快乐数
    public static void main(String[] args) {
        int n = 68;
        int next = 0;
        while (n != 0) {
            next += (n % 10) * (n % 10);
            n /= 10;
        }
        System.out.println(next);
    }
}


class Solution202 {

    //    简单的算法， 直接使用递归既可
    public boolean isHappy(int n) {
        if (n == 1) return true;
        if (n > 1 && n < 10 && n != 7) return false;
//        否则
        int next = 0;
        while (n != 0) {
            next += (n % 10) * (n % 10);
            n /= 10;
        }
        return isHappy(next);
    }
}
