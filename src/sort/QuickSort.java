package sort;

import java.util.Arrays;

/**
 * 快速排序
 * 以一个数为基本点，然后进行排序
 *
 * @author 丹丘生
 */
public class QuickSort {

    // 待排序数组
    static int[] arr = {2, 3, 12, 313, 5435, 1, 5, 33, 246, 99};

    public static void main(String[] args) {
        sort(0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int left, int right) {

        if (left > right)// 这个不加入，报越界异常，因为没有出口
            return;

        // 标记左右
        int l = left;
        int r = right;

        // 以左边为基本点
        int tmp = arr[left];
        while (l != r) {
            while (arr[r] >= tmp && l < r) {
                r--;
            }
            while (arr[l] <= tmp && l < r) {
                l++;
            }
            if (l < r) {// 加入这个判断，用于当两者存在交换可能性时;
                // 交换
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }

        // 最终将基本点还原
        arr[left] = arr[r];
        arr[r] = tmp;

        sort(left, r - 1);
        sort(r + 1, right);
    }


}
