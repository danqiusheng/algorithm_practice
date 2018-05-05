package basic.第一章;

import java.util.Scanner;

/**
 * 连续和
 * Created by Administrator on 2018/4/3.
 * 输出1+2+...+n
 *
 * @author 丹丘生
 */
public class Sum {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();

        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        // for循环解决
        System.out.println(sum);
        // 递归
        System.out.println(getSum(n));
        // 最快捷
        System.out.println(((1 + n) * n) / 2);

    }

    private static int getSum(int step) {
        if (step == 1) return 1;
        return step + getSum(step - 1);
    }
}
