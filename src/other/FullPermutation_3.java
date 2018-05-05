package other;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/3/13.
 * 全排列 DFS
 */
public class FullPermutation_3 {
    static int[] arr = {1, 2, 3, 4};
    // DFS的标志
    static boolean[] flag = new boolean[4];
    static int[] array = new int[4];
    static int count = 0;

    public static void main(String[] args) {
        doDeal(0);
        System.out.println(count);
    }

    private static void doDeal(int step) {
        if (step >= arr.length) {
            count++;
            System.out.println(Arrays.toString(array));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!flag[i]) {
                // 这个就是标志
                flag[i] = true;
                // 设置值
                array[step] = arr[i];
                // 继续深搜
                doDeal(step + 1);
                flag[i] = false;
            }
        }
    }

}
