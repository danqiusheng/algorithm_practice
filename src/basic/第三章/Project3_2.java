package basic.第三章;

import java.util.Scanner;

/**
 * 程序3-2 开灯问题
 * Created by Administrator on 2018/4/4.
 *
 * @author 丹丘生
 */
public class Project3_2 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        int k = read.nextInt();

        int[] arr = new int[n + 1];

        for (int i = 2; i <= k; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (j % i == 0) {
                    arr[j] = arr[j] == 0 ? 1 : 0;
                }
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) System.out.print(i + " ");
        }
    }
}
