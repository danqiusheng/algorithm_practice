package dp;

import java.util.Scanner;

/**
 * 经典背包问题
 * 递推进行，先获取最下面一行的最大值，然后相加每次往上，子问题是最优，则到最后也是最优.
 * 输出路径，根据辅助的二维数据进行从上往下递推
 * Created by Administrator on 2018/3/31.
 *
 * @author 丹丘生
 */
public class DP_2 {
    static int row;
    static int[][] arr;
    static int[][] sum;

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        row = read.nextInt();

        arr = new int[row][row];
        sum = new int[row][row];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = read.nextInt();
            }
        }

        //  赋值最后一行代码
        for (int i = 0; i < row; i++) {
            sum[row - 1][i] = arr[row - 1][i];
        }

        for (int i = row - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                sum[i - 1][j] = arr[i - 1][j] + Math.max(sum[i][j], sum[i][j + 1]);
            }
        }


        // 输出最大值
        System.out.println(sum[0][0]);

        // 打印数字路线
        int coll = 0;
        for (int i = 0; i < row; i++) {
            if (i == row - 1) {
                System.out.println(arr[i][coll] + " ");
                break;
            }
            System.out.println(arr[i][coll] + " ");
            if (arr[i][coll] + sum[i + 1][coll] < arr[i][coll] + sum[i + 1][coll + 1]) {
                coll = coll + 1;
            }
        }
    }
}
