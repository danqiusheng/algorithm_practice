package other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/13.
 * 全排列   去重
 */
public class FullPermutation_5 {
    static int[] arr = {1,2,4,4};
//    static int[] arr = {1, 1, 1, 1, 2, 2, 3, 3};
    static int count = 0;

    static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        calCount();
        doDeal(0, "");
        System.out.println(count);
    }

    private static void calCount() {
        for (int i : arr) {
            map.put(i, map.get(i) == null ? 1 : map.get(i) + 1);
        }
    }

    private static void doDeal(int step, String str) {
        if (step >= arr.length) {
            count++;
            System.out.println(str);
            return;
        }

        for (int key : map.keySet()) {
            if (map.get(key) > 0) {
                map.put(key, map.get(key) - 1);
                doDeal(step + 1, str + " " + key);
                map.put(key, map.get(key) + 1);
            }
        }
    }

}
