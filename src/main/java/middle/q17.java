package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class q17 {
    //    17. 电话号码的字母组合
    public static void main(String[] args) {

    }
}

class Solution17 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return null;
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "edf");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        ArrayList<String> res = new ArrayList<>();
        char[] chars = digits.toCharArray();

        for (int i = 0; i < digits.length(); i++) {

        }
        return res;
    }
}


