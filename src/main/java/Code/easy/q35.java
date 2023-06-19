package Code.easy;

public class q35 {
    //    35. 搜索插入位置
    public static void main(String[] args) {
        int[] nums = {1, 3};
        System.out.println(new Solution35().searchInsertv2(nums, 2));
    }
}

class Solution35 {
    //    假如不考虑算法的时间复杂度进行实现，就使用最简单的遍历
    public int searchInsert(int[] nums, int target) {
        if (target <= nums[0]) return 0;
        int index = 0;
        while (index < nums.length && nums[index] < target) {
            index++;
        }
//        其实满足这两个条件，直接返回index就好了
        return index;
    }

    //    下面我们看一下大神们的写法,二分查找
    public int searchInsertv2(int[] nums, int target) {
        int len = nums.length;
        // 特殊判断
        if (nums[len - 1] < target) {
            return len;
        }
        // 程序走到这里一定有 nums[len - 1] >= target，插入位置在区间 [0..len - 1]
        int left = 0;
        int right = len - 1;
        // 在区间 nums[left..right] 里查找第 1 个大于等于 target 的元素的下标
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 下一轮搜索的区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索的区间是 [left..mid]
                right = mid;
            }
        }
        return left;
    }

}
