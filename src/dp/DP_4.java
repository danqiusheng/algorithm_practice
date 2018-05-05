package dp;

import java.util.Scanner;

/**
 * 最长上升子序列
 * Created by Administrator on 2018/3/31.
 * 比如，对于序列(1, 7, 3, 5, 9, 4, 8)，有它的一些上升子序列，如(1, 7), (3, 4, 8)等等。这些子序列中最长的长度是4，比如子序列(1, 3, 5, 8).
 * 你的任务，就是对于给定的序列，求出最长上升子序列的长度。
 * 思路： 将这些划分为子问题，然后单个求解，默认设最左边只有长度1，终点为最右边。然后根据动态规划，得到每一步子解的最优解，到最后一步，则所有的子解得到，然后遍历得到最大即可。
 * 1的最优解为1
 * 7的最优解为2
 * 3的最优解为2
 * 5的最优解为3 在3的基础上加上自身 （打印最长子序列的结果）
 *
 * @author 丹丘生
 */
public class DP_4 {
    static int length;
    static int[] arr;
    static int[] len;

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        length = read.nextInt();
        arr = new int[length];
        len = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = read.nextInt();
        }

        len[0] = 1;

        // 调用方法获取
        maxLen();


        int max = -1;
        for (int i = 0; i < length; i++) {
            if (max < len[i]) {
                max = len[i];
            }
        }


        System.out.println(max);
    }

    public static void maxLen() {
        for (int i = 1; i < length; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) { //
                    if (temp < len[j]) {
                        temp = len[j]; // 将前面的子解获取
                    }

                }
                len[i] = temp + 1; // 加上自身
            }

        }
    }
}