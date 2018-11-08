package other;

import java.util.Scanner;

/**
 * 图的深搜
 *
 * @author 丹丘生
 */
public class MapDFS {
    static int n;
    static int m;
    static int[][] map;

    static int[] book;

    static int sum;

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        // 几个点
        n = read.nextInt();
        //几条边
        m = read.nextInt();
        map = new int[n + 1][n + 1];
        book = new int[n + 1];
        // 初始化地图
        initMap();
        for (int i = 0; i < m; i++) {
            int row = read.nextInt();
            int col = read.nextInt();
            map[row][col] = 1;// 可以到达
            map[col][row] = 1;// 可以到达
        }

        // 标记第一个点访问
        book[1] = 1;
        // 遍历第一个点
        dfs(1);
    }


    private static void dfs(int curStep) {

        sum++;
        System.out.println(curStep);
        if (sum >= n) {
            return;
        }

        for (int index = 1; index <= n; index++) {
            if (map[curStep][index] == 1 && book[index] != 1) {
                book[index] = 1;
                dfs(index);
            }
        }
    }

    private static void initMap() {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                map[i][j] = -1;  // 无法到达
            }
        }
    }
}
//5 5
//1 2
//1 3
//1 5
//2 4
//3 5