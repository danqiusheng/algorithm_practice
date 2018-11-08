package other;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 最少转机，转机次数(广搜)
 *
 * @author 丹丘生
 */
public class TransferFlightBFS {
    static int n;
    static int m;
    static int startCity;
    static int endCity;

    static int[][] map; //地图
    static int[] book; // 标记数组

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        n = read.nextInt();
        m = read.nextInt();
        startCity = read.nextInt();
        endCity = read.nextInt();
        map = new int[n + 1][n + 1];
        book = new int[n + 1];
        initMap();
        for (int index = 0; index < m; index++) {
            int start = read.nextInt();
            int end = read.nextInt();
            map[start][end] = 1;
        }
        int count = 0; // 转机次数
        Queue<AirPoint> queue = new LinkedList<AirPoint>();

        queue.add(new AirPoint(startCity, 0));
        book[startCity] = 1;
        AirPoint head;
        AirPoint nextPoint = null;

        boolean flag = false;
        while ((head = queue.poll()) != null) {
            for (int index = 1; index <= n; index++) {
                if (map[head.current][index] != -1 && book[index] != 1) {
                    book[index] = 1;
                    nextPoint = new AirPoint(index, head.step + 1);
                    queue.add(nextPoint);//进队列
                    if (nextPoint.current == endCity) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) break;
        }
        System.out.println(nextPoint.step );
    }

    private static void initMap() {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                map[i][j] = -1;
            }
        }
    }

    static class AirPoint {
        int current;
        int step;

        public AirPoint(int current, int step) {
            this.current = current;
            this.step = step;
        }
    }
}
//5 7 1 4
//1 2
//1 3
//2 3
//2 4
//3 4
//3 5
//4 5