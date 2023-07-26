package Code.easy2;

import java.util.ArrayList;

public class q500 {
    //    500. 键盘行
    public static void main(String[] args) {

    }
}


class Solution500 {
    //    标准打表
    public static int[] map = new int[26];

    static {
        String s1 = "qwertyuiop";
        String s2 = "asdfghjkl";
        String s3 = "zxcvbnm";
        for (char c : s1.toCharArray()) {
            map[c - 'a'] = 1;
        }
        for (char c : s2.toCharArray()) {
            map[c - 'a'] = 2;
        }
        for (char c : s3.toCharArray()) {
            map[c - 'a'] = 3;
        }
    }

    // 使用打表法
    public String[] findWords(String[] words) {
        ArrayList<String> res = new ArrayList<>();
        for (String s : words) {
            String s1 = s.toLowerCase();
            int flag = 0;
            int x = map[s1.charAt(0) - 'a'];
            for (char c : s1.toCharArray()) {
                if (map[c - 'a'] != x) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                res.add(s);
            }
        }
//        String[] s = new String[res.size()];
//        int index = 0;
//        for (String t : res) {
//            s[index++] = t;
//        }
//        下面是 arrayList 转为字符串数组的方法
        return res.toArray(new String[0]);

    }

    //    查看大佬代码
//    一样的打表分类，只不多代码更简洁
//    static String[] ss = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
//    static int[] hash = new int[26];
//    static {
//        for (int i = 0; i < ss.length; i++) {
//            for (char c : ss[i].toCharArray()) hash[c - 'a'] = i;
//        }
//    }

    public String[] findWords1(String[] words) {
        return null;
//        return list.toArray(new String[list.size()]);
    }
}