package Code.easy1;

public class q392 {
    //    392. 判断子序列
    public static void main(String[] args) {

    }
}


class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int indexs = 0, indext = 0;
        while (indexs < s.length() && indext < t.length()) {
            if (s.charAt(indexs) == t.charAt(indext)) {
                indexs++;
            }
            indext++;
        }
        return indexs == s.length();
    }
}