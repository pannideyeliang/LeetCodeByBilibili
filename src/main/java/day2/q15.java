package day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 陈佳乐
 * @create 2023-02-21-15:31
 */
public class q15 {
    //    15. 三数之和
    public static void main(String[] args) {
        int[] ints = new int[]{-1,1,0,-2,1,1};
        List<List<Integer>> lists = new Solution15().threeSum(ints);
        System.out.println(lists);
    }
}

class Solution15 {

    //    常规做法，双指针，先排序，在前后一起走判断，需要注意的是判断重复
//    且要注意把三数之和转换为两数之和
//    没写完，只能跑通一部分案例的垃圾代码
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        下面这种情况直接返回
        if (nums == null || nums.length < 3) return res;
//        进行排序
        Arrays.sort(nums);
//        初始化游标的三个参数
        int index, left, right;
        left = 1;
        right = nums.length - 1;
        index = 0;
        while (nums[index] <= 0 && index <= nums.length - 3) {
            if (nums[index] + nums[left] + nums[right] == 0 && left < right) {
                ArrayList<Integer> list = new ArrayList<Integer>() {
                };
//                加入进去
                list.add(nums[index]);
                list.add(nums[left]);
                list.add(nums[right]);
                res.add(list);
                index++;

                left = index + 1;
                right = nums.length - 1;
//                下面进行去重
                for (int i = left + 1; i <= right; i++) {
                    if (nums[left] == nums[i]) {
                        left = i;
                    }
                }

                for (int i = right - 1; i >= left; i--) {
                    if (nums[right] == nums[i]) {
                        right = i;
                    }
                }
            } else if (nums[index] + nums[left] + nums[right] < 0) {
                left++;
                if (left == right) {
                    index++;
                    left = index + 1;
                    break;
                }
            } else if (nums[index] + nums[left] + nums[right] > 0) {
                right--;
                if (left == right) {
                    index++;
                    right = nums.length - 1;
                    break;
                }
            } else {
                index++;
            }
        }

        return res;
    }
}
