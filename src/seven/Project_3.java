package seven;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/3/18.
 *     B      DEF
 A + --- + ------- = 10
      C      GHI

 注意float 和int 的区别
 */
public class Project_3 {
    static float[] arr =  {1,2,3,4,5,6,7,8,9};
    static boolean[] flag = new boolean[10];
    static float[] result = new float[10];
    static int count = 0;
    public static void main(String[] args) {
        doDeal(0);
        System.out.println(count);
    }

    private static void doDeal(int step) {

        if(step>=arr.length){
            check();
            return;
        }

        for(int i = 0 ;i<arr.length;i++){
            if(!flag[(int)arr[i]]){
                flag[(int)arr[i]] = true;
                result[step] = arr[i];
                doDeal(step+1);
                flag[(int)arr[i]] = false;
            }
        }
    }

    private static void check() {
        float A = result[0];
        float B = result[1]/result[2];
        float C = result[3]*100+result[4]*10+result[5];
        float D = result[6]*100+result[7]*10+result[8];
        if (A+B+C/D==10) {
            System.out.println(Arrays.toString(result));
            count++;
        }
    }
}
