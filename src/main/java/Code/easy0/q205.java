package Code.easy0;

import java.util.HashMap;

public class q205 {
    //    205. 同构字符串
    public static void main(String[] args) {

    }
}

class Solution205 {

    //    第一时间想到的是标准的hashmap, 但是这个映射关系其实是双向的，需要两个hashmap或者额外的判断
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        return isIsomorphicByFix(s, t) && isIsomorphicByFix(t, s);
    }

    public boolean isIsomorphicByFix(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap<>();
        int index = 0;
        while (index < s.length()) {
            if (!map.containsKey(s.charAt(index))) {
                map.put(s.charAt(index), t.charAt(index));
                index++;
            } else if (map.get(s.charAt(index)) != t.charAt(index)) {
                return false;
            } else {
                index++;
            }

//            上述代码可以简化如下：
//            char c1 = s.charAt(i);
//            char c2 = t.charAt(i);
//            if (map.containsKey(c1)) {
//                if (map.get(c1) != c2) {
//                    return false;
//                }
//            } else {
//                map.put(c1, c2);
//            }
        }
        return true;
    }

    //    大佬算法， 使用第三方做中介
    public boolean isIsomorphic1(String s, String t) {
        int n = s.length();
        int[] mapS = new int[128];
        int[] mapT = new int[128];
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            //当前的映射值是否相同
            if (mapS[c1] != mapT[c2]) {
                return false;
            } else {
                //是否已经修改过，修改过就不需要再处理
                if (mapS[c1] == 0) {
                    mapS[c1] = i + 1;
                    mapT[c2] = i + 1;
                }
            }
        }
        return true;
    }
}