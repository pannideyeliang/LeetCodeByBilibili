package Code.easy2;

/**
 * @author 陈佳乐
 * @create 2023-07-20-20:48
 */
public class q463 {
    //    463. 岛屿的周长
    public static void main(String[] args) {

    }
}

class Solution463 {
    //    DFS，大佬代码
    public int islandPerimeter(int[][] grid) {
//        先找到一个陆地，然后在陆地上做DFS
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
//                    DFS
                    return islandPerimeter(grid, i, j);
                }
            }
        }
        return 0;
    }

    public int islandPerimeter(int[][] grid, int x, int y) {
//        判断标准是，如果上下左右是贴近边框（越界的）或者是水的，则加一
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return 1;
        }
        if (grid[x][y] == 0) {
            return 1;
        }
        if (grid[x][y] != 1) {
            return 0;
        }
//        剩下等于1的情况，需要说明遍历过了
        grid[x][y] = 2;
//        因为从穿进来的第一个数据是陆地，所以直接看陆地周围即可
        return islandPerimeter(grid, x - 1, y) + islandPerimeter(grid, x + 1, y) + islandPerimeter(grid, x, y - 1) + islandPerimeter(grid, x, y + 1);
    }

    //    总周长 = 4 * 土地个数 - 2 * 接壤边的条数。
    public int islandPerimeter1(int[][] grid) {
        int count = 0, border = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
//                    注意接壤的前提是本身也是陆地，所以判断要写在里面
                    //                接壤的边只需要统计右和下即可，否则会重复统计
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        border++;
                    }
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                        border++;
                    }
                }
            }
        }
        return count * 4 - border * 2;
    }

}
