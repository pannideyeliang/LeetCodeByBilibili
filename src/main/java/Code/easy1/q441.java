package Code.easy1;

public class q441 {
    //    441. 排列硬币
    public static void main(String[] args) {
        int i = new Solution441().arrangeCoins(5);
        System.out.println(i);
    }
}


class Solution441 {
    //    贼简单, 但是最后一个案例跑不成功
//    但是如果从n开始不断地减就不存在溢出了
//    加法溢出，但是减法不会溢出
    public int arrangeCoins(int n) {
        if (n == 1) return 1;
        int count = 1;
        int tmp = 0;
        while (tmp < n) {
            tmp += count;
            count++;
        }

        return tmp == n ? count - 1 : count - 2;
    }

    //    求助大佬
    public int arrangeCoins1(int n) {
//        下面是数学方法
//return (int)((Math.sqrt(1 + 8.0 * n) - 1) / 2);
//        怕溢出，可以采用大的数据类型存储
        long l = 1, r = n;
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (mid * (mid + 1) / 2 <= n) l = mid;
            else r = mid - 1;
        }
        return (int)r;
    }
}