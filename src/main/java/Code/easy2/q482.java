package Code.easy2;

public class q482 {
    //    482. 密钥格式化
    public static void main(String[] args) {
        String s = "2-5g-3-J";
        new Solution482().licenseKeyFormatting1(s, 2);
    }
}

class Solution482 {

    //    朴实无华的方法,
//    时间复杂度还行，内存占用比较多
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '-') {
                tmp.append(Character.toUpperCase(s.charAt(i)));
            }
        }
        if (tmp.toString().equals("")) return "";
        int step = tmp.length() % k == 0 ? k : tmp.length() % k;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < step; i++) {
            res.append(tmp.charAt(i));
        }
        if (step == tmp.length()) {
            return res.toString();
        }
        res.append('-');
        int count = 0;
        while (step < tmp.length()) {
            res.append(tmp.charAt(step));
            count++;
            if (count == k && step < tmp.length() - 1) {
                res.append('-');
                count = 0;
            }
            step++;
        }
//        System.out.println(res.toString());
        return res.toString();
    }

    //    查看大佬代码，
//    从后往前处理，就可以避免最开始一段判断，非常的简单
    public String licenseKeyFormatting1(String s, int k) {
        StringBuilder res = new StringBuilder();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                count++;
//                一种思想，排到第k个现不加，等发现k+1再加 -
                if (count == k+1) {
                    count = 1;
                    res.append('-');
                }
                res.append(Character.toUpperCase(s.charAt(i)));
            }
        }
//        System.out.println(res.reverse().toString());
        return res.reverse().toString();
    }
}
