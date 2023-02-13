package day2;

/**
 * @author 陈佳乐
 * @create 2023-02-10-16:42
 */
public class q11 {
    //    11. 盛最多水的容器
    public static void main(String[] args) {
        int[] data = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Solution11().maxAreaV3(data));
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

    //    优化失败，还是超出时间限制
    public int maxAreaV2(int[] height) {
        int max = 0;
        int maxHeight = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] >= height[i]) {
                    max = Math.max(max, height[i] * (j - i));
                } else {
                    maxHeight = Math.min(height[i], height[j]);
                    max = Math.max(max, maxHeight * (j - i));
                }
            }
        }
        return max;
    }

    //    查看大佬们的代码, 采用双指针方法，从两边开始移动，长板向内移动，面积一定减小，短板向内移动，面积不一定减小,所以每次只要
//    考虑让短的移动就好了
    public int maxAreaV3(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
//            每次只移动短板的情况，直至遍历所有
            max = height[left] < height[right] ?
                    Math.max(max, (right- left)*height[left++]):Math.max(max, (right- left)*height[right--]);
        }
        return max;
    }
}