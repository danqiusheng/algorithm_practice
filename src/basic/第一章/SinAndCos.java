package basic.第一章;

import java.util.Scanner;

/**
 * 输入n，输出其正弦和余弦
 * Created by Administrator on 2018/4/3.
 *
 * @author 丹丘生
 */
public class SinAndCos {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        System.out.println(Math.sin(n));
        System.out.println(Math.cos(n));
    }
}
