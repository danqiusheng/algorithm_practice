package basic.第三章;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 谜题（Puzzle）
 * 题目：有一个5*5的网格，其中恰好有一个格子是空的，其他格子各有一个字母。一共有4种指令：A, B, L, R，分别表示把空格上、下、左、右的相邻字母移到空格中。
 * 输入初始网格和指令序列（以数字0结束），输出指令执行完毕后的网格。如果有非法指令，应输出“This puzzle has no final configuration.” ()
 * Created by Administrator on 2018/4/8.
 样例输入
TRGSJ
XDOKI
M VLN
WPABE
UQHCF
ARRBBL0
ABCDE
FGHIJ
KLMNO
PQRS
TUVWX
AAA
LLLL0
ABCDE
FGHIJ
KLMNO
PQRS
TUVWX
AAAAABBRRRLL0
 Z

样例输出
 Puzzle #1:
 T R G S J
 X O K L I
 M D V B N
 W P   A E
 U Q H C F

 Puzzle #2:
 A B C D
 F G H I E
 K L M N J
 P Q R S O
 T U V W X

 Puzzle #3:
 This puzzle has no final configuration.
 * @author 丹丘生
 */
public class Puzzle {
   static  char[][] chs = new char[5][5];
   static Map<String,Point> map = new HashMap<String,Point>();
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int x = 0;
        int y = 0;
        for(int i = 0;i<5;i++){
            chs[i] = read.nextLine().toCharArray();
            for(int j = 0;j<5;j++){
                if(chs[i][j]==' ') {
                    x = i;
                    y = j;
                }
            }
        }

        String direction = "";
        while(true){
            String str = read.nextLine();
            direction += str;
            if(str.lastIndexOf('0')>0)break;
        }

        map.put("A",new Point(-1,0));
        map.put("B",new Point(1,0));
        map.put("L",new Point(0,-1));
        map.put("R",new Point(0,1));

        boolean flag = true;
        int length = direction.length()-1;
        char[] directions = direction.toCharArray();
        for(int i = 0 ;i<length;i++){
            Point point = map.get(directions[i]+"");
            int cX = x+point.x;
            int cY = y + point.y;
            if(cX<0||cY<0||cX>=5||cY>=5){
                System.out.println("This puzzle has no final configuration");
                flag = false;
                break;
            }


            // 字符对换，空白转移
            chs[x][y] = chs[cX][cY];
            chs[cX][cY] = ' ';
            x = cX;
            y = cY;

        }

        if(!flag) return;
        for(int i = 0 ;i<5;i++){
            System.out.println(Arrays.toString(chs[i]));
        }


    }
    static class Point{
        int x;
        int y ;
        Point(){

        }
        Point(int x , int y ){
            this.x = x;
            this.y = y;
        }
    }
}
