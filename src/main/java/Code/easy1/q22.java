package Code.easy1;

import java.util.ArrayList;
import java.util.List;

public class q22 {
    //    22. 括号生成
    public static void main(String[] args) {

    }
}


class Solution22 {
    //    枚举显然是比较复杂的，我们可以使用动态规划
//    想法没问题，但是没写出来，java基础不太好
    public List<String> generateParenthesis(int n) {
        List<ArrayList<String>> dp = new ArrayList<>();
        if (n == 1) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add("()");
            dp.add(0, temp);
        } else {
            for (int i = 1; i < n; i++) {
                ArrayList<String> temp = new ArrayList<>();
                for (String s : dp.get(i - 1)) {
                    if ((s + "()").equals("()" + s)) {
                        temp.add(s + "()");
                    } else {
                        temp.add(s + "()");
                        temp.add("()" + s);
                    }
                    temp.add("(" + s + ")");
                }
                dp.add(i, temp);
            }
        }
        return dp.get(n - 1);
    }

    //  看一下大佬的代码，深度优先遍历
    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        dfs("", n, n, res);
        return res;
    }

    // left 和 right分别表示 左右两边括号的数量
    private void dfs(String curStr, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }
//        剪枝
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }
        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }

    //  看一下大佬的代码，广度优先遍历
    public List<String> generateParenthesis2(int n) {
//        先看懂深度优先遍历再说
        return null;
    }
}