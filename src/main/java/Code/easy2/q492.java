package Code.easy2;

public class q492 {
    //492. 构造矩形
    public static void main(String[] args) {

    }
}


class Solution492 {
    //    无脑的方法
    public int[] constructRectangle(int area) {
        int L, W = 1;
        L = (int) Math.sqrt(area);
        while (L != area) {
            if (area % L == 0 && L >= area / L) {
                W = area / L;
                return new int[]{L, W};
            }
            L++;
        }
        return new int[]{L, W};
    }

    //    下面查看大佬的代码
//    比较简洁：当正着来需要讨论的时候，那就直接反着来，直接从小的开始减
//    反正小的不会超过大的，不需要额外讨论
    public int[] constructRectangle1(int area) {
        for (int i = (int) (Math.sqrt(area)); ; i--) {
            if (area % i == 0) return new int[]{area / i, i};
        }
    }
}