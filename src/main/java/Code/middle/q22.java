package Code.middle;

import java.util.ArrayList;
import java.util.List;

public class q22 {
//   22. 括号生成 , 注意剪枝

    public static void main(String[] args) {

    }
}

class Solution22 {

    //    存储结果
//    注意剪枝
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) return res;
        dfs("", n, n);
        return res;
    }

    private void dfs(String s, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(s + "(", left - 1, right);
        }
        if (right > 0) {
            dfs(s + ")", left, right - 1);
        }
    }
}