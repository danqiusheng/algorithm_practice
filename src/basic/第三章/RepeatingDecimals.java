package basic.第三章;

import java.util.Scanner;

/**
 * 循环小数（Repeating  Decimals)
 * 题目：
 * 输出a/b的循环小数表示以及循环节长度
 * Created by Administrator on 2018/4/12.
 * <p>
 * 第一步：先算出 a/b 的 商
 * 第二步：算出 a%b 的余数
 * 第三步：循环计算  （余数远远小于除数，所以需要将余数扩大10倍，然后再被除数相除,然后循环）
 *
 * @author 丹丘生
 */
public class RepeatingDecimals {
    static int[] arr = new int[3000 + 5];
    static int[] tep = new int[3000 + 5];

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int a = read.nextInt();
        int b = read.nextInt();

        int x = a / b;
        int temp = a % b * 10;

        int index = 0;

        while (tep[temp] == 0) {
            int yu = temp / b;
            tep[temp] = 1;
            arr[index++] = yu;
            temp = temp % b * 10;
        }


        System.out.print(x+".(");
        for (int i = 0; i < index; i++) {
            System.out.print(arr[i]);
        }
        System.out.println(")");

        System.out.println(index);
    }
}
