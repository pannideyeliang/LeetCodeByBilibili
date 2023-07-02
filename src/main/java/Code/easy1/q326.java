package Code.easy1;

import java.util.HashSet;
import java.util.Set;

public class q326 {
    //    326. 3 的幂
    public static void main(String[] args) {

    }
}


class Solution326 {
    //    简单递归
    public boolean isPowerOfThree(int n) {
        if (n == 1) return true;
        if (n % 3 != 0 || n == 0) return false;
        return isPowerOfThree(n / 3);
    }

    //    大佬写法
    public boolean isPowerOfThree1(int n) {
//        如果 n 为 3 的幂的话，那么必然满足 n∗3k=1162261467n * 3^k = 1162261467n∗3
//          k =1162261467，即 n 与 116226146711622614671162261467 存在倍数关系
        return n > 0 && 1162261467 % n == 0;
    }

    //    大佬写法，预处理，打表。拿空间换时间
    static Set<Integer> set = new HashSet<>();

    static {
        int cur = 1;
        set.add(cur);
        while (cur <= Integer.MAX_VALUE / 3) {
            cur *= 3;
            set.add(cur);
        }
    }

    public boolean isPowerOfThree3(int n) {
        return n > 0 && set.contains(n);
    }

}