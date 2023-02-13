package day2;

import javax.swing.*;
import java.util.HashMap;

public class q12 {

    //    12. 整数转罗马数字
    public static void main(String[] args) {
        System.out.println(new Solution12().intToRoman(256));
    }
}


class Solution12 {

    //    第一时间能想到的狗屎方法,采用模拟方法,参考大佬
    //    由于每一次都是从数字最大的位置进行匹配，所以我们很容易想到贪心算法
    public String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap<>();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                res.append(symbol);
            }
            if (num == 0) break;
        }

        return res.toString();
    }


//    还有一种办法，硬编码，因为数据总共大小也不超过4000，所以可以
//    列举出来千位的是多少，百位的数据是多少，十位个位同理
//    String[] thousands = {"", "M", "MM", "MMM"};
//    String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
//    String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
//    String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
//    然后采用取余的方式进行匹配


}
