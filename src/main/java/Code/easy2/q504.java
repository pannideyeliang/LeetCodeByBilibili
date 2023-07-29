package Code.easy2;

public class q504 {
    //    504. 七进制数
    public static void main(String[] args) {

    }
}


class Solution504 {
    //    简单的模拟
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder res = new StringBuilder();
        int flag = 0;
        if (num < 0) {
            num = -num;
            flag = 1;
        }
        while (num != 0) {
            res.append(num % 7);
            num = num / 7;
        }
        if (flag == 1) {
            res.append('-');
        }
        return res.reverse().toString();
    }
}