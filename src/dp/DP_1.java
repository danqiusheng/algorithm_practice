package dp;

import java.util.Scanner;

/**
 * 经典的动态规划（采用回溯，不是最好的方式，时间效率比较）
 * 从上往下递归，遇到相同的数据还是相同的递归
 * Created by Administrator on 2018/3/25.
 *
 * @author 丹丘生
 */
public class DP_1 {
    static int row;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        row = read.nextInt();

        arr = new int[row][row];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = read.nextInt();
            }
        }
        System.out.println(MaxSum(0, 0));
    }

    private static int MaxSum(int i, int j) {
        if (i == row - 1) return arr[i][j];

        int down = MaxSum(i + 1, j);
        int right = MaxSum(i + 1, j + 1);
        if (down > right) return arr[i][j] + down;
        return arr[i][j] + right;
    }
}
