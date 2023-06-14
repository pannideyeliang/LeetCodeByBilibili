package easy;

import java.util.ArrayList;
import java.util.List;

public class q119 {
    //    119. 杨辉三角 II
    public static void main(String[] args) {

    }
}


class Solution119 {

    //    h和118题一样，非常朴实无华的模拟方法
    public List<Integer> getRow(int rowIndex) {
//        非常朴实的模拟方法
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
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

        return res.get(rowIndex);
    }
}