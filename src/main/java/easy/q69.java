package easy;

import org.junit.Test;

public class q69 {
    //    69. x 的平方根
    public static void main(String[] args) {
        System.out.println(new Solution69().mySqrt1(6));
    }
}


class Solution69 {

    //    无脑ac
    public int mySqrt(int x) {
        return (int) Math.pow(x, 0.5f);
    }

    //    有脑算法, 采用二分查找
    public int mySqrt1(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        int left = 0, right = x / 2;
        while (left < right) {
//            不加1的话会出现死循环
            int mid = left + (right - left + 1) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
