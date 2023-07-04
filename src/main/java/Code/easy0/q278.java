package Code.easy0;

public class q278 {
    //    278. 第一个错误的版本
    public static void main(String[] args) {

    }
}


/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

class Solution278 extends VersionControl {
    //    直接二分查找
    public int firstBadVersion(int n) {
        return firstBadVersion(1, n);
    }

    public int firstBadVersion(int left, int right) {
        if (left == right) return left;
        int mid = left + (right - left) / 2;
        if (isBadVersion(mid)) {
            return firstBadVersion(left, mid);
        } else {
            return firstBadVersion(mid + 1, right);
        }

    }

    boolean isBadVersion(int version) {
        return true;
    }

    //    大佬的二分查找，其实不需要使用递归，这样时间复杂度更低一些
    public int firstBadVersion1(int n) {
        int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (isBadVersion(mid)) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }

}

class VersionControl {

}