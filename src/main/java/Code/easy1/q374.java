package Code.easy1;

public class q374 {
    //    374. 猜数字大小
    public static void main(String[] args) {

    }
}


class Solution extends GuessGame {
    public int guessNumber(int n) {
        if (guess(n) == 0) return n;
        int left = 1, right = n;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (guess(mid) == 1) {
                left = mid + 1;
            } else if (guess(mid) == -1) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return 0;
    }
}


class GuessGame {
    int guess(int num) {
        return 1;
    }
}
