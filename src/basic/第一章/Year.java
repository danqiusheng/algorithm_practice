package basic.第一章;

import java.util.Scanner;

/**
 * 判断是否闰年
 * Created by Administrator on 2018/4/3.
 *
 * @author 丹丘生
 */
public class Year {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int year = read.nextInt();
        if(year%400==0||(year%4==0&&year%100!=0)){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}
