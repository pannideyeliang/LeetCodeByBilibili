package Code.easy1;

public class q434 {
    //    434. 字符串中的单词数
    public static void main(String[] args) {

        String s = ", , , ,        a, eaefa";
        String[] s1 = s.split(" ");
        for(String t:s1){
            System.out.println(t);
        }

    }
}

class Solution434 {
    //    实际上是统计特殊字符的个数
//    这里的单词是指连续的不是空格的字符
    public int countSegments(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] s1 = s.split(" ");
        int count = 0;
        for (String t : s1) {
            if (!t.equals("")) count++;
        }
        return count;
    }
}