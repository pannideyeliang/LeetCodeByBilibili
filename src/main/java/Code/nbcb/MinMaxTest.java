package Code.nbcb;


/**
 * @author 陈佳乐
 * @create 2023-10-16-16:07
 */
public class MinMaxTest {
    public static void main(String[] args) {

    }

    //    minmax算法模板
//    alpha 从最小值开始， beta从最大值开始
    public static move alphaBeta(status status, int alpha, int beta, boolean isMax) {
//        解析棋盘状态
//        判断棋盘是否结束，递归深度是否到达
//        如果结束或者到达，则返回得分

        move bestMove = new move();
//        如果是max玩家

        if (isMax) {
//            遍历所有子情况状态
            bestMove.score = Integer.MIN_VALUE;
            while (true) {
//                更改状态 status 变成子状态
                move tmpmove = alphaBeta(status, alpha, beta, !isMax);
//                回溯调更改的 status 状态
//            如果 子情况的 move.score > alpha ，则更新 bestMove 和 alpha
                bestMove = tmpmove;
                if (alpha >= beta) {
                    break;
                }
            }

        } else {

        }
        return null;
    }
}

//表示棋盘状态
class status {
    int arrs;
    int me;
    int enermy;
}

// 表示决策方案
class move {
    int x;
    int y;
    int score;
}
