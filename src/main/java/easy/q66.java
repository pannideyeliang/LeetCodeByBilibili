package easy;

public class q66 {
    //    66. 加一
    public static void main(String[] args) {

    }
}

class Solution {
    //    看了大神们的算法，下面这个思路非常简单
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i]!=9){
                digits[i]++;
                return digits;
            }else {
                digits[i] = 0;
            }
        }
        int res[] = new int[digits.length+1];
        res[0] = 1;
        return res;
    }
}
