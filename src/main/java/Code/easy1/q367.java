package Code.easy1;

public class q367 {
    //    367. 有效的完全平方数
    public static void main(String[] args) {
//        System.out.println(202049 * 202049);
        new Solution367().isPerfectSquare(2147395600);
    }
}

class Solution367 {
    //    不能使用库函数，则只能使用二分查找提高效率了
    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        int mid = left + (right - left) / 2;
        while (mid * mid != num) {
//            注意这里如果数太大就溢出了 mid * mid < 0
//            投降了已经，没有更好的判断溢出方法了
            if (mid * mid > num || mid * mid < 0 || mid > Math.sqrt(Integer.MAX_VALUE)) {
                right = mid - 1;
                if (mid == left + (right - left) / 2) {
                    return false;
                }
                mid = left + (right - left) / 2;
            } else {
                left = mid + 1;
                if (mid == left + (right - left) / 2) {
                    return false;
                }
                mid = left + (right - left) / 2;
            }
        }
        return true;
    }

    //    查看官方的二分查找
    public boolean isPerfectSquare1(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
//            使用long来防止int * int 溢出
            long square = (long) mid * mid;
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    //    查看大佬的方法，数学原理
//    1 4=1+3 9=1+3+5 16=1+3+5+7以此类推，模仿它可以使用一个while循环，不断减去一个从1开始不断增大的奇数，若最终减成了0，说明是完全平方数，否则，不是
//    原理:(n+1)^2-n^2=2n+1
    public boolean isPerfectSquare2(int num) {
        int num1 = 1;
        while (num > 0) {
            num -= num1;
            num1 += 2;
        }
        return num == 0;
    }
}
