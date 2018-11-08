package other;

import java.util.Scanner;
import java.util.Stack;

/**
 * 城市地图,打印最短路线，并计算最短路径（无向和有向）
 *
 * @author 丹丘生
 */
public class CityMapDFS {
    static int[][] map;
    static int[] book;

    static int n;
    static int m;

    static int min = Integer.MAX_VALUE;
    static Stack<Integer> stack = new Stack<Integer>();
    static String result = "";

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        //几个城市
        n = read.nextInt();
        // 几条边
        m = read.nextInt();
        map = new int[n + 1][n + 1];
        book = new int[n + 1];
        initMap();
        for (int index = 0; index < m; index++) {
            int row = read.nextInt();
            int col = read.nextInt();
            int distance = read.nextInt();
//            map[row][col]  = distance; // 有向图
            map[row][col] = map[col][row] = distance; // 无向图
        }

        // 第一个点
        book[1] = 1;
        stack.push(1);
        dfs(1, 0);
        System.out.println(result);
        System.out.println(min);
    }

    private static void dfs(int curStep, int dis) {
        // 出口
        if (dis > min) return;
        // 如果找到最后的点
        if (curStep == n) {
            if (dis < min) {
                min = dis;
                result = "";
                for (Integer x : stack) {
                    result += x + "->";
                }
            }
            return;
        }
        // 遍历
        for (int index = 1; index <= n; index++) {
            if (map[curStep][index] != -1 && book[index] != 1) {
                book[index] = 1;
                stack.push(index);
                dis = dis + map[curStep][index];
                dfs(index, dis);
                dis = dis - map[curStep][index];
                book[index] = 0;
                stack.pop();
            }
        }

    }


    private static void initMap() {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == j)
                    map[i][j] = 0;
                else
                    map[i][j] = -1;  // 无法到达
            }
        }
    }
}
//5 8
//1 2 2
//1 5 10
//2 3 3
//2 5 7
//3 1 4
//3 4 4
//4 5 5
//5 3 3