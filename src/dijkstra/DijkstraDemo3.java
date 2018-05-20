package dijkstra;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/5/20.
 * 输入：
 * 5
 * 50
 * 30 5
 * 100 20 50
 * 10 x x 10
 * <p>
 * 输出：
 * 35
 *
 * @author danqiusheng
 */
public class DijkstraDemo3 {
    static int INF = Integer.MAX_VALUE;//(无法到达)

    public static void main(String[] args) {
        int get;
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();

        int[][] length = new int[n][n];
        read.nextLine();
        for (int i = 1; i < n; i++) {
            String[] data = read.nextLine().split(" ");
            for (int j = 0; j < i; j++) {
                if (Character.isDigit(data[j].toCharArray()[0])) {// 判断是否为数字
                    length[j][i] = length[i][j] = Integer.parseInt(data[j]);
                } else {
                    length[j][i] = length[i][j] = INF;
                }
            }
        }
        int[] distance = new int[n];
        boolean[] flag = new boolean[n];
        dijkstra(0, length, distance, flag);
    }

    private static void dijkstra(int current, int[][] length, int[] distance, boolean[] flag) {
        for (int i = 0; i < distance.length; i++) {
            distance[i] = INF;
        }
        for (int i = 0; i < distance.length; i++)
            distance[i] = length[current][i];

        // 当前访问
        distance[current] = 0;
        flag[current] = true;

        int points = distance.length;

        int min;
        for (int i = 0; i < points; i++) {
            min = INF;
            // 找寻距离最短的点
            for (int j = 0; j < points; j++) {
                if (!flag[j] && distance[j] < min) {
                    min = distance[j];
                    current = j;
                }
            }
            flag[current] = true;   // 设置这个距离1最短的点被选择
            for (int k = 0; k < points; k++)     // 获取这个最短的点到其他点的距离
                if (!flag[k] && length[current][k] < INF)
                    distance[k] = Math.min(distance[k], distance[current] + length[current][k]);
        }

        int total = 0;
        for (int i = 0; i < points; i++)
            total = Math.max(total, distance[i]);
        System.out.println(total);
    }
}
