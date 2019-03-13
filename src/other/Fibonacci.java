package other;


import java.util.Scanner;

/**
 * 斐波那契
 *
 * @author danqiusheng
 * @since 2019-03-10
 */
public class Fibonacci {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        int[] fi = new int[n];
        fi[0] = 0;
        fi[1] = 1;
        for (int i = 2; i < n; i++) {
            fi[i] = fi[i - 2] + fi[i - 1];
        }
        for (int i = 0; i < fi.length; i++)
            System.out.print(fi[i] + " ");
        System.out.println();
    }
}
