package dfs;

/**
 * 暴力全排0~4
 * 思路：四个循环，从1开始到4结束.在这里优化了一下，用数组存储，然后用另一个数组存储结果，之后相加个数就可以知道有没有数字重复。
 * 因为对于全排，只有1，2，3，4仅且出现1次。
 *
 * @author danqiusheng
 */
public class NormalFullV1 {

    public static void main(String[] args) {
        int count = 0;// 记录排序次数
        int[] arr = new int[5]; // 存储结果
        for (arr[1] = 1; arr[1] < 5; arr[1]++) {
            for (arr[2] = 1; arr[2] < 5; arr[2]++) {
                for (arr[3] = 1; arr[3] < 5; arr[3]++) {
                    for (arr[4] = 1; arr[4] < 5; arr[4]++) {
                        int[] result = new int[5];// 判断是否重复
                        boolean flag = true;
                        for (int i = 1; i < 5; i++) {
                            result[arr[i]] += 1;
                            if(result[arr[i]] > 1) flag = false; // 判断当前数字是否重复出现
                        }
                        if(flag){ // 所有的数字出现
                            System.out.println(arr[1] + "" + arr[2] + "" + arr[3] + "" + arr[4]);
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println("total count:"+count);
    }
}
