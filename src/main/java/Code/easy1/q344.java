package Code.easy1;

import java.util.Arrays;

public class q344 {
    //    344. 反转字符串
    public static void main(String[] args) {
        char[] res = {'h', 'a', 'n', 'n', 'a','H'};
        new Solution344().reverseString(res);
    }
}


class Solution344 {

    public void reverseString(char[] s) {
        char temp;
        int left = 0, right = s.length - 1;
        while (left <= right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}