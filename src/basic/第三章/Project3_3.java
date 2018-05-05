package basic.第三章;

import java.util.Scanner;

/**
 * 蛇形填数
 * Created by Administrator on 2018/4/4.
 *
 * @author
 */
public class Project3_3 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        int[][] arr = new int[n][n];
        int total = 1;
        arr[0][n - 1] = 1;
        int x = 0;
        int y = n - 1;
        while (n * n > total) {
            while (x + 1 < n && arr[x + 1][y] == 0) arr[++x][y] = ++total;
            while (y - 1 >= 0 && arr[x][y - 1] == 0) arr[x][--y] = ++total;
            while (x - 1 >= 0 && arr[x - 1][y] == 0) arr[--x][y] = ++total;
            while (y + 1 < n && arr[x][y + 1] == 0) arr[x][++y] = ++total;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
