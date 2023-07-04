package Code.easy1;

public class q342 {
    //    342. 4的幂
    public static void main(String[] args) {

    }
}


class Solution342 {

    //    可以这样写，但是效率比较低
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        while (n % 4 == 0) {
            n = n / 4;
        }
        return n == 1;
    }

    //    大佬写法，从4的幂的二进制入手
    public boolean isPowerOfFour1(int n) {
//        构造特殊的数据
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }
}