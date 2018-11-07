package dfs;

import java.util.*;

/**
 * 水管工的游戏
 *
 * @author 丹丘生
 */
public class DFS_6 {
    private static int[][] direction = {
            {0, -1},
            {1, 0},
            {0, 1},
            {-1, 0}
    };
    private static int[][] map;
    private static int[][] book;


    static int n;
    static int m;

    static boolean flag;

    static Stack<Node> stack = new Stack<Node>();

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        n = read.nextInt();
        m = read.nextInt();
        map = new int[n][m];
        book = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = read.nextInt();
            }
        }
        dfs(0, 0, 1);
        if (!flag) {
            System.out.println("impossible");
            return;
        }
        System.out.println("找到铺设方案");
    }

    /**
     * @param x     坐标x
     * @param y     坐标y
     * @param front 进水方向
     */
    private static void dfs(int x, int y, int front) {


        // 找到出口的判断
        if (x == n - 1 && y == m) {
            flag = true;
            Iterator<Node> iterator = stack.iterator();
            while(iterator.hasNext()){
                Node node = iterator.next();
                System.out.println(node);
            }
            return;
        }

        if (x < 0 || y < 0 || x >= n || y >= m)
            return;

        //判断当前管子是否用过
        if (book[x][y] == 1)
            return;

        book[x][y] = 1;
        stack.push(new Node(x, y));

        // 如果水管是直管
        if (map[x][y] == 5 || map[x][y] == 6) { // 进水口左上右下 1234
            if (front == 1) {
                dfs(x, y + 1, 1);
            }
            if (front == 2) {
                dfs(x + 1, y, 2);
            }
            if (front == 3) {
                dfs(x, y - 1, 3);
            }
            if (front == 4) {
                dfs(x - 1, y, 4);
            }
        }

        // 如果水管是弯管
        if (map[x][y] >= 1 && map[x][y] <= 4) {
            if (front == 1) {  // 进水口左上右下 1234
                dfs(x + 1, y, 2);
                dfs(x - 1, y, 4);
            }
            if (front == 2) {
                dfs(x, y + 1, 1);
                dfs(x, y - 1, 3);
            }
            if (front == 3) {
                dfs(x - 1, y, 4);
                dfs(x + 1, y, 2);
            }
            if (front == 4) {
                dfs(x, y + 1, 1);
                dfs(x, y - 1, 3);
            }
        }
        book[x][y] = 0;
        stack.pop();
        return;
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
