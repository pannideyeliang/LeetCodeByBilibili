package Code.day1;


/**
 * @author 陈佳乐
 * @create 2023-02-03-14:41
 */
public class q9 {

    //    9. 回文数
    public static void main(String[] args) {
        System.out.println(new Solution9().isPalindromeV3(121));
    }
}


class Solution9 {
    //    最简单的方式，转换为字符串，使用字符串反转
    public boolean isPalindrome(int x) {
        StringBuilder rev = new StringBuilder();
        rev.append(Integer.toString(x));
//        System.out.println(Integer.toString(x));
//        System.out.println(rev.reverse().toString());
        return Integer.toString(x).equals(rev.reverse().toString());
    }

    //    不适用字符串的方式, 和之前找最长回文子串的思想一样的,从中心发散去找
    public boolean isPalindromeV2(int x) {
        char[] chars = Integer.toString(x).toCharArray();
        if (chars[0] == '-' || chars[0] == '+') return false;
        int left, right;
        int length = chars.length;
        boolean flag = true;
        if (length % 2 == 0) {
            right = length / 2;
            left = length / 2 - 1;
            while (left >= 0 && right <= length - 1) {
                if (chars[left] != chars[right]) {
                    flag = false;
                    break;
                }
                left--;
                right++;
            }
        } else {
            right = left = length / 2;
            while (left >= 0 && right <= length - 1) {
                if (chars[left] != chars[right]) {
                    flag = false;
                    break;
                }
                left--;
                right++;
            }
        }
        return flag;
    }

    //    毫无疑问，上面的写法有亿些冗余和丑陋，所以我参考一下大佬们的写法，
//    思想：反转一半数据，和前面一般数据作比较，这个效率会比较高，也可以选择直接反转全部数据，和原始数据作比较，这样代码简单一点
//    但是效率不是很高
    public boolean isPalindromeV3(int x) {
        if (x < 0) return false;
        int rev = 0, tmp,bef = x ;
        while (x != 0) {
            tmp = x % 10;
            x = x / 10;
            rev = rev * 10 + tmp;
        }
        return rev == bef;
    }
}