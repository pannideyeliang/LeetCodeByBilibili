package easy;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class q26 {
    //    26. 删除有序数组中的重复项
    public static void main(String[] args) {

    }
}

class Solution26 {
//    参考大佬的答案
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while(q < nums.length){
            if(nums[p] != nums[q]){
                if(q - p > 1){
                    nums[p + 1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
    }
}
