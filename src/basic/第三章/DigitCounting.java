package basic.第三章;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 数数字
 * 直接遍历 ， 对数组进行相加即可
 * Created by Administrator on 2018/4/7.
 *
 * @author 丹丘生
 */
public class DigitCounting {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String line = read.nextLine();
        int[] arr = new int[10];

        int length = line.length();
        for (int i = 0; i < length; i++) {
            char ch = line.charAt(i);
            arr[Integer.parseInt(ch + "")]++;
        }
        System.out.println(Arrays.toString(arr));
    }
}
