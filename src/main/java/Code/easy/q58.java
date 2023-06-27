package Code.easy;

public class q58 {
    //    58. 最后一个单词的长度
    public static void main(String[] args) {
        String s = "a ";
        System.out.println(new Solution58().lengthOfLastWord2(s));
    }
}

class Solution58 {
    //    方法调用堆砌的狗屎代码
    public int lengthOfLastWord(String s) {
        String temp = s.trim();
        StringBuilder sb = new StringBuilder(temp);
        StringBuilder reverse = sb.reverse();
        char[] chars = reverse.toString().toCharArray();
        int count = 0;
        for (char c : chars) {
            if (c == ' ') break;
            count++;
        }
        return count;
    }

    //    算法代码：自己写的，小狗屎代码
    public int lengthOfLastWord2(String s) {
//        if (s.length() == 1) return 1;
        int len = s.length(), count = 0;
        char[] chars = s.toCharArray();
        int index = len - 1;
        while (chars[index] == ' ') {
            index--;
        }
        while (index >= 0 && chars[index] != ' ') {
            index--;
            count++;
        }
        return count;
    }

//    大佬代码，和自己思路差不多
    public int lengthOfLastWord3(String s) {
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') end--;
        if(end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }

//    狗屎代码，别人的，开阔眼界
    public int lengthOfLastWord4(String s) {
        s = s.trim();
        int start = s.lastIndexOf(" ") + 1;
        return s.substring(start).length();
    }
}
