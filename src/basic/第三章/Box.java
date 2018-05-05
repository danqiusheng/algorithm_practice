package basic.第三章;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 盒子
 * Created by Administrator on 2018/05/02.
 * 给定6个矩形的长和宽wi和hi（1<=w, hi <= 1000），判断它们能否构成长方体的六个面。
 * Sample Input
 * 1345 2584
 * 2584 683
 * 2584 1345
 * 683 1345
 * 683 1345
 * 2584 683
 * <p>
 * 1234 4567
 * 1234 4567
 * 4567 4321
 * 4322 4567
 * 4321 1234
 * 4321 1234
 * Sample Output
 * POSSIBLE
 * IMPOSSIBLE
 * 思路： 根据矩形的特点，两两匹配即可
 *
 * @author 丹丘生
 */
public class Box {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        int count = 0;
        Rectan[] rectans = new Rectan[6];
        while (count <= 5) {
            String[] data = read.nextLine().split(" ");
            rectans[count] = new Rectan();
            if (Integer.parseInt(data[0]) > Integer.parseInt(data[1])) {
                rectans[count].l = Integer.parseInt(data[0]);
                rectans[count++].w = Integer.parseInt(data[1]);
            } else {
                rectans[count].l = Integer.parseInt(data[1]);
                rectans[count++].w = Integer.parseInt(data[0]);
            }

        }
        Arrays.sort(rectans);


        for (Rectan rectan : rectans) {
            System.out.println(rectan);
        }

        // 如果两两不等
        if ((rectans[0].l != rectans[1].l || rectans[0].w != rectans[1].w) || (rectans[2].l != rectans[3].l || rectans[2].w != rectans[3].w) || (rectans[4].l != rectans[5].l || rectans[4].w != rectans[5].w)) {
            System.out.println("IMPOSSIBLE");
        } else {
            if ((rectans[0].l != rectans[2].l) || (rectans[0].w != rectans[4].l) || (rectans[2].w != rectans[4].w))
                System.out.println("IMPOSSIBLE");
            else
                System.out.println("POSSIBLE");
        }
        //

    }

    static class Rectan implements Comparable<Rectan> {
        int l;
        int w;

        public int compareTo(Rectan o) {
            return -((this.l - o.l) + this.w - o.w);
        }

        public String toString() {
            return "Rectan{" +
                    "l=" + l +
                    ", w=" + w +
                    '}';
        }
    }
}
