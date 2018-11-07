package dfs;

import java.util.Scanner;

/**
 * DFS:
 * 题目：迷宫，两个点求最短路径
 *
 * @author 丹丘生
 * <p>
 * 输入例子:
 * 5 4
 * 0 0 1 0
 * 0 0 0 0
 * 0 0 1 0
 * 0 1 0 0
 * 0 0 0 1
 * 0 0 3 2
 * <p>
 * 输出：7
 */
public class DFS_2 {
    // 右下左上
    private static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int[][] book;
    private static int[][] map;
    // 终点
    private static int endx = 0;
    private static int endy = 0;

    // 最小的步数
    private static int min = Integer.MAX_VALUE;
    // x
    private static int n;
    // y
    private static int m;

    public static void main(String[] args) {
        // 开始的点
        int startx = 0;
        int starty = 0;

        Scanner read = new Scanner(System.in);

        n = read.nextInt();
        m = read.nextInt();

        // 初始化
        map = new int[n][m];
        book = new int[n][m];

        // 读取数据
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = read.nextInt();
            }
        }
        // 判断点
        startx = read.nextInt();
        starty = read.nextInt();

        endx = read.nextInt();
        endy = read.nextInt();

        book[startx][starty] = 1;
        dfs(startx, starty, 0);

        read.close();
        System.out.println(min);
    }


    public static void dfs(int x, int y, int step) {
        if (x == endx && y == endy) {// 如果到达终点 为递归的出口
            if (step < min) {
                min = step;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int tx = x + direction[i][0];
            int ty = y + direction[i][1];
            // 判断是否越界
            if (tx < 0 || tx >= n || ty < 0 || ty >= m) {
                continue;
            }
            // 判断该点是否为障碍物并且有没有被访问
            if (map[tx][ty] == 0 && book[tx][ty] == 0) {
                book[tx][ty] = 1;
                dfs(tx, ty, step + 1);
                book[tx][ty] = 0;
            }
        }

        return;
    }
}
