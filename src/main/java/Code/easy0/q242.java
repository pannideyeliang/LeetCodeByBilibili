package Code.easy0;

import java.util.HashMap;


public class q242 {
    //    242. 有效的字母异位词
    public static void main(String[] args) {

    }
}


class Solution242 {
    //    想法，可以通过hash表来解决，进行遍历
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> res = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!res.containsKey(s.charAt(i))) {
                res.put(s.charAt(i), 1);
            } else {
                res.put(s.charAt(i), res.get(s.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (!res.containsKey(t.charAt(i))) {
                return false;
            } else {
                res.put(t.charAt(i), res.get(t.charAt(i)) - 1);
            }
        }
        for (Integer i : res.values()) {
            if (i != 0) return false;
        }
        return true;
    }

    //    当然你也可以直接采用数组，效率更高
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] res = new int[26];
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            res[t.charAt(i) - 'a']--;
        }
//        但是其实上述两个步骤可以合成一个步骤
        for (int i = 0; i < 26; i++) {
            if (res[i] != 0) return false;
        }
        return true;
    }
}