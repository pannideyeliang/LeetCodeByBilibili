package day2;

import javax.sound.midi.SoundbankResource;

public class q13 {
    //    13. 罗马数字转整数
    public static void main(String[] args) {
        System.out.println(new Solution13().romanToInt("MCMXCIV"));
    }
}

class Solution13 {

    public int romanToInt(String s) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] gap = {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1};
        int res = 0;
        for (int i = 0; i < symbols.length; i++) {
            if (s.equals("")) break;
            System.out.println(res);
            System.out.println(s);
            while (s.substring(0, gap[i]).equals(symbols[i])) {
                res += values[i];
                if (s.equals(symbols[i])) return res;
                s = s.substring(gap[i]);
            }
        }
        return res;
    }
}
