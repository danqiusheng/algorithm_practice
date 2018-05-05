package basic.第二章;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/4/3.
 *
 * @author 丹丘生
 */
public class Hanxin {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int a = read.nextInt();
        int b = read.nextInt();
        int c = read.nextInt();
        boolean flag = true;
        for (int i = 10; i < 100; i++) {

            if (i % 3 == a && i % 5 == b && i % 7 == c) {
                flag = false;
                System.out.println(i);
                break;
            }
        }
        if (flag) {
            System.out.println("no Answer");
        }
    }
}
