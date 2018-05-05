package dfs;

/**
 * 暴力全排0~4
 * V2版本：递归
 * 边界点：多少个排序数
 * 重复内容：for循环
 *
 * @author danqiusheng
 */
public class NormalFullV2 {
    static int[] arr = new int[5];
    static int step_total = 5;
    static int count = 0;

    public static void main(String[] args) {
        full(1); // 1开始
        System.out.println("total count:" + count);
    }

    public static void full(int step) {
        if (step >= step_total) { // 出口;当下标超出
            int[] result = new int[5];// 判断是否重复
            boolean flag = true;
            for (int i = 1; i < step_total; i++) {
                result[arr[i]] += 1;
                if (result[arr[i]] > 1) flag = false; // 判断当前数字是否重复出现
            }
            if (flag) { // 所有的数字出现
                System.out.println(arr[1] + "" + arr[2] + "" + arr[3] + "" + arr[4]);
                count++;
            }
            return;
        }

        // 重复内容
        for (int i = 1; i < step_total; i++) {
            arr[step] = i; // 第step下标位置 放i
            full(step + 1);
        }
    }
}
