package Code.nbcb;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

public class BFSUtils {

    //    地图 4 代表墙，过不去
    static int[][] map = new int[][]{
            {1, 4, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 4, 0, 0, 0},
            {0, 0, 0, 4, 0},
            {0, 0, 0, 0, 9}
    };

    public static void main(String[] args) {
        prinMAP(map);
        bfs(map);
    }


    public static void bfs(int[][] res) {
        int startX = 0, startY = 0;
        int endX = 0, endY = 0;
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                if (res[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
                if (res[i][j] == 9) {
                    endX = i;
                    endY = j;
                }
            }
        }

//        偏移量
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

//        存储是否被访问过, 1 表示被访问过
        int[][] v = new int[5][5];
//        使用一个队列进行 BFS
        LinkedList<node> queue = new LinkedList<node>();
        queue.add(new node(startX, startY, 1));
        v[startX][startY] = 1;

        while (!queue.isEmpty()) {
            node tmp = queue.peek();
            if (tmp.x == endX && tmp.y == endY) {
                System.out.println("最短路径为：" + tmp.step);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int tx = tmp.x + dx[i];
                int ty = tmp.y + dy[i];
//            开始判断是否越界
                if (tx >= 0 && tx < 5
                        && ty >= 0 && ty < 5
                        && res[tx][ty] != 4
                        && v[tx][ty] != 1) {
                    queue.add(new node(tx, ty, tmp.step + 1));
                    v[tx][ty] = 1;
                }
            }
            queue.remove();
        }
    }

    public static void prinMAP(int[][] res) {
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + "  ");
            }
            System.out.println();
        }
    }

}

class node {
    int x;
    int y;
    int step;

    public node(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }

    public node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
