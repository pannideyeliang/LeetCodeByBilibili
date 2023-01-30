package day1;

import java.util.ArrayList;

public class q6 {
    //    6. Z 字形变换
    public static void main(String[] args) {
        String s = new Solution6().convert("PAYPALISHIRING", 3);
        System.out.println(s);
    }
}


class Solution6 {

    //        普通方法
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        char[] chars = s.toCharArray();

        ArrayList<StringBuilder> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            res.add(new StringBuilder(""));
        }
        int flag = 0;
        int index = 0;
        int leng = 0;
        while (leng < chars.length) {
            while (flag == 0) {
                res.get(index).append(chars[leng]);
                index++;
                leng++;
                if (leng == chars.length){
                    break;
                }
                if (index == numRows) {
                    index = index - 2;
                    flag = 1;
                }
            }

            while (flag == 1) {
                res.get(index).append(chars[leng]);
                index--;
                leng++;
                if (leng == chars.length){
                    break;
                }
                if (index == -1) {
                    index = index + 2;
                    flag = 0;
                }
            }
        }

        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            rs.append(res.get(i));
        }

        return rs.toString();
    }
}