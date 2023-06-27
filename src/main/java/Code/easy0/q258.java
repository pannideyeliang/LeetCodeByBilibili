package Code.easy0;

public class q258 {
    //    258. 各位相加
    public static void main(String[] args) {

    }
}


class Solution258 {
    //    显然递归
    public int addDigits(int num) {
        if (num < 10) return num;
        int temp = 0;
        while (num != 0) {
            temp += num % 10;
            num = num / 10;
        }
        return addDigits(temp);
    }

//    数学上其实是如下
    public int addDigits1(int num) {
        return (num - 1) % 9 + 1;
    }
}