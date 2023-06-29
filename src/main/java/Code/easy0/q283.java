package Code.easy0;

public class q283 {
    //    283. 移动零
    public static void main(String[] args) {

    }
}

class Solution283 {

    //    第一种方法，保持前不是0有序，后更改为0
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    //    大佬的写法， 根据快排的思想
    public void moveZeroes1(int[] nums) {
        int index = 0;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                temp = nums[i];
                nums[i] = nums[index];
                nums[index++] = temp;
            }
        }
    }
}