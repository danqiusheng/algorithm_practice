package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 其内部实现用的是先进先出的队列 ，直接循环判断相邻点是否都为海岛即可。
 * 输入：（输入N），接下来的输入是N*N的二维数组
 * 7
 * .......
 * .##....
 * .##....
 * ....##.
 * ..####.
 * ...###.
 * .......
 * 输出：
 * 1
 *
 * @author danqiusheng
 */
public class BFS_4 {
    private static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int[][] result; // 判断是否经过
    private static char[][] map;
    private static int N;
    //  设置队列
    static Queue<Node> que = new LinkedList<Node>();

    public static void main(String[] args) {
        // 设置头
        Scanner read = new Scanner(System.in);
        N = read.nextInt();
        read.nextLine();
        // 初始化
        map = new char[N][N];
        result = new int[N][N];

        // 读取数据
        for (int i = 0; i < N; i++) {
                map[i] = read.nextLine().toCharArray();
        }
        Node node = new Node(0,0);
        que.add(node);// 起始点进队列
        // 标记起始点访问
        result[0][0] = 1;
        // 以当前点广搜
        Node heads;
        int sum = 0;
        while ((heads = que.poll()) != null) {
            int count = 0;// 计数，看相邻的点是否都是小岛
            for (int i = 0; i < 4; i++) {
                int ty = heads.y + direction[i][1];
                int tx = heads.x + direction[i][0];
                // 判断是否越界
                if (tx < 0 || tx >= N || ty < 0 || ty >= N) {
                    continue;
                }
                if (map[tx][ty] == '#') {
                    count++;
                }
                // 判断有没有被访问
                if (result[tx][ty] == 0) {
                    Node next = new Node(tx,ty);
                    result[tx][ty] = 1;
                    que.add(next);
                }
            }

            if (count == 4) {// 代表当前点不会被淹没，因为周围都是小岛
                sum++;
            }

        }
        System.out.println(sum);
    }

    /**
     * Queue
     * 队列对象
     */

    static class Node {
        int x;
        int y;

        public Node() {
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }
}


