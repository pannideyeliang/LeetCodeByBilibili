package Code.easy1;

public class q441 {
    //    441. 排列硬币
    public static void main(String[] args) {
        int i = new Solution441().arrangeCoins(5);
        System.out.println(i);
    }
}


class Solution441 {
    //    贼简单
    public int arrangeCoins(int n) {
        int count = 1;
        int tmp = 0;
        while (tmp < n) {
            tmp += count;
            count++;
        }
        return count - 2;
    }
}