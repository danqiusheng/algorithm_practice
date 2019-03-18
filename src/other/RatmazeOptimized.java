package other;

/**
 * 老鼠走迷宫
 * 并将老鼠走的路线打印出来,采用深搜(DFS) （多条路线）
 * 在二维阵列中使用2表示迷宫墙壁，0代表可走路线
 *
 * @author danqiusheng
 * @since 2019-03-18
 */
public class RatmazeOptimized {
    // 设置上右下左方向
    private static int[][] direction = {
            {0, -1},  // 左
            {1, 0},  // 下
            {0, 1},  // 右
            {-1, 0}  // 上
    };
    static int maze[][] = {{2, 2, 2, 2, 2, 2, 2, 2, 2}, {2, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 2, 2, 0, 2, 2, 0, 2}, {2, 0, 2, 0, 0, 2, 0, 0, 2},
            {2, 0, 2, 0, 2, 0, 2, 0, 2}, {2, 0, 0, 0, 0, 0, 2, 0, 2},
            {2, 2, 0, 2, 2, 0, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 2}, {2, 2, 2, 2, 2, 2, 2, 2, 2}};
    static int endX = 7;
    static int endY = 7;
    static int[][] book = new int[maze.length][maze.length];

    static boolean flag = true; // 标志是否找到出口路径

    public static void main(String[] args) {

        System.out.println("显示迷宫：");
        // 设置起点访问
        book[1][1] = 1;

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++)
                if (maze[i][j] == 2) System.out.print("█");
                else System.out.print("  ");
            System.out.println("");
        }


        dfs(1, 1); // 递归查询路径
        // 打印结果
        if (flag) {
            System.out.println("没有出口!");
        }

    }

    public static void print() {
        System.out.println("迷宫出口:");
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 2) {
                    System.out.print("█");
                } else if (maze[i][j] == 0 && book[i][j] == 1) System.out.print("◇");
                else System.out.print("  ");
            }
            System.out.println("");
        }
    }

    public static void dfs(int x, int y) {
        // 设置递归的出口,如果已经到达了终点
        if (x == endX && y == endY) {
            flag = false;
            print();
            return;
        }


        if (maze[x][y] == 2) return; // 如果当前是墙壁，直接返回

        // 遍历四个方向
        for (int i = 0; i < direction.length; i++) {
            int tempx = x + direction[i][0];
            int tempy = y + direction[i][1];
            if (tempx >= maze.length || tempy >= maze[tempx].length || tempx < 0 || tempy < 0) {
                continue;
            }
            if (book[tempx][tempy] != 1 && maze[tempx][tempy] == 0) {
                book[tempx][tempy] = 1; // 标记访问
                dfs(tempx, tempy); // 以当前为中心点，递归四个方向
                book[tempx][tempy] = 0; // 标记未访问
            }
        }
    }

}
