package dp;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/3/31.
 * <p>
 * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，则他们的身高满足T1<...<Ti>Ti+1>…>TK(1<=i<=K)。
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 * <p>
 * 输入
 * <p>
 * 第一行是一个整数N(2<=N<=100)，表示同学的总数。第一行有n个整数，用空格分隔，第i个整数Ti(130<=Ti<=230)是第i位同学的身高(厘米)。
 * 输入示例
 * <p>
 * 8
 * 186 186 150 200 160 130 197 220
 * <p>
 * 输出示例
 * <p>
 * 4
 *
 * @author 丹丘生
 */
public class DP_7 {
    static int[] a;
    static int[] b;
    static int[] c;

    public static void main(String[] args) {
        int n, ans = 0, j, i;
        Scanner read = new Scanner(System.in);
        n = read.nextInt();
        a = new int[n];
        b = new int[n];
        c = new int[n];
        for (i = 0; i < n; i++) {
            a[i] = read.nextInt();
        }
        b[0] = 1;

        for (i = 1; i < n; i++) {// 从a[1]开始求最大严格上升子序列长度
            b[i] = 1;
            for (j = 0; j <= i; j++) {
                if (a[i] > a[j]) {
                    b[i] = Math.max(b[i], b[j] + 1);
                    //如果a[i]>a[j]，则可能从a[1]到a[i]的最大严格上升子序列长度又增加了1。
                }
            }
        }

        c[n - 1] = 1;
        for (i = n - 2; i >= 0; i--) {
            c[i] = 1;
            for (j = n - 1; j > i; j--) {
                if (a[i] > a[j]) {
                    c[i] = Math.max(c[i], c[j] + 1);
                }
            }
        }

        for (i = 0; i < n; i++) {
            if (b[i] + c[i] > ans) {
                ans = b[i] + c[i]; // 保留人数
            }
        }

        System.out.println(n - ans + 1); // 至少出队人数
    }
}
