package Code.middle;

import java.util.ArrayList;
import java.util.List;

public class q46 {
    //    46. 全排列
    public static void main(String[] args) {

    }
}


class Solution46 {

    //   标准的回溯法
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(path);
            return;
        }
        for (int i = 0; i < len; i++) {
//            使用如下方法，则不需要使用回溯，因为每次用来存储的变量都是最新的
            if (!used[i]) {
                List<Integer> newpath = new ArrayList<>(path);
                newpath.add(nums[i]);
                boolean[] newUsed = new boolean[len];
                System.arraycopy(used, 0, newUsed, 0, len);
                newUsed[i] = true;
                dfs(nums, len, depth+1, newpath, newUsed, res);
            }
        }
    }
}
