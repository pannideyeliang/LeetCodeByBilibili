package Code.easy2;

public class q507 {
    //    507. 完美数
    public static void main(String[] args) {

    }
}

class Solution507 {
    //    简单模拟
    public boolean checkPerfectNumber(int num) {
        int res = 0;
        for (int i = 1; i < num / 2 + 1; i++) {
            if (num % i == 0) {
                res += i;
            }
        }
        return res == num;
    }

    //    查看大佬代码，时间复杂度更低
    public boolean checkPerfectNumber1(int num) {
        if (num == 1) return false;
        int ans = 1;
//        这里是防止使用sqr函数溢出
        for (int i = 2; i <= num / i; i++) {
            if (num % i == 0) {
                ans += i;
//                但是因为判断条件变成了sqr，所以要额外判断一下较大的正因子了
                if (i * i != num) ans += num / i;
            }
        }
        return ans == num;
    }

}