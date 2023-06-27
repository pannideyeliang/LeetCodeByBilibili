package Code.easy;

/**
 * @author 陈佳乐
 * @create 2023-06-15-22:12
 */
public class q136 {
    //    136. 只出现一次的数字
    public static void main(String[] args) {
        System.out.println(123 ^ 123 ^ 21);
    }
}

class Solution136 {
    //    实际上是对异或运算符的用法
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i: nums) {
            res ^=i;
        }
        return res;
    }
}
