package Code.easy0;

public class q191 {
    //    191. 位1的个数
    public static void main(String[] args) {

    }
}


class Solution {
    // you need to treat n as an unsigned value
//   实际上是对与运算的考察
//    不采用与运算如下, 时间复杂度非常高
    public int hammingWeight(int n) {
        String string = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    //   实际上是对与运算的考察
    public int hammingWeight1(int n) {
//        注意这里要使用逻辑右移，高位补0，而不是补 符号位
        int count = 0;
        while (n != 0) {
            count = (n & 1) == 1 ? count + 1 : count;
            n = n >>> 1;
        }
        return count;
    }

}