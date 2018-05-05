package other;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/3/13.
 * 全排列 回溯
 */
public class FullPermutation_2 {
    static int[] arr = {1, 2, 3, 4};
    static int count = 0;

    public static void main(String[] args) {
        doDeal(0);
        System.out.println(count);
    }

    private static void doDeal(int step) {
        if (step >= arr.length) {
            count++;
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = step; i < arr.length; i++) {
            swap(step, i);
            doDeal(step + 1);
            swap(step,i);
        }
    }

    private static void swap(int step, int i) {
        int tmp = arr[step];
        arr[step] = arr[i];
        arr[i] = tmp;
    }
}
