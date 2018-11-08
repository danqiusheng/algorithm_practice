package other;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 图的广搜,采用Queue
 *
 * @author 丹丘生
 */
public class MapBFSQueue {
    static int n;
    static int m;
    static int[][] map;

    static int[] book;
    static int sum;
    static Queue<Integer> queue = new LinkedList<Integer>();

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        // 几个点
        n = read.nextInt();
        //几条边
        m = read.nextInt();
        book = new int[n + 1];
        map = new int[n + 1][n + 1];
        initMap();
        // 初始化地图a
        for (int j = 0; j < m; j++) {
            int a = read.nextInt();
            int b = read.nextInt();
            map[a][b] = map[b][a] = 1;
        }
        queue.add(1);
        book[1] = 1;
        Integer head;
        while ((head = queue.poll()) != null) {
            for (int index = 1; index <= n; index++) {
                if (map[head][index] == 1 && book[index] != 1) {
                    book[index] = 1;
                    queue.add(index);  // 进队列
                }
            }
            System.out.println(head);
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