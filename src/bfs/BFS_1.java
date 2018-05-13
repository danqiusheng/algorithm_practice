package bfs;

import java.util.Scanner;

/**
 * 迷宫 广搜
 * 其内部实现用的是先进先出的队列
 * 两个点，求最短的路径
 *
 * @author 丹丘生
 */
public class BFS_1 {
    private static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int[][] book;
    // 终点
    private static int endx = 0;
    private static int endy = 0;
    // x
    private static int n;
    // y
    private static int m;
    private static int[][] map;
    //  设置对象的数组
    static Node[] que = null;


    public static void main(String[] args) {
        // 设置头

        int startx = 0;
        int starty = 0;

        Scanner read = new Scanner(System.in);

        n = read.nextInt();
        m = read.nextInt();

        // 初始化
        map = new int[n][m];
        book = new int[n][m];
        que = new Node[n * m];

        // 读取数据
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = read.nextInt();
            }
        }
        // 判断点
        startx = read.nextInt();
        starty = read.nextInt();

        endx = read.nextInt();
        endy = read.nextInt();

        int head = 0;
        int tail = 0;
        // 设置开始的点
        que[tail] = new Node();
        que[tail].x = startx;
        que[tail].y = starty;
        que[tail].step = 0;
        que[tail].parent = 0;
        book[startx][starty] = 1;
        // 当前点进栈
        tail++;

        int flag = 0;
        // 以当前点广搜
        while (head < tail) {

            //
            for (int i = 0; i < 4; i++) {
                int tx = que[head].x + direction[i][0];
                int ty = que[head].y + direction[i][1];
                // 判断是否越界
                if (tx < 0 || tx >= n || ty < 0 || ty >= m) {
                    continue;
                }
                // 判断该点是否为障碍物并且有没有被访问
                if (map[tx][ty] == 0 && book[tx][ty] == 0) {
                    que[tail] = new Node();
                    book[tx][ty] = 1;
                    que[tail].x = tx;
                    que[tail].y = ty;
                    que[tail].parent = head;
                    que[tail].step = que[head].step + 1;
                    tail++;
                }
                // 如果当前点为最终节点
                if (tx == endx && ty == endy) {
                    flag = 1; // 标志找到
                    break; // 退出for循环
                }

            }

            if (flag == 1) // 如果找到 退出while循环
                break;
            head++; // 出栈
        }

        System.out.println("(" + que[tail - 1].x + "," + que[tail - 1].y + ")");
        int index = tail - 1;
        Node parent = que[que[tail - 1].parent];
        Node current = que[tail - 1];
        while (current.x != startx && current.y != starty) {
            System.out.println("(" + parent.x + "," + parent.y + ")");
            //System.out.println(que[tail-1].step);
            current = parent;
            index = parent.parent;
            parent = que[index];
        }
        System.out.println("(" + parent.x + "," + parent.y + ")");
    }

    /**
     * Queue
     * 队列对象
     */

    static class Node {
        int x;
        int y;
        int parent = -1;
        int step;

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

        public int getStep() {
            return step;
        }

        public void setStep(int step) {
            this.step = step;
        }

        public int getParent() {
            return parent;
        }

        public void setParent(int parent) {
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }
}

