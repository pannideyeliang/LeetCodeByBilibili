package Code.easy1;

public class q303 {
    //303. 区域和检索 - 数组不可变
    public static void main(String[] args) {

    }
}


class NumArray {

    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    //    暴力法
    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i < right + 1; i++) {
            sum += nums[i];
        }
        return sum;
    }
}

// 使用前缀和进行优化
// 其实就是提前计算好了
class NumArray1 {
    private int[] sum;

    public NumArray1(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; ++i) sum[i] = sum[i - 1] + nums[i - 1];
    }

    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }
}