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
        // 得商
        int x = a / b;
        // 得余数
        int temp = a % b; // temp变量用于标记循环小数的开始， 在temp之前的都不是循环小数
        // 得到剩余待除
        a = a % b * 10;

        int index = 0;
        while (tep[temp] == 0) {    // 如果当前的余数没有相同的
            int yu = a / b;         // 得商
            arr[++index] = yu;      // 存储该商
            tep[temp] = index;      // 存储余数的下标
            temp = a % b;           // 得余数
            a = a % b * 10;         // 得到剩余待除
        }


        //arr[1]=1 arr[2]=6
        //temp[1]= 1 temp[4]=2
        //temp=4  index=2
        System.out.print(x + ".");
        if (a == 0) {// 如果被整除
            for (int i = 1; i < index; i++)
                System.out.print(arr[i]);
            System.out.println("(0)");
            System.out.println(1);
            return;
        }

        // 如果没有整除
        for (int i = 1; i < tep[temp]; i++) { // 在之前的不是循环小数
            System.out.print(arr[i]);
        }
        System.out.print("(");
        for (int i = tep[temp]; i <= index && i <= tep[temp] + 100; i++) {
            System.out.print(arr[i]);
        }
        System.out.println(")");
        System.out.println(index - tep[temp] + 1);
    }
}
