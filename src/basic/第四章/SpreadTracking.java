package basic.第四章;

import java.util.*;

/**
 * Created by Administrator on 2018/7/30.
 * 有一个r行c列的电子表格，行从上到下编号为1~r，列从左到右编号为1~c。对其进行n个操作。操作类型分为5种：
 * 1. 删除行 2. 删除列 3. 插入行 4. 插入列 5. 交换两个元素位置
 * 输入初始查找位置，输出经过n个操作后，变更的位置。
 * 输入：
 * 7 9
 * 5
 * DR  2  1 5
 * DC  4  3 6 7 9
 * IC  1  3
 * IR  2  2 4
 * EX  1 2 6 5
 * 4
 * 4 8
 * 5 5
 * 7 8
 * 6 5
 * 0 0
 * 输出：
 * Spreadsheet #1
 * Cell data in (4,8) moved to (4,6)
 * Cell data in (5,5) GONE
 * Cell data in (7,8) moved to (7,6)
 * Cell data in (6,5) moved to (1,2)
 *
 * @author danqiusheng
 */
public class SpreadTracking {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        // 输入行列
        int r = read.nextInt();
        int c = read.nextInt();
        // 输入次数操作
        int count = read.nextInt();
        String[] opes = new String[count];

        read.nextLine();

        int index = 0;
        while (count-- != 0) { // 将操作符存储
            opes[index++] = read.nextLine();
        }

        int q = read.nextInt();
        while (q-- != 0) {
            // 一对0表示结束
            int x = read.nextInt();
            int y = read.nextInt();
            if (x == 0 && y == 0) break;
            doDeal(x, y, opes);
        }
    }

    // 最后x，y的出处
    private static void doDeal(int x, int y, String[] opes) {
        int length = opes.length;
        int ox = x;
        int oy = y;
        boolean flag = true;
        for (int index = 0; index < length; index++) {
            opes[index] = opes[index].replaceAll("  ", " ");
            String[] arrs = opes[index].split(" ");

            // 后面需要排序，从大到小
            List<Integer> list = new ArrayList<>();
            for (int j = 2; j < arrs.length; j++) {
                list.add(Integer.parseInt(arrs[j]));
            }
            Collections.sort(list);

            if ("DC".equalsIgnoreCase(arrs[0])) { //  删除列
                for (int i = list.size() - 1; i >= 0; i--) {
                    if (y == list.get(i)) {
                        flag = false;
                    }
                    if (y > list.get(i)) {
                        y--;
                    }
                }
            } else if ("DR".equalsIgnoreCase(arrs[0])) { // 删除行
                for (int i = list.size() - 1; i >= 0; i--) {
                    if (list.get(i) == x) {
                        flag = false;
                    }
                    if (list.get(i) < x) {
                        x--;
                    }
                }

            } else if ("IC".equalsIgnoreCase(arrs[0])) {// 插入列
                for (int i = list.size() - 1; i >= 0; i--) {
                    if (y >= list.get(i)) {
                        y++;
                    }
                }
            } else if ("IR".equalsIgnoreCase(arrs[0])) {// 插入行
                for (int i = list.size() - 1; i >= 0; i--) {
                    if (x >= list.get(i)) {
                        x++;
                    }
                }
            } else if ("EX".equalsIgnoreCase(arrs[0])) { // 交换
                if ((Integer.parseInt(arrs[1]) == ox && Integer.parseInt(arrs[2]) == oy)) {
                    x = Integer.parseInt(arrs[3]);
                    y = Integer.parseInt(arrs[4]);
                } else if ((Integer.parseInt(arrs[3]) == ox && Integer.parseInt(arrs[4]) == oy)) {
                    x = Integer.parseInt(arrs[1]);
                    y = Integer.parseInt(arrs[2]);
                }
            }

        }
        if (!flag) {
            System.out.println(" Cell data in (" + ox + "," + oy + ") GONE");
        } else
            System.out.println(" Cell data in (" + ox + "," + oy + ") moved to (" + x + "," + y + ")");
    }
}
