package Code.middle;


public class q45 {
    //    45. 跳跃游戏 II
    public static void main(String[] args) {

    }
}


class Solution45 {
    //    注意是一定可以跳到的  生成的测试用例可以到达 nums[n - 1]。
//    有问题的狗屎代码
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;

//        dpi表示跳到i需要的步数
        int[] dp = new int[nums.length];
        dp[0] = 1;
//        需要一个max来记录当前能跳到的最远距离
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < i + nums[i]) {
                dp[i] = dp[i - 1] + 1;
                max = i + nums[i];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[nums.length - 1];
    }

    //    方法一：反向查找出发位置, 效率比较低
    public int jump1(int[] nums) {
        int index = nums.length - 1;
        int steps = 0;
        while (index > 0) {
            for (int i = 0; i < index; i++) {
                if (i + nums[i] >= index) {
                    index = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    //    方法二：正向查找可到达的最大位置
    public int jump2(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
