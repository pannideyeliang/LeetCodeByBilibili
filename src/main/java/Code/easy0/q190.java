package Code.easy0;

public class q190 {
    //    190. 颠倒二进制位
    public static void main(String[] args) {
        System.out.println(new Solution190().reverseBits(43261596));
    }
}


class Solution190 {
    // you need treat n as an unsigned value
//    朴实无华调用API
    public int reverseBits(int n) {
//        该API的作用如下：
//        输入   43261596       对应二进制为   00000010100101000001111010011100
//        输出   964176192      对应二进制为   00111001011110000010100101000000   （实际是翻转后的）
        return Integer.reverse(n);
    }
}