package seven;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/3/19.
 * 有12张连在一起的12生肖的邮票。
 现在你要从中剪下5张来，要求必须是连着的。
 （仅仅连接一个角不算相连）

  第一步：1~12的数据抽取5个 并且不能重复
  第二步：进行判断是否满足要求
 */
public class Project_7 {
    private static int count = 0;
    private static int[] arr = new int[5];
    public static void main(String[] args) {
        for(arr[0] = 0 ;arr[0] <12 ;arr[0]++){
            for(arr[1] =arr[0]+ 1; arr[1]<12;arr[1]++){
                for(arr[2] = arr[1]+ 1;  arr[2]<12;arr[2]++){
                    for(arr[3] =arr[2]+ 1 ;  arr[3]<12;arr[3]++){
                        for(arr[4] =arr[3]+ 1;  arr[4]<12;arr[4]++){
                           if(check()){
                               count++;
                               System.out.println(Arrays.toString(arr));
                           }
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }

    private static boolean check() {
        boolean visit[]=new boolean[5];
        dfs(visit,0);
        return visit[0]&&visit[1]&&visit[2]&&visit[3]&&visit[4];
    }

    public static void dfs(boolean[] visit,int j){
        visit[j]=true;//代表可访问，访问过
        for(int i=0;i<visit.length;i++){
            if(!visit[i]&&(arr[j]/4==arr[i]/4)&&(arr[j]==arr[i]+1||arr[j]==arr[i]-1)){
                dfs(visit,i);
            }
            if(!visit[i]&&(arr[j]==arr[i]+4||arr[j]==arr[i]-4)){
                dfs(visit,i);
            }
        }
    }
}
