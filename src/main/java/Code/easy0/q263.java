package Code.easy0;

public class q263 {
    //    263. 丑数
    public static void main(String[] args) {

    }
}

class Solution263 {
    //    题目的难点在于如何理解什么是丑数
//    丑数 就是只包含质因数 2、3 和 5 的正整数  意思是只能是若干个 235乘起来的
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;
        return n == 1;
    }
}
