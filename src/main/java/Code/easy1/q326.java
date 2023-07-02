package Code.easy1;

public class q326 {
    //    326. 3 的幂
    public static void main(String[] args) {

    }
}


class Solution326 {
    //    简单递归
    public boolean isPowerOfThree(int n) {
        if (n == 1) return true;
        if (n % 3 != 0||n == 0) return false;
        return isPowerOfThree(n/3);
    }
}