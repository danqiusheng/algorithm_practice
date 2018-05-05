package basic.第二章;

import java.util.Scanner;

/**
 * 对于某个任意大于1的自然数n，若n为奇数，则将n变为3n+1，否则为n的一半 问题考虑溢出的问题
 * Created by Administrator on 2018/4/3.
 *
 * @author 丹丘生
 */
public class WhileProject {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        long n = read.nextInt();
        int count = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            count++;
        }
        System.out.println(count);
    }
}
