package dfs;

import java.util.Scanner;

/**
 * 炸弹人的例子 用深搜
 *
 * @author 丹丘生
 */
public class DFS_4 {
    // 右下左上
    private static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int[][] book; // 标记
    // x
    private static int n;
    // y
    private static int m;
    static char[][] chs;
    static int max = 0;

    static int mx;
    static int my;

    public static void main(String[] args) {
        // 定义变量

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

        // 得到起始点可以消灭的敌人数
        max = getSum(startx, starty);
        mx = startx;
        my = starty;
        dfs(startx, starty);

        System.out.println("(" + mx + "," + my + ")");
        System.out.println("消灭敌人的个数为：" + max);
    }

    public static void dfs(int x, int y) {
        int sum = getSum(x, y);
        if (sum > max) {
            max = sum;
            mx = x;
            my = y;
        }

        for (int index = 0; index < 4; index++) {
            int tx = x + direction[index][0];
            int ty = y + direction[index][1];
            // 判断是否越界
            if (tx < 0 || tx >= n || ty < 0 || ty >= m) {
                continue;
            }
            // 判断该点是否为障碍物并且有没有被访问
            if (book[tx][ty] == 0 && chs[tx][ty] == '.') {
                book[tx][ty] = 1; // 标记当前点已经访问
                dfs(tx, ty);
                // book[tx][ty] = 0; // 取消标记
            }
        }
        return;
    }


    // 得到当前点的总和
    private static int getSum(int targetx, int targety) {


        // 上下左右方向 能消灭的敌人数
        int sum = 0;

        // 从上
        int x = targetx;
        int y = targety;


        while (chs[x][y] != '#' && x >= 0) {
            if (chs[x][y] == 'G')
                sum++;
            x--;
        }
        // 从下
        x = targetx;
        y = targety;
        while (chs[x][y] != '#' && x < n) {
            if (chs[x][y] == 'G')
                sum++;
            x++;
        }
        // 从左
        x = targetx;
        y = targety;
        while (chs[x][y] != '#' && y >= 0) {
            if (chs[x][y] == 'G')
                sum++;
            y--;
        }
        // 从右
        x = targetx;
        y = targety;
        while (chs[x][y] != '#' && y < m) {
            if (chs[x][y] == 'G')
                sum++;
            y++;
        }
        return sum;
    }

}

