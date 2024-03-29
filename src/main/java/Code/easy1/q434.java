package Code.easy1;

public class q434 {
    //    434. 字符串中的单词数
    public static void main(String[] args) {

        String s = ", , , ,        a, eaefa";
        String[] s1 = s.split(" ");
        for (String t : s1) {
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

    //    大佬代码，一次遍历
    public int countSegments1(String s) {
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; ) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            while (i < n && s.charAt(i) != ' ') i++;
            res++;
        }
        return res;
    }
//    也可以在s前面加一个“ ”，然后判断如果是 “ x”的形式则就是一个单词
}