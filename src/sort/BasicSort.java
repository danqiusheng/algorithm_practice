package sort;

import java.util.Arrays;

/**
 * 基本排序
 * 1. 冒泡排序
 * 2. 选择排序
 * 3. 插入排序
 *
 * @author 丹丘生
 */
public class BasicSort {
    // 待排序数组
    static int[] arr = {2, 3, 12, 313, 5435, 1, 5, 33, 246, 99};
    static int[] array = {2, 36, 12, 313, 5435, 1, 5, 33, 246, 99};
    static int[] number = {2, 38, 12, 313, 5435, 1, 5, 33, 246, 99};

    public static void main(String[] args) {
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        selectSort(array);
        System.out.println(Arrays.toString(array));
        insertSort(number);
        System.out.println(Arrays.toString(number));
    }

    // 冒泡排序
    private static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 选择排序
    public static void selectSort(int[] arr) {
        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {// 找出比min下标对应的数据还小的数据
                    min = j;
                }
            }
            // 交换一次
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }


    // 插入排序
    //static int[] number = {2, 38,12, 313, 5435, 1, 5, 33, 246, 99};
    public static void insertSort(int[] number) {
        //
        for (int i = 1; i < number.length; i++) {
            int tmp = number[i]; //
            int j = i; // 1
            while (j > 0 && tmp < number[j - 1]) {
                number[j] = number[j - 1];
                j--;
            }
            number[j] = tmp;
        }
    }
}
