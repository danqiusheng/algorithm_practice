package other.shortestpath;

import java.util.Scanner;

/**
 * 五行代码解决求任意两点最短的路径，因为两点之间的最短路径可以通过第三点，第四点或者第五点等等中转。
 * 比如：上海可以到杭州，但是上海可以通过湖南，湖北然后到杭州。
 * 上海+杭州 > 上海+湖南+杭州 的距离，则上海+湖南+杭州是最短的距离，则更新路径Map（通过湖南中转）
 * 上海+杭州 > 上海+湖北+杭州 的距离，上海+湖南+杭州>上海+湖北+杭州  则上海+湖北+杭州是最短的距离，则更新路径Map （通过湖北中转）
 * 但是有可能：
 * 上海+杭州>上海 + 湖南 + 湖北 + 杭州的距离，  则上海 + 湖南 + 湖北 + 杭州 是最短的距离，更新路径Map（通过湖南，湖北中转）
 *
 * @author 丹丘生
 */
public class FloydWarshall {
    static int[][] map;
    static int n;

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        //几个点
        n = read.nextInt();
        //几条边
        int m = read.nextInt();

        map = new int[n + 1][n + 1];
        initMap();

        for (int index = 0; index < m; index++) {
            int row = read.nextInt();
            int col = read.nextInt();
            int distance = read.nextInt();
            map[row][col] = distance;
        }

        // 核心代码

        //第一层循环为中间点，中转的城市 ，可能中转1，3或者1，2
        for (int center = 1; center <= n; center++) {
            // 第二，三层是当前的城市到另一个城市的直接距离
            for (int row = 1; row <= n; row++) {
                for (int col = 1; col <= n; col++) {
                    if (map[row][center] < Integer.MAX_VALUE && map[center][col] < Integer.MAX_VALUE && map[row][col] > map[row][center] + map[center][col]) {
                        map[row][col] = map[row][center] + map[center][col];
                    }
                }
            }
        }


        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.printf("%10d", map[row][col]);
            }
            System.out.println();
        }
    }

    private static void initMap() {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                map[i][j] = Integer.MAX_VALUE;  // 无法到达
                if (i == j)
                    map[i][j] = 0;
            }
        }
    }
}

//4 8
//1 2 2
//1 3 6
//1 4 4
//2 3 3
//3 1 7
//3 4 1
//4 1 5
//4 3 12