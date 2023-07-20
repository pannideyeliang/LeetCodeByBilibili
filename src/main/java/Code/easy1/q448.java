package Code.easy1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class q448 {
    //    448. 找到所有数组中消失的数字
    public static void main(String[] args) {

    }
}


class Solution448 {
    //    无脑做法
    public List<Integer> findDisappearedNumbers(int[] nums) {
//        使用hash表时间复杂度比较低
//        但是使用数组的话时间复杂度更低
        int[] map = new int[nums.length + 1];
        for (int i : nums) {
            map[i] = 1;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i < map.length; i++) {
            if (map[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }

    //大佬做法
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        return null;
    }
}