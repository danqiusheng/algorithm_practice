package other;

import java.util.Scanner;

/**
 * <= 24 根火柴
 * 示例输入:
 * 18
 * <p>
 * 0+4=4
 * 0+11=11
 * 1+10=11
 * 2+2=4
 * 2+7=9
 * 4+0=4
 * 7+2=9
 * 10+1=11
 * 11+0=11
 *
 * 效果很慢...
 */
public class 火柴棍 {

    // 计算当前的数字要多少火柴棍
    public static int calc(int x) {

        int[] arr = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
        int num = 0;
        while (x / 10 != 0) {
            num += arr[x % 10];
            x /= 10;
        }

        num += arr[x];
        return num;
    }

    public static void main(String[] args) {
        int sum = 0;

        Scanner read = new Scanner(System.in);
        int n = read.nextInt();// 读取火柴棍的个数
        read.close();
        // 初始化操作
        long start = System.currentTimeMillis();
        for (int a = 0; a < 11111; a++) {
            for (int b = 0; b < 11111; b++) {
                int c = a + b; // 相加求C ，遍历C，则多一层 计算为n的三次方
                if (calc(a) + calc(b) + calc(c) == n - 4) {
                    System.out.println(a + "+" + b + "=" + c);
                    sum++;
                }
            }
        }
        System.out.println("可以拼出.." + sum);
        System.out.println(System.currentTimeMillis()-start);
        return;
    }
}
