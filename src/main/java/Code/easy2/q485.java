package Code.easy2;

public class q485 {
    //    485. 最大连续 1 的个数
    public static void main(String[] args) {

    }
}


class Solution485 {
    //    简单，直接模拟
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, tmp = 0;
        for (int i : nums) {
            if (i == 1) {
                tmp++;
            } else {
                res = Math.max(tmp, res);
                tmp = 0;
            }
        }
        return Math.max(tmp, res);
    }
}