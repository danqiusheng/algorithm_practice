package other;

/**
 * Created by Administrator on 2018/3/13.
 * 全排列
 */
public class FullPermutation_1 {
    static int[] arr = {1, 2, 3, 4};
  static int count = 0;
    public static void main(String[] args) {
        doDeal(0, "");
        System.out.println(count);
    }

    private static void doDeal(int step, String str) {
        if (step >= arr.length) {
            count++;
            System.out.println(str);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
           // String tmp = str;
            if (!str.contains(arr[i] + "")) {
                doDeal(step + 1,   str +" " +arr[i]);
            }
        }
    }
}
