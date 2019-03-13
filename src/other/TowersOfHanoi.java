package other;

import java.util.Scanner;

/**
 * 河内塔
 *
 * @author danqiusheng
 * @since 2019-03-10
 */
public class TowersOfHanoi {
    static int count = 0;

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        hanoi(n, 'A', 'B', 'C'); // 初始化，三个柱子
    }

    public static void hanoi(int n, char a, char b, char c) {// 第几个盘子， 参数意思，from temp to 通过temp将from的盘子转移到to；
        if (n == 1) {
            System.out.printf("第%d次: %c---to--%c\n", ++count, a, c);
        } else {
            hanoi(n - 1, a, c, b);
            System.out.printf("第%d次: %c---to--%c\n", ++count, a, c);
            hanoi(n - 1, b, a, c);
        }
    }
}
