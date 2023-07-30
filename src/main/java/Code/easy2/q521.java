package Code.easy2;

public class q521 {
    //    521. 最长特殊序列 Ⅰ
    public static void main(String[] args) {

    }
}


class Solution521 {
    // 傻逼玩意，实际上是一题脑筋急转弯
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}