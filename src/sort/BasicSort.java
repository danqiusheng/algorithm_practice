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
    static int[] number = {2, 38,12, 313, 5435, 1, 5, 33, 246, 99};

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
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


    // 插入排序
    //static int[] number = {2, 38,12, 313, 5435, 1, 5, 33, 246, 99};
    public static void insertSort(int[] number) {
        for (int i = 1; i < number.length; i++) {
            int tmp = number[i]; //38
            int j = i - 1; //0
            while (tmp < number[j]) {
                number[j + 1] = number[j];
                j--;
                if (j == -1) break;
            }
            number[j + 1] = tmp;
        }
    }


}
