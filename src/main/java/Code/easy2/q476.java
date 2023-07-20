package Code.easy2;

/**
 * @author 陈佳乐
 * @create 2023-07-20-21:54
 */
public class q476 {
    //    476. 数字的补数
    public static void main(String[] args) {

    }
}


class Solution476 {
    //    java中没有同或运算符
    public int findComplement(int num) {
//        所以只能用最朴素的办法了
        String string = Integer.toString(num, 2);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '0') {
                res.append("1");
            } else {
                res.append("0");
            }
        }
        return Integer.parseInt(res.toString(), 2);
    }

    //    大佬做法
    public int findComplement1(int num) {
//        找到最高位
        int s = -1;
        for (int i = 31; i >= 0; i--) {
            if (((num >> i) & 1) != 0) {
                s = i;
                break;
            }
        }
        int ans = 0;
        for (int i = 0; i < s; i++) {
            if (((num >> i) & 1) == 0) ans |= (1 << i);
        }
        return ans;
//   以下方法更简便
//        int x = 0;
//        for (int i = num; i != 0; i -= i & -i) x = i;
//        return ~num & (x - 1);

    }

//    大佬解法三 ，找到比num大的最近的一个2的幂，然后减一异或   11111111111
    public int findComplement2(int num) {
        long t = 1;  //t为比num大且最近的2的幂
        while (t <= num) {
            t <<= 1;
        }
        return (int) (num ^ (t-1));
    }

}