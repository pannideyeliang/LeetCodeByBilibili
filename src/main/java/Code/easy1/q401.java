package Code.easy1;

import java.util.ArrayList;
import java.util.List;

public class q401 {
    //    401. 二进制手表
    public static void main(String[] args) {

    }
}


class Solution401 {

    //    本质上是一个求二进制中 1 的个数，如果是 1 则表示是亮的， 0 则表示是不亮的
//    所以有如下
    public List<String> readBinaryWatch(int turnedOn) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
//                Integer.bitCount是用来统计 一个数的二进制中 1 的个数的
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                    res.add(i + ":" + (j < 10 ? "0" : "") + j);
                }
            }
        }
        return res;
    }

    //    别的写法
    public List<String> readBinaryWatch1(int turnedOn) {
//        傻逼玩意，都是枚举法，没啥好说的
        return null;
    }
}