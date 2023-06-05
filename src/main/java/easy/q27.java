package easy;

public class q27 {
    //    27. 移除元素
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int i = new Solution27().removeElement(nums, 3);
        System.out.println(i);
        System.out.println("------------------------");
        for(int k:nums){
            System.out.println(k);
        }
    }
}

class Solution27 {
    //    采用双指针的方式，和q26的思想类似，
//    一个指针遍历全部，一个指针记录需要的数组中的数据
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length < 1) return 0;
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) nums[p++] = nums[i];
        }
        return p;
    }

//    大佬们更简洁的写法
    public int removeElement2(int[] nums, int val) {
//就是我的写法
        return 0;
    }
}

