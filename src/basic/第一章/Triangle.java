package basic.第一章;

import java.util.Scanner;

/**
 * 判断是否为直角三角形
 * Created by Administrator on 2018/4/3.
 *
 * @author 丹丘生
 */
public class Triangle {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int a = read.nextInt();
        int b = read.nextInt();
        int c = read.nextInt();

        if(a*a+b*b==c*c||a*a+c*c==b*b||a*a==b*b+c*c){
            System.out.println("yes");
        }else{
            System.out.println("no a triangle");
        }
    }
}
