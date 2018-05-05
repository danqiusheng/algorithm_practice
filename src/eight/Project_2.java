package eight;

/**
 * Created by Administrator on 2018/3/12.
 *
 * 要求每个边的和相等。
 下图就是一种排法

     A
   9 6
  4   8
 3 7 5 2

 如果考虑旋转、镜像后相同的算同一种
 */
public class Project_2 {

    static int[] first = new int[9];
    static int[] store = new int[9];
    static int sum = 0;

    public static void main(String[] args) {
        doDeal(0);
        System.out.println(sum / 6);
    }

    public static void doDeal(int code) {
        if (code == 9) {
            if (store[0] + store[1] + store[3] + store[5] == store[0] + store[2] + store[4] + store[8]
                    && store[0] + store[1] + store[3] + store[5] == store[5] + store[6] + store[7] + store[8])
                sum++;
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (first[i] == 0) {
                first[i] = 1;
                store[code] = i + 1; //存放值
                doDeal(code + 1);
                first[i] = 0;
            }
        }
    }
}
