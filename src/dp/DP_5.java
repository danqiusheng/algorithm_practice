package dp;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/3/31.
 * 1
 * 3 8 17 20
 * 0 10 8
 * 0 10 13
 * 4 14 3
 * 输出样例
 * 23
 * hellp jimmy (题目，暂时没有做出来）
 * @author 丹丘生
 */
public class DP_5 {
    static int t; // 测试组数t
    static int N; // 是平台的数据
    static int X; // 开始下落的横坐标
    static int Y;  // 开始下落的竖坐标
    static int MAX;  //是一次下落的最大高度
    static Platform[] platforms;

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        t = read.nextInt();
        N = read.nextInt();
        X = read.nextInt();
        Y = read.nextInt();
        MAX = read.nextInt();
        platforms = new Platform[N];
        for (int i = 0; i < N; i++) {
            platforms[i] = new Platform();
            platforms[i].lx = read.nextInt();
            platforms[i].rx = read.nextInt();
            platforms[i].h = read.nextInt();
        }

        System.out.println(minTime(N - 1, true));

    }


    static int minTime(int L, boolean bLeft) {
        int y = platforms[L].h;
        int i, x;
        if (bLeft) {
            x = platforms[L].lx;
        } else
            x = platforms[L].rx;

        for (i = L + 1; i < N; i++) {
            if (platforms[i].lx <= x && platforms[i].rx >= x) {
                break;
            }
        }
        if (i <= N) {
            if (y - platforms[i].h > MAX) { // 太高
                return Integer.MAX_VALUE;
            }
        }
        return 0;
    }

    //从大到小排序
    static class Platform implements Comparable<Platform> {
        int lx;
        int rx;
        int h;

        @Override
        public int compareTo(Platform o) {
            return o.h - this.h;
        }
    }
}
