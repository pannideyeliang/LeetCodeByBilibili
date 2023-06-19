package Code.day1;

/**
 * @author 陈佳乐
 * @create 2022-12-30-13:55
 */
public class q4 {
    //    4. 寻找两个正序数组的中位数
    public static void main(String[] args) {
        new Solution4().findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0});
    }
}

class Solution4 {
    //    普通方法，合并数组并求出其中位数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int merLen = nums1.length + nums2.length;
        int[] mergin = new int[merLen];
        int count1 = 0, count2 = 0, count = 0;
        while (count1 < nums1.length && count2 < nums2.length) {
            if (nums1[count1] < nums2[count2]) {
                mergin[count] = nums1[count1];
                count++;
                count1++;
            } else {
                mergin[count] = nums2[count2];
                count++;
                count2++;
            }
        }
        while (count2 != nums2.length) {
            mergin[count] = nums2[count2];
            count++;
            count2++;
        }
        while (count1 != nums1.length) {
            mergin[count] = nums1[count1];
            count++;
            count1++;
        }
        if (merLen % 2 == 0) {
            return (float) (mergin[merLen / 2] + mergin[merLen / 2 - 1]) / 2;
        }
        return mergin[merLen / 2];
    }

    //   采用第二种方法，我们只需要知道中位数是多少，并不需要合并两个数组
    public double findMedianSortedArraysV2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int length = m + n;
        int left, right, countm = 0, countn = 0, count = 0;
        while (count <= length / 2 - 1) {
            if (nums1[countm] < nums2[countn]) {
                left = nums1[countm];
                countm++;
            } else {
                left = nums2[countn];
                countn++;
            }
            count++;
        }
        return 0;
    }
}
