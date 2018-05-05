package basic.第二章;

/**
 * 用1,2,3，....，9组成3个三位数abc，def和ghi，每个数字恰好使用一次，要求abc:def:ghi=1:2:3。输出所有解。
 * Created by Administrator on 2018/4/4.
 *
 * @author 丹丘生
 */
public class Permutation {
    public static void main(String[] args) {
        int[] arr = new int[10];
        //这里最大三位数999 然后有三倍的关系 333 所以最小为329
        int def;
        int ghi;
        for (int abc = 123; abc <= 329; abc++) {
            def = 2 * abc;
            ghi = 3 * abc;

            arr[abc / 100] = arr[abc / 10 % 10] = arr[abc % 10] = 1;
            arr[def / 100] = arr[def / 10 % 10] = arr[def % 10] = 1;
            arr[ghi / 100] = arr[ghi / 10 % 10] = arr[ghi % 10] = 1;
            int count = 0;
            for (int i = 1; i <= 9; i++) {
                count += arr[i];
                arr[i] = 0;
            }

            if (count == 9)
                System.out.println(abc+"--"+def+"---"+ghi);
        }
    }
}
