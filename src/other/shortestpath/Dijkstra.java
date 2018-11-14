package other.shortestpath;

import java.util.Scanner;

/**
 * 一个点到其余各个顶点的最短距离（单源最短路径）
 * 例如求1->其他点的距离
 * 此算法的时间复杂度在进行松弛的时候（时间复杂度是N*N ）
 *
 * @author danqiusheng
 */
public class Dijkstra {
    static int[][] map;
    static int n;
    static int[] small;
    static int[] book;
    // 初始化地图
    private static void initMap() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.MAX_VALUE;  // 无法到达
                if (i == j)
                    map[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        // 获取点
          n = read.nextInt();
        // 获取边
        int m = read.nextInt();

        small = new int[n + 1];
        book = new int[n + 1];
        map = new int[n + 1][n + 1];

        // 初始化地图数据
        initMap();

        // 获取点的距离
        for (int index = 0; index < m; index++) {
            int row = read.nextInt();
            int col = read.nextInt();
            int distance = read.nextInt();
            map[row][col] = distance;
        }

        // 进行遍历
        // 存储顶点1到各个顶点的距离
        for (int index = 1; index <= n; index++) {
            small[index] = map[1][index]; //进行最短路径的设置
        }


        // 标记顶点访问
        book[1] = 1;
        int min;
        int minDisIndex = -1;
        for (int row = 1; row <= n-1; row++) {
            min = Integer.MAX_VALUE;
            //----------找最近的一个点---------------------
            for (int col = 1; col <= n; col++) {
                // 标记,找到最近的一个点
                if (book[col] == 0 && small[col] < min) {
                    min = small[col];
                    minDisIndex = col;
                }
            }
            //---------------------------------------------


            // 标记当前点已经访问
            book[minDisIndex] = 1;


            //-----------针对找到的最近点进行松弛--------------------
            for (int index = 1; index <= n; index++) {
                // 如果当前点存在距离
                if (map[minDisIndex][index] < Integer.MAX_VALUE) {
                    if (small[index] > small[minDisIndex] + map[minDisIndex][index]) {
                        small[index] = small[minDisIndex] + map[minDisIndex][index];
                    }
                }
            }
            //-------------------------------
        }

        //--------打印结果-------------
        for (int index = 1; index <= n; index++) {
            System.out.printf("%4d",small[index]);
        }
    }
}
//6 9
//1 2 1
//1 3 12
//2 3 9
//2 4 3
//3 5 5
//4 3 4
//4 5 13
//4 6 15
//5 6 4