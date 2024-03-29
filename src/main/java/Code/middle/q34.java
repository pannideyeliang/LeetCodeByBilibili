package Code.middle;

public class q34 {
    //    34. 在排序数组中查找元素的第一个和最后一个位置
    public static void main(String[] args) {
        int[] t = new int[]{1, 4};
        int[] ints = new Solution34().searchRange(t, 4);

    }
}


class Solution34 {
    //    简单的二分查找加遍历
//    逻辑写的狗屎一样，但是可以过
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 1 && nums[0] != target) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1 && nums[0] == target) {
            return new int[]{0, 0};
        }
        int left = 0, right = nums.length - 1;
        int mid = left + (right - left) / 2;
        int resl = -1, resr = -1;
        while (left <= right) {
            if (nums[mid] == target) {
                resl = mid;
                resr = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
                mid = left + (right - left) / 2;
            } else {
                left = mid + 1;
                mid = left + (right - left) / 2;
            }
        }
        while (resl != -1 && resl >= 0 && nums[resl] == target) {
            resl--;
        }
        while (resr != -1 && resr < nums.length && nums[resr] == target) {
            resr++;
        }
        if (resl != -1 || resr != -1) {
            return new int[]{++resl, --resr};
        }
        return new int[]{-1, -1};
    }

    // 查看大佬的代码，更简洁的方法
//    其实是寻找
    public int[] searchRange1(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}