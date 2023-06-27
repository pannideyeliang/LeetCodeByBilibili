package Code.easy;


/**
 * @author 陈佳乐
 * @create 2023-06-15-21:38
 */
public class q125 {
    //    125. 验证回文串
    public static void main(String[] args) {
    }
}

class Solution125 {
    //    简单的思想，直接比较, 能过，但是狗屎代码
    public boolean isPalindrome(String s) {
        if (s.length() == 1) return true;
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
//            这里需要写一个判断字母数字的逻辑
//            数字0~9对应的ASCII码（十进制）为“48”~“57”
//            大写字母A~Z对应的ASCII码（十进制）为“65”~“90”
//            小写字母a~z对应的百ASCII码（十进制）为"97"~“122”
//            自己写就是傻逼，有函数可以直接调
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if (Character.isDigit(s.charAt(left)) && Character.isDigit(s.charAt(right))
                    && s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            }
            if (Character.isLetter(s.charAt(left)) && Character.isLetter(s.charAt(right))
                    && Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                left++;
                right--;
                continue;
            }
            return false;
        }
        return true;
    }

    //    大神代码，少了一个判断，因为toLowCase对数字字符也生效
    public boolean isPalindrome1(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}
