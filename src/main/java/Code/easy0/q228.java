package Code.easy0;

import java.util.ArrayList;
import java.util.List;

public class q228 {
    //    228. 汇总区间
    public static void main(String[] args) {
        int num[] = new int[]{0, 1, 2, 4, 5, 7};
        new Solution228().summaryRanges(num);

    }
}


class Solution228 {
    //    注意条件，升序
//    有点问题，代码
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        if (nums.length == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }

        int start = 0, index = 1;

        while (index < nums.length) {
            while (nums[index] - nums[index - 1] == 1) {
                index++;
            }
            if (start == index - 1) {
                res.add(String.valueOf(nums[start]));
                start = index;
            } else {
                res.add(nums[start] + "->" + nums[index - 1]);
                start = index;
            }
            index++;
        }
        if (index - start == 1) res.add(String.valueOf(nums[start]));
        return res;
    }

    //    直接查看大佬的代码，双指针
    public List<String> summaryRanges1(int[] nums) {
        ArrayList<String> res = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] - nums[i - 1] == 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            res.add(temp.toString());
        }
        return res;
    }
}