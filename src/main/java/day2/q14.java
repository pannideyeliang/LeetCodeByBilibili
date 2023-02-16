package day2;


/**
 * @author 陈佳乐
 * @create 2023-02-15-10:36
 */
public class q14 {
    //    14. 最长公共前缀
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(new Solution14().longestCommonPrefix(strs));
//        System.out.println(new Solution14().longestCommonPrefix("dasda",""));

    }

}

class Solution14 {
    //    第一时间能想到的狗屎代码, 纵向扫描
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
//            不需要找最短的字符串，直接找第一个字符串作为参考就好
            char c = strs[0].charAt(i);
//            直接从第二个字符串进行比较就好了
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    //    横向扫描，两个字符换两个字符串直接比较
    public String longestCommonPrefixV2(String[] strs) {
        if (strs == null || strs.length == 0) return "";

//        每次都寻找两个字符串之间的最大公共前缀
        String prefix = strs[0];
        int count = strs.length;
//        同上，以第一个为参照物，从第二个开始不断寻找最大的前缀
        for (int i = 1; i < count; i++) {

        }
        return "";
    }

//    寻找两个字符串之间的最大公共前缀
    public String longestCommonPrefix(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            if (i == str2.length()||str1.charAt(i)!=str2.charAt(i)){
                return str1.substring(0,i);
            }
        }
        return str1;
    }
}
