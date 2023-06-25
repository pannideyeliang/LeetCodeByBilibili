package Code.easy0;

import java.util.ArrayList;
import java.util.List;

public class q228 {
    //    228. 汇总区间
    public static void main(String[] args) {

    }
}


class Solution228 {
    //    注意条件，升序
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> res = new ArrayList<>();
        if (nums.length == 0) return res;

        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[start] + i - start) {
                continue;
            } else {
                if (i - start == 1) {
                    res.add(String.valueOf(nums[i]));
                } else {
                    res.add(start + "->" + (i - 1));
                    start = i;
                }
            }
        }
        return res;
    }
}