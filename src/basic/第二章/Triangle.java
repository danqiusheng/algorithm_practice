package basic.第二章;

import java.util.Scanner;

/**
 * 输出倒三角
 * Created by Administrator on 2018/4/3.
 *   #########
 *    #######
 *     #####
 *      ###
 *       #
 * @author 丹丘生
 */
public class Triangle {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        for (int i = n; i > 0; i--) {
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }
            for (int a = 0; a < 2 * i - 1; a++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
