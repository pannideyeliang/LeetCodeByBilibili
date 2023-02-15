package day2;

/**
 * @author 陈佳乐
 * @create 2023-02-15-10:36
 */
public class q14 {
    //    14. 最长公共前缀
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(new Solution14().longestCommonPrefix(strs));
    }
}

class Solution14 {
    //    第一时间能想到的狗屎代码
    public String longestCommonPrefix(String[] strs) {
        int minLen = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            if (minLen > strs[i].length()) minLen = strs[i].length();
        }
        int flag = 1;
        int index = 0;
        for (int i = 0; i < minLen; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) == strs[i].charAt(i)) {
                    index++;
                } else {
                    flag = 0;
                }
            }
            if (flag == 1) index++;
        }
        return strs[0].substring(0,index);
    }
}
