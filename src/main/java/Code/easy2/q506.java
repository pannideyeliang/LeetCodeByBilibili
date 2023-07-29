package Code.easy2;

import java.util.Arrays;
import java.util.HashMap;

public class q506 {
    //    506. 相对名次
    public static void main(String[] args) {

    }
}


class Solution506 {
    //    score 中的所有值 互不相同
//    利用以上条件，可以先进行排序，然后用一个map做登记
//    狗屎代码，能过就行
    public String[] findRelativeRanks(int[] score) {
        int[] tmp = score.clone();
        Arrays.sort(score);
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = score.length - 1; i >= 0; i--) {
            if (i == score.length - 1) {
                map.put(score[score.length - 1], "Gold Medal");
            } else if (i == score.length - 2) {
                map.put(score[score.length - 2], "Silver Medal");
            } else if (i == score.length - 3) {
                map.put(score[score.length - 3], "Bronze Medal");
            } else {
                map.put(score[i], String.valueOf(score.length - i));
            }
        }
        String[] res = new String[score.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = map.get(tmp[i]);
        }
        return res;
    }
}