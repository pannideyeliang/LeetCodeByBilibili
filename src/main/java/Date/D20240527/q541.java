package Date.D20240527;


/**
 * @author 陈佳乐
 * @create 2024-05-27-15:52
 * 541. 反转字符串 II
 */
public class q541 {
    //    给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
//如果剩余字符少于 k 个，则将剩余字符全部反转。
//如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
    public static void main(String[] args) {
        q541 q541 = new q541();
        String abcdefg = q541.reverseStr("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl", 39);
        System.out.println(abcdefg);
    }

    public String reverseStr(String s, int k) {
        int length = s.length();
        if (length <= k) {
            return new StringBuilder(s).reverse().toString();
        }
        char[] chars = s.toCharArray();
        char[] res = chars.clone();
        for (int i = 0; i < length; i++) {
            if ((i + 1) % k == 0 && (i + 1) / k % 2 != 0) {
                for (int j = i, q = i - k + 1; j >= i - k + 1; j--) {
                    res[q++] = chars[j];
                }
            }
        }
        return String.valueOf(res);
    }
}
