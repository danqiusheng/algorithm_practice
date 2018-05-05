package basic.第三章;

import java.util.Scanner;

/**
 * 纵横字谜的答案
 * Created by Administrator on 2018/4/8.
 * Sample Input
 * 2 2
 * AT
 * O
 * 6 7
 * AIM*DEN
 * ME*ONE
 * UPON*TO
 * SO*ERIN
 * SA*OR*
 * IES*DEA
 * 0
 * Sample Output
 * puzzle #1:
 * Across
 * 1.AT
 * 3.O
 * Down
 * 1.A
 * 2.TO
 * <p>
 * puzzle #2:
 * Across
 * 1.AIM
 * 4.DEN
 * 7.ME
 * 8.ONE
 * 9.UPON
 * 11.TO
 * 12.SO
 * 13.ERIN
 * 15.SA
 * 17.OR
 * 18.IES
 * 19.DEA
 * Down
 * 1.A
 * 2.IMPOSE
 * 3.MEO
 * 4.DO
 * 5.ENTIRE
 * 6.NEON
 * 9.US
 * 10.NE
 * 14.ROD
 * 16.AS
 * 18.I
 * 20.A
 *
 * @author 丹丘生
 */
public class CrossedAnswers {
    static char[][] chs;
    static int[][] arrs;
    static int r;
    static int c;

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (true) {
            r = read.nextInt();
            if (r == 0) break;
            c = read.nextInt();
            read.nextLine();

            chs = new char[r][c];
            arrs = new int[r][c];
            int index = 1;
            int count = 0;
            for (int i = 0; i < r; i++) {
                chs[i] = read.nextLine().toCharArray();
                for (int j = 0; j < c; j++) {
                    if (chs[i][j] == '*') continue;
                    int left = j - 1; // 左边 不是白格
                    int up = i - 1; // 向上  不是白格
                    if (left < 0 || up < 0) {
                        arrs[i][j] = index++;
                    } else if (left >= 0 && up >= 0 && (chs[i][left] == '*' || chs[up][j] == '*')) {
                        arrs[i][j] = index++;
                    }
                }
            }

            System.out.printf("puzzle #%d:", (++count));
            System.out.println();
            printRow();
            printCol();
        }

    }

    // Down
    private static void printCol() {
        System.out.println("Down");
        int col = 0;
        int index = -1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 判断左上
                int left = j - 1;
                int up = i - 1;
                String str = "";

                // 如果当前是* 则继续
                if (chs[i][j] == '*') continue;

                // 如果上一个不是* 则当前不是起始格
                if (up > 0) {
                    if (chs[up][j] != '*') continue;
                }

                if (left < 0 || up < 0) { // 判断最开始
                    get(i, j, str);

                } else if (left >= 0 && up >= 0 && chs[up][j] == '*') {
                    get(i, j, str);

                }
            }
        }
    }

    private static void get(int i, int j, String str) {
        int index;
        index = arrs[i][j];
        for (int m = i; m < r; m++) {
            if (chs[m][j] != '*')
                str += chs[m][j];//
            else {
                System.out.printf("%3d.%s", index, str);
                System.out.println();
                index = -1;
                str = "";
                break;
            }
        }
        if (!str.equals("") && index != -1) {
            System.out.printf("%3d.%s", index, str);
            System.out.println();
        }
    }

    // Across

    private static void printRow() {
        System.out.println("Across");
        for (int i = 0; i < r; i++) {
            int index = -1;
            String str = "";
            for (int j = 0; j < c; j++) {
                if (chs[i][j] != '*') {
                    if (str.length() == 0) {
                        index = arrs[i][j];
                    }
                    str += chs[i][j];
                }

                if (chs[i][j] == '*') {
                    if (str.equals("")) continue;
                    System.out.printf("%3d.%s", index, str);
                    System.out.println();
                    str = "";
                    index = -1;
                }
            }
            if (!str.equals("") && index != -1) {
                System.out.printf("%3d.%s", index, str);
                System.out.println();
            }
        }
    }

}
