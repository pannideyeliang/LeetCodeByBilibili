package day2;

/**
 * @author 陈佳乐
 * @create 2023-02-10-16:42
 */
public class q11 {
    //    11. 盛最多水的容器
    public static void main(String[] args) {
        int[] data = new int[]{1, 1};
        System.out.println(new Solution11().maxAreaV2(data));
    }
}

class Solution11 {

    //    垃圾双重for循环，超出时间限制
    public int maxArea(int[] height) {
        int max = 0;
        int width = 1;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                width = Math.min(height[i], height[j]);
                max = Math.max(max, width * (j - i));
            }
        }
        return max;
    }

    //    优化
    public int maxAreaV2(int[] height) {
        int max = 0;
        int width = 1;
        for (int i = 0; i < height.length - 1; i++) {

        }
        return max;
    }

}