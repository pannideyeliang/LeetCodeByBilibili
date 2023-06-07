package easy;

import java.util.ArrayList;
import java.util.List;

public class q118 {
    //    动态规划 118. 杨辉三角
    public static void main(String[] args) {

    }
}

class Solution118 {
    public List<List<Integer>> generate(int numRows) {
//        非常朴实的模拟方法
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }

        return res;
    }
}
