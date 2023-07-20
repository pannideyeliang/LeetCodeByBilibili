package Code.easy2;

/**
 * @author 陈佳乐
 * @create 2023-07-20-20:39
 */
public class q461 {
    //    461. 汉明距离
    public static void main(String[] args) {

    }
}

class Solution461 {
    //    简单，没啥好说的，异或
    public int hammingDistance(int x, int y) {
        int c = x ^ y;
        int count = 0;
        while (c != 0) {
            if ((c & 1) == 1) {
                count++;
            }
            c = c >> 1;
        }
        return count;

//        return Integer.bitCount(x ^ y);  这个玩意经常使用，内置的计算 数字中二进制 1 的个数
    }
}
