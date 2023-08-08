package Code.middle;

import java.util.Arrays;

public class q36 {
    //    36. 有效的数独
    public static void main(String[] args) {

    }

}


class Solution36 {
    //    自己写的太狗屎了
//    直接查看大佬代码
    public boolean isValidSudoku(char[][] board) {
//        需要注意的是，不论怎么扫描判断，都是要遍历全部的
//        九行，每行里有九个数
        int[][] row = new int[9][9];
//        九列，每列有九个数
        int[][] col = new int[9][9];
//        九个box，每个box里面有九个数需要判断
        int[][] box = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int tmp = board[i][j] - '1';
                if (row[i][tmp] == 1) {
                    return false;
                }
                if (col[j][tmp] == 1) {
                    return false;
                }
                if (box[j / 3 + (i / 3) * 3][tmp] == 1) {
                    return false;
                }
                row[i][tmp] = 1;
                col[j][tmp] = 1;
                box[j / 3 + (i / 3) * 3][tmp] = 1;

            }
        }
        return true;
    }
}