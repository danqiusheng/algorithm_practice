package dfs;

import java.util.Scanner;

/**
 * 宝岛探险
 * 注意： 0代表海洋，1~9代表陆地
 * 1. 求落地时面积
 * 2. 落地面积染色
 * 3. 求多少个小岛
 * @author 丹丘生
 */
public class DFS_5 {
    private static int[][] direction = {
            {0, -1},
            {1, 0},
            {0, 1},
            {-1, 0}
    };
    private static int[][] map;
    private static int[][] book;

    static int startx;
    static int starty;

    static int n;
    static int m;

    static int count = 0;

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        // 输入行列
        n = read.nextInt();
        m = read.nextInt();

        // 落地点
        startx = read.nextInt();
        starty = read.nextInt();
        map = new int[n][m];
        book = new int[n][m];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = read.nextInt();
            }
        }
        book[startx][starty] = 1;
        map[startx][starty] = -1;
        count++;

        // 不进行标记数据
        //dfs(startx, starty);
        // 染色
        // dfs(startx, starty, -1);

        int colorNum = 0;
        // 独立的小岛
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0 && book[i][j] == 0) {
                    book[i][j] = 1;
                    dfs(i, j, --colorNum);
                }
            }
        }

        System.out.printf("有%d个小岛",-colorNum);
        System.out.println();
        // 打印数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%3d", map[i][j]);
            }
            System.out.println();
        }
        System.out.println(count);
    }


    private static void dfs(int x, int y) {


        for (int index = 0; index < 4; index++) {
            int tx = x + direction[index][0];
            int ty = y + direction[index][1];
            if (tx < 0 || ty < 0 || tx >= n || ty >= m) // 判断是否越界
                continue;

            if (map[tx][ty] > 0 && book[tx][ty] == 0) {
                book[tx][ty] = 1;
                count++;
                dfs(tx, ty);
            }
        }
    }

    private static void dfs(int x, int y, int color) {

        map[x][y] = color;

        for (int index = 0; index < 4; index++) {
            int tx = x + direction[index][0];
            int ty = y + direction[index][1];
            if (tx < 0 || ty < 0 || tx >= n || ty >= m) // 判断是否越界
                continue;
            if (map[tx][ty] > 0 && book[tx][ty] == 0) {
                count++;
                book[tx][ty] = 1;
                dfs(tx, ty, color);
            }
        }
    }
}
//10 10 6 8
//1 2 1 0 0 0 0 0 2 3
//3 0 2 0 1 2 1 0 1 2
//4 0 1 0 1 2 3 2 0 1
//3 2 0 0 0 1 2 4 0 0
//0 0 0 0 0 0 1 5 3 0
//0 1 2 1 0 1 5 4 3 0
//0 1 2 3 1 3 6 2 1 0
//0 0 3 4 8 9 7 5 0 0
//0 0 0 3 7 8 6 0 1 2
//0 0 0 0 0 0 0 0 1 0