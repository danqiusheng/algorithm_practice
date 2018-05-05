package seven;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/3/19.
     +--+--+--+
     |  |  |  |
 +--+--+--+--+
 |  |  |  |  |
 +--+--+--+--+
 |  |  |  |
 +--+--+--+

 填入0~9的数字。要求：连续的两个数字不能相邻。
 （左右、上下、对角都算相邻）
 一共有多少种可能的填数方案？
 想法：先全排，然后判断是否为对应想要的数据
 */
public class Project_6 {
    private static int[] arr = {0,1,2,3,4,5,6,7,8,9 } ;
    private static boolean[] flag = new boolean[11];
    private static int[] result  = new int[11];
    private static int count = 0;
    public static void main(String[] args) {
        dfs(1);
        System.out.println(count);
    }

    private static void dfs(int step) {
        if(step>arr.length){
            if(check(result)){
                System.out.println(Arrays.toString(result));
                count++;
            }
            return ;
        }

        for(int i = 0;i<arr.length;i++){
            if(!flag[arr[i]]){
                flag[arr[i]] = true;
                result[step]  = arr[i];
                dfs(step + 1);
                flag[arr[i]] = false;
            }
        }
    }

    // 判断数据是否成立
    private static boolean check(int[] a) {
        if ((a[1]==a[2]+1||a[1]==a[2]-1)||
                (a[1]==a[6]+1||a[1]==a[6]-1)||
                (a[1]==a[5]+1||a[1]==a[5]-1)||
                (a[1]==a[4]+1||a[1]==a[4]-1)) {
            return false;
        }else if ((a[2]==a[5]+1||a[2]==a[5]-1)||
                (a[2]==a[3]+1||a[2]==a[3]-1)||
                (a[2]==a[7]+1||a[2]==a[7]-1)||
                (a[2]==a[6]+1||a[2]==a[6]-1)) {
            return false;
        }else if ((a[3]==a[6]+1||a[3]==a[6]-1)||
                (a[3]==a[7]+1||a[3]==a[7]-1)) {
            return false;
        }else if ((a[4]==a[5]+1||a[4]==a[5]-1)||
                (a[4]==a[8]+1||a[4]==a[8]-1)||
                (a[4]==a[9]+1||a[4]==a[9]-1)) {
            return false;
        }else if ((a[6]==a[7]+1||a[6]==a[7]-1)||
                (a[6]==a[10]+1||a[6]==a[10]-1)||
                (a[6]==a[9]+1||a[6]==a[9]-1)) {
            return false;
        }else if (a[7]==a[10]+1||a[7]==a[10]-1) {
            return false;
        }else if (a[8]==a[9]+1||a[8]==a[9]-1) {
            return false;
        }else if (a[9]==a[10]+1||a[9]==a[10]-1) {
            return false;
        }else if ((a[5]==a[6]+1||a[5]==a[6]-1)||
                (a[5]==a[10]+1||a[5]==a[10]-1)||
                (a[5]==a[9]+1||a[5]==a[9]-1)||
                (a[5]==a[8]+1||a[5]==a[8]-1)) {
            return false;
        }
        return true;
    }
}
