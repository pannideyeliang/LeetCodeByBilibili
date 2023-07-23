package Code.easy2;

public class q495 {
    //    495. 提莫攻击
    public static void main(String[] args) {

    }
}

class Solution495 {
    //    简单模拟既可
    public int findPoisonedDuration(int[] timeSeries, int duration) {
//        count表示当前可以持续达到的时间
        int count = timeSeries[0] + duration - 1;
        int res = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] > count) {
                res += duration;
            } else {
//               否则直接就是看中毒时间间隔既可
                res += timeSeries[i]-timeSeries[i-1];
            }
            count = timeSeries[i] + duration - 1;
        }
        return res;
    }
}
