package day2;



public class q13 {
    //    13. 罗马数字转整数
    public static void main(String[] args) {
        System.out.println(new Solution13().romanToIntV2("MDCXCV"));
    }
}

class Solution13 {

    //    自己写的狗屎代码，效率低下，不过也是一种贪心的思想
    public int romanToInt(String s) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] gap = {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1};
        int res = 0;
        for (int i = 0; i < symbols.length; i++) {
            if (s.equals("")) break;
            while (true) {
//            下面这个是为了修改掉 当 s = "I"  ， 即一个字符时，是不可以进行substring的，会报错
                if (s.length() == 1 && !s.equals(symbols[i])) break;
                if (s.equals(symbols[i]) || s.substring(0, gap[i]).equals(symbols[i])) {
                    res += values[i];
                    if (s.equals(symbols[i])) return res;
                    s = s.substring(gap[i]);
                } else {
                    break;
                }
            }
        }
        return res;
    }

    //    大佬们写的方法
//    把一个小值放在大值的左边，就是做减法，否则为加法。          -- 核心思想
//    需要注意的是，在小数据量的时候， switch 语句要比 hashmap 要快很多, 内存也要小很多。下面可以进行测试。
//    switch方法
    public int romanToIntV2(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (getNum(chars[i]) >= getNum(chars[i + 1])) {
                res += getNum(chars[i]);
            }else {
                res -= getNum(chars[i]);
            }
        }
        return res+getNum(chars[chars.length-1]);
    }

    public int getNum(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }


    //    秀儿方法, 通过转换的方式， 把不好统一处理的case，通过替换都转为一种情况
    public int romanToIntV3(String s) {
        s = s.replace("IV","a");
        s = s.replace("IX","b");
        s = s.replace("XL","c");
        s = s.replace("XC","d");
        s = s.replace("CD","e");
        s = s.replace("CM","f");

        int result = 0;
        for (int i=0; i<s.length(); i++) {
            result += which(s.charAt(i));
        }
        return result;
    }

    public int which(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            case 'a': return 4;
            case 'b': return 9;
            case 'c': return 40;
            case 'd': return 90;
            case 'e': return 400;
            case 'f': return 900;
        }
        return 0;
    }
}
