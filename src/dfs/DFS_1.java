package dfs;

import java.util.Arrays;

/**
 * DFS
 * @author 丹丘生
 * 题目：1~9的全排
 */
public class DFS_1 {
    static int n ;
    static int[] a ;
    static int[] book;

    public static void main(String[] args) {
        n = 9;
        a = new int[n+1];
        book = new int[n+1];
        // 初始化a
        for(int i = 0;i<n+1;i++){
            book[i] = -1;
        }
        // 默认从0开始
        dfs(0);
    }

    // 深搜代码
    private static void dfs(int step) {
        if(step==10){// 代表全排完毕
            System.out.println(Arrays.toString(a));
            return ;
        }

        for(int i = 0;i<n+1;i++){
            if(book[i]==-1){ // 如果当前的数没有进行排序
                // 设置该数已经排序
                book[i] = 1;
                // 赋值
                a[step] = i;
                // 向下递归下一个数
                dfs(step + 1);
                book[i] = -1;
            }
        }

    }
}
