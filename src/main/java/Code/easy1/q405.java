package Code.easy1;

public class q405 {
    //    405. 数字转换为十六进制数
    public static void main(String[] args) {

    }
}

class Solution405 {
    //    简单的模拟
    public String toHex(int num) {
        return Integer.toHexString(num);
    }

    //    查看大佬代码之1，模拟
//    对于负数的处理要知道
    public String toHex1(int num) {
        if (num == 0) return "0";
        long numL = num;
        StringBuilder sb = new StringBuilder();
//        如果是负数的话要加上偏移量再进制转换
        if (numL < 0) numL = (long) (Math.pow(2, 32) + numL);
        while (numL != 0) {
            long temp = numL % 16;
            char c = (char) (temp + '0');
            if (temp >= 10) c = (char) (temp - 10 + 'a');
            sb.append(c);
            numL /= 16;
        }
        return sb.reverse().toString();
    }

    //    大佬代码2，位运算
    public String toHex2(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int temp = num & 15;
//            取后四位嘛
            char c = (char) (temp + '0');
            if (temp >= 10) c = (char) (temp - 10 + 'a');
            sb.append(c);
//            无符号右移
            num >>>= 4;
        }
        return sb.reverse().toString();
    }


}
