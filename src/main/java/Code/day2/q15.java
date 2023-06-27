package Code.day2;

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
        int[] ints = new int[]{-1, 1, 0, -2, 1, 1};
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

    //    跟随大佬的脚步，大佬们的写法
//    思想同上，但是代码优化
    public List<List<Integer>> threeSumV2(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        int len = nums.length;
        if (nums == null || len < 3) return res;

//        将数组进行排序
        Arrays.sort(nums);
//        遍历数组中的每一个元素
        for (int i = 0; i < len; i++) {
//            因为是排序好的，所以如果遍历到的元素已经大于0了的
//            话，就直接退出就好了
            if (nums[i] > 0) break;
//            去重，当起始的值等于前一个元素，那么得到的结果就会和前一次相同
            if (i > 0 && nums[i] == nums[i - 1]) continue;
//            开始进行双指针判定
            int l = i + 1;
            int r = len - 1;
//            当   l 不等于  r  的时候就继续遍历
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
//                    同样进行去重，
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
//                    去重过后将左指针右移，右指针左移
//                    这种情况是让原来的被使用的 l 和 r 不会再被使用
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                }
            }
        }
        return res;
    }
}
