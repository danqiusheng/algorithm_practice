package basic.第四章;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/6/7.
 * 思路：用数组存储数据，然后出队列的数据标记为1，再次进行循环的时候判断当前的下标是否访问
 *
 * @author 丹丘生
 */
public class DoleQueue {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        //------输入数据-----
        int n = read.nextInt();
        int k = read.nextInt();
        int m = read.nextInt();


        //-----初始化数组
        int[] arr = new int[n + 1];

        arr[0] = -1;
        //------循环出队列----
        int front = 0;
        int rear = n + 1;
        int total = n;
        // 如果当前的人数没有出完
        while (total != 0) {
            // 从A开始
            front = out(front, arr, k, 1, n);
            // 从B开始
            rear = out(rear, arr, m, -1, n);
            //  当前出队列的数据
            arr[front % (n + 1)] = 1; // 标记当前出队列的人
            arr[rear % (n + 1)] = 1;
            System.out.printf("%3d", front % (n + 1));
            total--;
            if (front % (n + 1) != rear % (n + 1)) {// 如果头尾不相逢
                System.out.printf("%3d", rear % (n + 1));
                total--;
            }
            if(total!=0){
                System.out.printf(",");
            }
        }
    }

    /**
     * @param direction 方向 头或者尾开始的下标
     * @param arr       数组
     * @param step      步数
     * @param every     每一步
     */
    private static int out(int direction, int[] arr, int step, int every, int total) {
        //-------只要找到一个，则退出---------
        int temp = 0;
        while (temp != step) {
            if (arr[(direction + every) % (total + 1)] == 0) {
                temp++;
                direction += every;

                // 如果达到尾
                if (direction == total + 1) {
                    direction = 1;
                }
                // 如果到达头
                else if (direction == 0) {
                    direction = total + 1;
                }
            } else {
                direction += every;
                if (direction == 0) {
                    direction = total + 1;
                }
            }
        }

        return direction;
    }


}
