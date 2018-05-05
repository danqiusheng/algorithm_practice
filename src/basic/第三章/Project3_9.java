package basic.第三章;

import java.util.Scanner;

/**
 * 生成元(Digit Generator)
 * Created by Administrator on 2018/4/7.
 * 题目：如果 x 加上 x 的各个数字之和得到的 y，就说 x 是 y 的生成元。给出 n (1 <= n <= 100000)，求最小生成元。无解输出 0。
 * 例如，n = 216，121，2005 时的解分别为 198，0，1979。
 * 思路：
 *
 * @author 丹丘生
 */
public class Project3_9 {
    static int[] arr = new int[200005];

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        forSolve(n);
        forSolveByTable(n);
    }

    // 书上采用打表方式
    // 加载一次打表，然后直接取数据 这样适用于 多次数据生成元
    private static void forSolveByTable(int n) {

        for (int i = 1; i <= 100000; i++) {
            int sum = i;
            int j = i;
            while (j > 0) {
                sum += j % 10;
                j /= 10;
            }

            if (arr[sum] == 0 || arr[sum] > i) {
                arr[sum] = i;
            }

        }
        System.out.println(arr[n]);
    }

    // 这个方法时遍历n-1
    private static void forSolve(int n) {
        int sum = 0;
        int index = 0;
        for (index = 1; index < n - 1; index++) {
            sum = index;
            int j = index;
            while (j > 0) {
                sum += j % 10;
                j /= 10;
            }
            if (sum == n) break;
        }
        if (index == n - 1) {
            System.out.println(0);
            return;
        }

        System.out.println(index);
    }

}
