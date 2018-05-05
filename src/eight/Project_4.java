package eight;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by Administrator on 2018/3/13.
 * 把一个小块当成一个整体：
 * 所以最后有：4块是绿黄橙，2块是绿橙橙，2块是绿黄黄。
 * 11112233 33221111是一种
 * 216种
 */
public class Project_4 {
    static int[] arr = {1, 1, 1, 1, 2, 2, 3, 3};

    static Map<String,Integer> map = new HashMap<String,Integer>();

    static int count = 0;
    public static void main(String[] args) {
        doDeal(0);
        System.out.println(count);
    }

    private static void doDeal(int step) {
        if (step >= arr.length) {
            // 存储结果
            toCheck();
            System.out.println(Arrays.toString(arr));
            return;
        }


        for (int i = step; i < arr.length; i++) {
            if (isRepeat(step, i)) {
                int temp = arr[step];
                arr[step] = arr[i];
                arr[i] = temp;
                doDeal(step + 1);
                temp = arr[step];
                arr[step] = arr[i];
                arr[i] = temp;
            }
        }

    }

    private static void toCheck() {
        StringBuffer str = new StringBuffer();
        for(int i : arr){
            str.append(i);
        }
        String rev = str.toString();
        Integer c = map.get(str.reverse().toString());
        if(c==null){
            count += 1;
            map.put(rev,0);
        }
    }


    private static boolean isRepeat(int step, int end) {
        for (int i = step; i < end; i++) {
            if (arr[end] == arr[i]) return false;
        }
        return true;
    }
}
