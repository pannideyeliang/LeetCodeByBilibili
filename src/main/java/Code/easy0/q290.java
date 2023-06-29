package Code.easy0;

import java.util.HashMap;
import java.util.Map;

public class q290 {
    //    290. 单词规律
    public static void main(String[] args) {
        String s1 = "abba";
        String s2 = "dog dog dog dog";
        new Solution290().wordPattern(s1, s2);
    }
}


class Solution290 {
    //    由于还是需要向前看，所以不可以使用递归的方法
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] temp = s.split(" ");
        if (pattern.length() != temp.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
//            这样才认为是全新的匹配关系，否则可能就是错误的，需要判断
            if (!map.containsKey(pattern.charAt(i)) && !map.containsValue(temp[i])) {
                map.put(pattern.charAt(i), temp[i]);
            } else if (!map.containsKey(pattern.charAt(i)) && map.containsValue(temp[i])) {
                return false;
            } else {
                if (!map.get(pattern.charAt(i)).equals(temp[i])) return false;
            }
        }
        return true;
    }

    //    查看大佬们的写法
    public boolean wordPattern1(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<Object, Integer> map = new HashMap<>();
        for (Integer i = 0; i < words.length; i++) {
            if (map.put(pattern.charAt(i), i) != map.put(words[i], i)) {
                return false;
            }
        }
        return true;
    }
}