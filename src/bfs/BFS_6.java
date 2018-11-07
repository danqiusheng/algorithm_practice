package bfs;

import javax.management.Query;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 宝岛探险
 * 注意： 0代表海洋，1~9代表陆地，求落地时面积
 *
 * @author 丹丘生
 */
public class BFS_6 {

    private static int[][] map;
    private static int[][] book;
    private static Queue<Node> queue = new LinkedList<Node>();

    static int startx;
    static int starty;

    static int n;
    static int m;

    static int count = 0;

    private static int[][] direction = {
            {0, -1},
            {1, 0},
            {0, 1},
            {-1, 0}
    };

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
        Node start = new Node(startx, starty);
        queue.add(start);
        book[startx][starty] = 1;
        count = 1;
        Node head;
        while ((head = queue.poll()) != null) {

            for (int index = 0; index < 4; index++) {
                int tx = head.x + direction[index][0];
                int ty = head.y + direction[index][1];

                if (tx < 0 || ty < 0 || tx >= n || ty >= m) // 判断是否越界
                    continue;

                if (map[tx][ty] > 0 && book[tx][ty] == 0) {
                    count++;
                    Node next = new Node(tx, ty);
                    book[tx][ty] = 1;
                    queue.add(next);
                }
            }
        }


        System.out.println(count);

    }

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
