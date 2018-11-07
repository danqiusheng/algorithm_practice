package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 炸弹人的例子 用广搜
 *
 * @author 丹丘生
 */
public class BFS_5 {

    private static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static Queue<Node> que = new LinkedList<Node>();
    private static int[][] book;
    static char[][] chs;
    static int n;
    static int m;

    public static void main(String[] args) {
        // 定义变量
        int max = 0;
        Node maxNode;
        Scanner read = new Scanner(System.in);

        m = read.nextInt();
        n = read.nextInt();
        int startx = read.nextInt();
        int starty = read.nextInt();

        //
        read.nextLine();
        chs = new char[m][n];
        book = new int[m][n];
        for (int i = 0; i < m; i++) {
            // 获取将数据转换为字符数组
            chs[i] = read.nextLine().toCharArray();
        }


        Node node = new Node();
        node.x = startx;
        node.y = starty;
        que.add(node);// 起始点进队列

        // 得到起始点可以消灭的敌人数
        max = getSum(node);
        maxNode = node;

        // 以当前点进行广搜
        Node heads;

        while ((heads = que.poll()) != null) {

            for (int index = 0; index < 4; index++) {
                int tx = heads.x + direction[index][0];
                int ty = heads.y + direction[index][1];

                // 判断是否越界
                if (tx < 0 || tx >= n || ty < 0 || ty >= m) {
                    continue;
                }

                // 判断该点是否为障碍物并且有没有被访问
                if (book[tx][ty] == 0 && chs[tx][ty] == '.') {
                    book[tx][ty] = 1; // 标记当前点已经访问
                    Node next = new Node();

                    next.x = tx;
                    next.y = ty;
                    int min = getSum(next);
                    if(max<min) {
                        max = min;
                        maxNode = next;
                    }
                    que.add(next);
                }
            }
        }
        System.out.println(maxNode);
        System.out.println("消灭敌人的个数为："+max);

    }

    // 得到当前点的总和
    private static int getSum(Node next) {

        // 上下左右方向 能消灭的敌人数
        int sum = 0;

        // 从上
        int x = next.x;
        int y = next.y;
        while (chs[x][y] != '#' && x >= 0) {
            if (chs[x][y] == 'G')
                sum++;
            x--;
        }
        // 从下
        x = next.x;
        y = next.y;
        while (chs[x][y] != '#' && x < n) {
            if (chs[x][y] == 'G')
                sum++;
            x++;
        }
        // 从左
        x = next.x;
        y = next.y;
        while (chs[x][y] != '#' && y >= 0) {
            if (chs[x][y] == 'G')
                sum++;
            y--;
        }
        // 从右
        x = next.x;
        y = next.y;
        while (chs[x][y] != '#' && y < m) {
            if (chs[x][y] == 'G')
                sum++;
            y++;
        }
        return sum;
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
//#############
//#GG.GGG#GGG.#
//###.#G#G#G#G#
//#.......#..G#
//#G#.###.#G#G#
//#GG.GGG.#.GG#
//#G#.#G#.#.###
//##G...G.....#
//#G#.#G###.#G#
//#...G#GGG.GG#
//#G#.#G#G#.#G#
//#GG.GGG#G.GG#
//#############
//
