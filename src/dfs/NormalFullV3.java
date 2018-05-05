package dfs;

/**
 * 暴力全排0~4
 * V3版本：递归时判断当前数是否重复
 * 边界点：多少个排序数
 * 重复内容：for循环
 *
 * @author danqiusheng
 */
public class NormalFullV3 {
    static int[] arr = new int[5]; // 存储结果数组
    static int[] result = new int[5];// 判断是否重复
    static int step_total = 5;
    static int count = 0;

    public static void main(String[] args) {
        full(1); // 1开始
        System.out.println("total count:" + count);
    }

    public static void full(int step) {
        if (step >= step_total) { // 出口;当下标超出
            System.out.println(arr[1] + "" + arr[2] + "" + arr[3] + "" + arr[4]);
            count++;
            return;
        }
        // 重复内容
        for (int i = 1; i < step_total; i++) {
            if (result[i] == 0) { // 如果当前数没有被全排
                result[i] = 1; // 标记当前数已经全排
                arr[step] = i; // 第step下标位置 放i
                full(step + 1);
                result[i] = 0;  // 标记当前数不全排
            }
        }
    }
}
