package dp;

import java.util.Scanner;

/**
 * DP_1的优化递归版本
 * Created by Administrator on 2018/3/31.
 * 采用标记数组来判断当前是否已经进行递归
 * @author 丹丘生
 */
public class DP_3 {
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
                sum[i][j] = -1;
            }
        }

        // System.out.println(MaxSum(0, 0));
        System.out.println(solve(0, 0));
    }

    // 优化MaxSum
    public static int solve(int i, int j) {
        if (sum[i][j] > -1) return sum[i][j];
        return sum[i][j] = arr[i][j] + (i == row - 1 ? 0 : Math.max(solve(i + 1, j), solve(i + 1, j + 1)));
    }


    private static int MaxSum(int i, int j) {
        if (i == row - 1) return arr[i][j];

        if (sum[i + 1][j] == -1)
            sum[i + 1][j] = MaxSum(i + 1, j);
        if (sum[i + 1][j + 1] == -1)
            sum[i + 1][j + 1] = MaxSum(i + 1, j + 1);

        if (sum[i + 1][j] > sum[i + 1][j + 1]) {
            return arr[i][j] + sum[i + 1][j];
        }
        return arr[i][j] + sum[i + 1][j + 1];
    }
}
