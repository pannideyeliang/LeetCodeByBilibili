package Code.easy1;

import java.util.HashMap;

public class q383 {
    //383. 赎金信
    public static void main(String[] args) {

    }
}


class Solution383 {
    //    其实和求子串一样的
//    但是这样的效率极低
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            int count = map.getOrDefault(magazine.charAt(i), 0) + 1;
            map.put(magazine.charAt(i), count);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int count = map.getOrDefault(ransomNote.charAt(i), 0);
            if (count <= 0) return false;
            map.put(ransomNote.charAt(i), count - 1);
        }
        return true;
    }

    //    查看大佬代码，其实关于统计单个字符的个数的时候，使用数组会比map效率更高
    public boolean canConstruct1(String ransomNote, String magazine) {
        char[] map = new char[26];
        for (char c : magazine.toCharArray()) {
            map[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (map[c - 'a'] == 0) return false;
            map[c - 'a']--;
        }
        return true;
    }
}