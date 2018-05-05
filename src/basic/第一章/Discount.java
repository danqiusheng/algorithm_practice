package basic.第一章;

import java.util.Scanner;

/**
 * 输入购买衣服的件数
 * Created by Administrator on 2018/4/3.
 * @author  丹丘生
 */
public class Discount {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        int price = 95;
        if(n*price>=300){
            System.out.println(String.format("%.2f",n*price*0.85));
            System.out.printf("%.2f",n*price*0.85);
        }else{
            System.out.println(n*price);
        }
    }
}
