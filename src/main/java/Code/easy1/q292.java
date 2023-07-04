package Code.easy1;

public class q292 {
    //    292. Nim 游戏
    public static void main(String[] args) {

    }
}

class Solution292 {
    //    你作为先手   注意这个非常重要的条件
//    数学归纳，博弈论
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
