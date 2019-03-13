package other;

/**
 * 巴斯卡三角形
 *
 * @author danqiusheng
 */
public class Pascal {
    public static void main(String[] args) {
        int[][] arr = new int[14][14];
        // 初始化数据
        for (int i = 1; i < arr.length; i++) {
            arr[i][1] = 1;
            arr[i][i] = 1;
        }

        // 计算数据
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= i; j++) {
                int blank;
                /* 排版设定开始 */
                if (j == 1) {
                    for (blank = 1; blank <= (arr.length - i); blank++) {
                        System.out.print("   "); // 三个空格
                    }
                } else {
                    System.out.print("  ");//两个空格
                }
                System.out.printf("%5d", arr[i][j]);

            }
            System.out.println();
        }
    }
}
