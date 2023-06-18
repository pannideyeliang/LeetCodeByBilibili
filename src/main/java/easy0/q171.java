package easy0;

public class q171 {
    //    171. Excel 表列序号
    public static void main(String[] args) {

    }
}


class Solution171 {
    //    一样的进制转换问题
    public int titleToNumber(String columnTitle) {
        int len = columnTitle.length();
        int res = 0, temp;
        for (int i = len - 1; i >= 0; i--) {
            res += (int) (((columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, len - i - 1)));
        }
        return res;
    }
}