package other;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/3/13.
 * 全排列 回溯 去重
 */
public class FullPermutation_4 {
    static int[] arr = {4, 2, 3, 4};
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
            if (isRepeat(step, i)) {
                swap(step, i);
                doDeal(step + 1);
                swap(step, i);
            }


        }
    }

    // 当前步数和将要调换字母下标
    private static boolean isRepeat(int step, int end) {

        for (int i = step; i < end; i++) {
            if (arr[end] == arr[i])
                return false;
        }
        return true;
    }


    private static void swap(int step, int i) {
        int tmp = arr[step];
        arr[step] = arr[i];
        arr[i] = tmp;
    }

}
