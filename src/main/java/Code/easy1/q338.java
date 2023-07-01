package Code.easy1;

//动态规划专项
public class q338 {
    //    338. 比特位计数
    public static void main(String[] args) {

    }
}


class Solution338 {
    //    假设不使用动态规划，直接计算
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        int count;
        for (int i = 0; i < n + 1; i++) {
            count = 0;
            int temp = i;
            while (temp != 0) {
                if ((temp & 1) == 1) {
                    count++;
                }
                temp = temp >> 1;
            }
            res[i] = count;
        }
        return res;
    }

    //    如何使用动态规划呢
    public int[] countBits1(int n) {
// 状态转移，如果是二的整数幂，则就是1，否则，就是
//        按照最高有效位为状态进行转移
//        当然这是一种从前推后的算法，
//        如 1110 是右 110 + 1 转移过来的
        int[] res = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
//            如果是2的整数幂
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            res[i] = res[i - highBit] + 1;
        }
        return res;
    }

    //    上述思想不太好想，我们可以使用最低有效位进行动态规划
    public int[] countBits2(int n) {
//        如果 n 是偶数，则 n 中含1的个数等于 n >> 1
//        如果 n 是奇数，则 n 中含1的个数等于 n >> 1 + 1
        int[] res = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (i % 2 == 0) {
                res[i] = res[i >> 1];
            } else {
                res[i] = res[i >> 1] + 1;
            }
//            其实上述两个判断可以合并在一起
//            for (int i = 1; i <= n; i++) {
//                bits[i] = bits[i >> 1] + (i & 1);
//            }
//            i & 1 奇数为1，偶数为0
        }
        return res;
    }
}