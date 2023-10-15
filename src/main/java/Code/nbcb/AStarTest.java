package Code.nbcb;

import java.util.*;

public class AStarTest {
    //     A* 寻路算法

    static int[][] map = new int[][]{
            {0, 0, 0, 0, 0},
            {1, 0, 4, 0, 0},
            {4, 0, 4, 0, 0},
            {4, 4, 4, 0, 0},
            {0, 0, 0, 0, 9}
    };


    public static void main(String[] args) {

        prinMAP(map);
        List<Point> astar = Astar(map);
        System.out.println(astar.toString());
        prinPath(astar);
    }

    private static void prinPath(List<Point> res) {
        for (Point p : res) {
            map[p.x][p.y] = 6;
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {

                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static List<Point> Astar(int[][] tmp) {
//      存储结果
        LinkedList<Point> res = new LinkedList<>();

        int[][] v = new int[5][5];
        int startX = 0, startY = 0;
        int endX = 0, endY = 0;
        //        偏移量
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[0].length; j++) {
                if (tmp[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
                if (tmp[i][j] == 9) {
                    endX = i;
                    endY = j;
                }
            }
        }

//       采用一个优先队列进行存储节点，每次选取最小的
        PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparingInt((Point point) -> point.totalCost));
        int pre = preCostDecu(startX, startY, endX, endY);
        queue.add(new Point(startX, startY, null, 0, pre, pre));
        v[startX][startY] = 1;

        while (!queue.isEmpty()) {
            Point p1 = queue.peek();
            if (p1.x == endX && p1.y == endY) {
                return Path(p1);
            }
            for (int i = 0; i < 4; i++) {
                int tx = p1.x + dx[i];
                int ty = p1.y + dy[i];
                int tcur = p1.curCost + 1;
                int tpre = preCostDecu(tx, ty, endX, endY);

//            开始判断是否越界
                if (tx >= 0 && tx < 5
                        && ty >= 0 && ty < 5
                        && tmp[tx][ty] != 4
                        && v[tx][ty] != 1) {
                    queue.add(new Point(tx, ty, p1, tcur, tpre, tcur + tpre));
                    v[tx][ty] = 1;
                }
            }
            queue.remove();
        }

        return res;
    }

    public static List<Point> Path(Point point) {
        LinkedList<Point> path = new LinkedList<>();
        while (point.father != null) {
            path.add(point);
            point = point.father;
        }
        return path;
    }

    public static int preCostDecu(int x, int y, int x1, int y1) {
        return Math.abs(x - x1) + Math.abs(y - y1);
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

class Point {
    int x;
    int y;
    //    存储来源
    Point father;

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    //    存储当前代价
    int curCost;
    //    存储预估代价
    int preCost;
    int totalCost;

    public Point(int x, int y, Point father, int curCost, int preCost, int totalCost) {
        this.x = x;
        this.y = y;
        this.father = father;
        this.curCost = curCost;
        this.preCost = preCost;
        this.totalCost = totalCost;
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

    public Point getFather() {
        return father;
    }

    public void setFather(Point father) {
        this.father = father;
    }

    public int getCurCost() {
        return curCost;
    }

    public void setCurCost(int curCost) {
        this.curCost = curCost;
    }

    public int getPreCost() {
        return preCost;
    }

    public void setPreCost(int preCost) {
        this.preCost = preCost;
    }


    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public Point(int x, int y, Point father, int curCost, int preCost) {
        this.x = x;
        this.y = y;
        this.father = father;
        this.curCost = curCost;
        this.preCost = preCost;
    }

}
