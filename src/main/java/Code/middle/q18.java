package Code.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q18 {
    //    18. 四数之和
    public static void main(String[] args) {

    }
}


class Solution18 {
    //    思路同三数之和
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
//        先排序
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int p = j + 1;
                int q = len - 1;
                while (p < q) {
//                    使用long防止溢出
                    long sum = (long) nums[i] + nums[j] + nums[p] + nums[q];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));

//                        同时还是要跳过重复数据
                        while (p < q && nums[p + 1] == nums[p]) {
                            p++;
                        }
                        while (p < q && nums[q - 1] == nums[q]) {
                            q--;
                        }
                        p++;
                        q--;
                    } else if (sum < target) {
                        p++;
                    } else {
                        q--;
                    }
                }

            }
        }
        return res;
    }
}
