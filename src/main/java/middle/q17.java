package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q17 {
    //    17. 电话号码的字母组合
    public static void main(String[] args) {

    }
}

class Solution17 {

    //    不会，抄袭大佬们的代码, 使用一个成员变量来存储原始数据
    String[] map = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    //    使用一个成员变量存储结果
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
//        开始递归
//        index 是为了提高效率
        iterStr(digits, new StringBuilder(), 0);
        return res;
    }

    void iterStr(String str, StringBuilder letter, int index) {
//        递归的终止条件,其实也就是当递归到底的时候，才加到res中去
        if (index == str.length()) {
            res.add(letter.toString());
            return;
        }

//        在不终止的时候
        char c = str.charAt(index);
//        pos表示当前数字是多少
        int pos = c - '0';
//        遍历得到的字符串
        String temp = map[pos];
        for (int i = 0; i < temp.length(); i++) {
//            由于这里使用了StringBuilder，所以字符串拼接效率比较高
            letter.append(temp.charAt(i));
            iterStr(str, letter, index + 1);
            letter.deleteCharAt(letter.length() - 1);
        }
    }
}


