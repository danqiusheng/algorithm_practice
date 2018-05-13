package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 迷宫 广搜
 * 其内部实现用的是先进先出的队列
 * 两个点，求最短的路径
 输入：
 5 4
 0 0 1 0
 0 0 0 0
 0 0 1 0
 0 1 0 0
 0 0 0 1
 0 0 3 2
输出：（没有障碍）
 (3,2)
 (2,2)
 (1,2)
 (0,2)
 (0,1)
 (0,0)
 输出：（有障碍）
 (3,2)
 (3,3)
 (2,3)
 (1,3)
 (1,2)
 (1,1)
 (0,1)
 (0,0)
 * @author danqiusheng
 */
public class BFS_3 {
    private static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int[][] result;
    // 终点
    private static int endx = 0;
    private static int endy = 0;
    // x
    private static int n;
    // y
    private static int m;
    private static int[][] map;
    //  设置队列
    static Queue<Node> que = new LinkedList<Node>();

    public static void main(String[] args) {
        // 设置头
        Scanner read = new Scanner(System.in);

        n = read.nextInt();
        m = read.nextInt();

        // 初始化
        map = new int[n][m];
        result = new int[n][m];

        // 读取数据
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = read.nextInt();
            }
        }
        // 判断点
        int startx = read.nextInt();
        int starty = read.nextInt();

        endx = read.nextInt();
        endy = read.nextInt();

        Node node = new Node();
        node.x = startx;
        node.y = starty;
        node.step = 0;
        node.parent = null;
        que.add(node);// 起始点进队列

        // 标记起始点访问
        result[startx][starty] = 1;

        int flag = 0;
        // 以当前点广搜
        Node heads;
        Node resultNode = null;// 终点
        while ((heads = que.poll()) != null) {
            for (int i = 0; i < 4; i++) {
                int tx = heads.x + direction[i][0];
                int ty = heads.y + direction[i][1];
                // 判断是否越界
                if (tx < 0 || tx >= n || ty < 0 || ty >= m) {
                    continue;
                }
                // 判断该点是否为障碍物并且有没有被访问 (拓展）
                if (map[tx][ty] == 0 && result[tx][ty] == 0) {

                    Node next = new Node();
                    result[tx][ty] = 1;
                    next.x = tx;
                    next.y = ty;
                    next.parent = heads;
                    next.step = heads.step + 1;
                    resultNode = next;
                    que.add(next);
                }

                // 如果当前点为最终节点
                if (tx == endx && ty == endy) {
                    flag = 1; // 标志找到
                    break; // 退出for循环
                }

            }
            if (flag == 1) // 如果找到 退出while循环
                break;
        }

        System.out.println("(" + resultNode.x + "," + resultNode.y + ")");

        Node parent;
        // 这条路线是反的，需要反序打印结果
        while (resultNode.parent != null) {
            parent = resultNode.parent;
            System.out.println("(" + parent.x + "," + parent.y + ")");
            resultNode = parent;
        }
    }

    /**
     * Queue
     * 队列对象
     */

    static class Node {
        int x;
        int y;
        Node parent = null;
        int step;

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

        public int getStep() {
            return step;
        }

        public void setStep(int step) {
            this.step = step;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }
}


