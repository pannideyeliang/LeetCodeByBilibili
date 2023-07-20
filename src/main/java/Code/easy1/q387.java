package Code.easy1;

public class q387 {
    //    387. 字符串中的第一个唯一字符
    public static void main(String[] args) {

    }
}


class Solution387 {
    //    常规思路
//    一个数组记录记录每个字母的出现次数
//    一个数组记录每个字母的出现顺序
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        int[] order = new int[26];
        int count = 1;
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
            if (order[c - 'a'] == 0) {
                order[c - 'a'] = count;
                count++;
            }
        }
        int min = 27;
        int c = 0;
        for (int i = 0; i < 26; i++) {
            if (map[i] == 1) {
                if (min > order[i]) {
                    min = order[i];
                    c = i;
                }
            }
        }

        if (min == 27) return -1;
        return s.indexOf((char) ('a' + c));
    }

    //    查看大佬代码，储存在数组中，然后再遍历一次字符串既可
    public int firstUniqChar1(String s) {
        int[] arr = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i)-'a']++ ;
        }
        for (int i = 0; i < n; i++) {
            if (arr[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}