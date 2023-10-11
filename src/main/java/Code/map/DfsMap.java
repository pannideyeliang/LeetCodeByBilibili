package Code.map;

import javax.sound.midi.Soundbank;
import java.util.ArrayDeque;
import java.util.LinkedList;

// 广度优先算法之走迷宫
public class DfsMap {
    //    1 表示起点， 2 表示终点，9 表示强  6表示经过的路径
    static int[][] map = new int[][]{
            {0, 0, 0, 9, 0},
            {0, 1, 0, 0, 0},
            {0, 9, 0, 9, 0},
            {0, 0, 0, 9, 0},
            {0, 0, 0, 0, 2}
    };

    public static void main(String[] args) {
//        访问数组
        int[][] visit = new int[5][5];
        int x, y;
        int startX = 0, startY = 0;
        int endX = 0, endY = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (1 == map[i][j]) {
                    startX = i;
                    startY = j;
                }
                if (2 == map[i][j]) {
                    endX = i;
                    endY = j;
                }
            }
        }
//        打印当前地图
        printMap(map);
        System.out.println("start:" + startX + " " + startY);
        System.out.println("end:" + endX + " " + endY);
//        开始进行bfs
        LinkedList<point> deque = new LinkedList<>();
//        step表示当前走的距离为0
        point pointS = new point(startX, startY, 0);

//        开始入队列
        deque.add(pointS);
        System.out.println("入队列" + pointS);
//        同时标记已经被访问
        visit[startX][startY] = -1;
//        定义一个偏移坐标,方向为顺时针，右下左上
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        while (!deque.isEmpty()) {
            int tx = deque.peek().x;
            int ty = deque.peek().y;
            int tstep = deque.peek().step;
            if (tx == endX && ty == endY) {
                System.out.println("最短路径为：" + tstep);
                break;
            }
//            bfs加入
            for (int i = 0; i < 4; i++) {
                int tmpx = tx + dx[i];
                int tmpy = ty + dy[i];
//                判断边界
                if (tmpx >= 0 && tmpx < 5 && tmpy >= 0 && tmpy < 5
                        && visit[tmpx][tmpy] != -1 && map[tmpx][tmpy] != 9) {
                    point pointt = new point(tmpx, tmpy, tstep + 1);
                    deque.add(pointt);
                    System.out.println("入队列" + pointt);
                    visit[tmpx][tmpy] = -1;
                }
            }
//            然后首在出队列
//
            System.out.println("出队列" + deque.peekFirst());
            deque.remove();
        }

    }

    private static void printMap(int[][] t) {
        System.out.println("============ditu=============");
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                System.out.print(t[i][j] + "  ");
            }
            System.out.println();
        }
    }
}


//储存坐标
class point {
    int x, y;

    @Override
    public String toString() {
        return "point{" +
                "x=" + x +
                ", y=" + y +
                ", step=" + step +
                '}';
    }

    public point(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }

    int step;

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public point(int x, int y) {
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
