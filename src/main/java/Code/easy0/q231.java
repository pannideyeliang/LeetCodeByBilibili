package Code.easy0;

public class q231 {
    //    231. 2 的幂
    public static void main(String[] args) {

    }
}

class Solution231 {
    //    使用递归
    public boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        if (n == 0) return false;
        if (n % 2 != 0) return false;
        return isPowerOfTwo(n / 2);
    }

    //    使用与运算
    public boolean isPowerOfTwo1(int n) {
        if (n < 1) return false;
        return (n & (n - 1)) == 0;
//         return n > 0 && (n & (n - 1)) == 0;
    }
}
