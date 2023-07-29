package Code.easy2;

public class q520 {
    //    520. 检测大写字母
    public static void main(String[] args) {
        boolean s = new Solution520().detectCapitalUse("ffffffffffffffffffffF");
        System.out.println(s);
    }
}

class Solution520 {
    public boolean detectCapitalUse(String word) {
        if (word.equals(word.toLowerCase()) || word.equals(word.toUpperCase())) {
            return true;
        }

        if (Character.isUpperCase(word.charAt(0))) {
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
