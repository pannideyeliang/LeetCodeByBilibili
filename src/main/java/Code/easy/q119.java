package Code.easy;

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

    //   因此我们可以倒着计算当前行，这样计算到第 i 项时，第 i−1 项仍然是上一行的值。
    public List<Integer> getRow1(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;

//        规律如下：
//        1
//        1  1
//        1  2  1
//        1  3  3  1
//        1  4  6  3  1
    }
}