package Code.easy1;

import java.util.Arrays;

public class q455 {
    //    455. 分发饼干
    public static void main(String[] args) {

    }
}


class Solution455 {
    //    排序加双指针
//    效率一般
//    看看有没有更好的方法
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) return 0;
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int indexG = 0, indexS = 0;
        while (indexG < g.length && indexS < s.length) {
            if (g[indexG] <= s[indexS]) {
                res++;
                indexG++;
                indexS++;
            } else {
                indexS++;
            }
        }
        return res;
    }

}