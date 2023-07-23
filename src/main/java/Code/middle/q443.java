package Code.middle;

public class q443 {
    //    443. 压缩字符串
    public static void main(String[] args) {

    }
}


class Solution443 {
    //    非常的简单，但是注意存储的东西比较多
//    直接模拟既可
//    能过，但不是就地逆转，时间空间复杂度都比较高
    public int compress(char[] chars) {
        StringBuilder res = new StringBuilder();
        res.append(chars[0]);
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                if (count == 1) {
                    res.append(chars[i]);
                } else {
                    res.append(count);
                    res.append(chars[i]);
                }
                count = 1;
            }
        }
        if (count != 1) {
            res.append(count);
        }
        char[] tmp = res.toString().toCharArray();
        for (int i = 0; i < res.length(); i++) {
            chars[i] = tmp[i];
        }
        return res.length();
    }
}