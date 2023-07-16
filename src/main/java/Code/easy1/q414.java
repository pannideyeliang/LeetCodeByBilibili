package Code.easy1;

import java.util.*;

public class q414 {
    //    414. 第三大的数
    public static void main(String[] args) {
        int[] t = {3, 2, 1};
        int i = new Solution414().thirdMax(t);

    }
}

class Solution414 {
    //    解题快速版
    public int thirdMax(int[] nums) {
//        注意默认是从小到大,但是注意要去重
        Arrays.sort(nums);
//        使用count来进行表示第几大的数
        int count = 1, max = nums[nums.length - 1], res = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != res) {
                count++;
                res = nums[i];
            }
            if (count == 3) {
                return res;
            }
        }
        return max;
    }

    public int thirdMax1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list.size() < 3 ? list.get(list.size() - 1) : list.get(list.size() - 3);
    }


    //    纯算法版
//    储存罢了
    long INF = (long) -1e18;

    public int thirdMax2(int[] nums) {
        long a = INF, b = INF, c = INF;
        for (int x : nums) {
            if (x > a) {
                c = b;
                b = a;
                a = x;
            } else if (x < a && x > b) {
                c = b;
                b = x;
            } else if (x < b && x > c) {
                c = x;
            }
        }
        return c != INF ? (int) c : (int) a;
    }


}