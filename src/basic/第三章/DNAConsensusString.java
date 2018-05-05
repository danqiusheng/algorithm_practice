package basic.第三章;

import java.util.Scanner;

/**
 * DNA序列（DNA Consensus String）
 * 题目：
 * 输入m个长度均为n的DNA序列，求一个DNA序列，到所有序列的总Hamming距离尽量
 * 小。 两个等长字符串的Hamming距离等于字符不同的位置个数，例如，ACGT和GCGA的
 * Hamming距离为2（左数第1, 4个字符不同）。
 * 输入整数m和n（4≤m≤50, 4≤n≤1000），以及m个长度为n的DNA序列（只包含字母
 * A，C，G，T），输出到m个序列的Hamming距离和最小的DNA序列和对应的距离。 如有多
 * 解，要求为字典序最小的解。 例如，对于下面5个DNA序列，最优解为TAAGATAC。
 * TATGATAC
 * TAAGCTAC
 * AAAGATCC
 * TGAGATAC
 * TAAGATGT
 * Created by Administrator on 2018/4/9.
 *
 * @author 丹丘生
 */
public class DNAConsensusString {
    static int m;
    static char[][] chs;
    static char[] chars = {'A', 'C', 'G', 'T'};

    static int hamming = 0;

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        m = read.nextInt();
        int n = read.nextInt();
        read.nextLine();

        chs = new char[m][n];

        for (int i = 0; i < m; i++) {
            chs[i] = read.nextLine().toCharArray();
        }


        for (int i = 0; i < n; i++) {
            char max = checkMax(i);
            System.out.print(max);
        }

        System.out.println(hamming);

    }

    private static char checkMax(int j) {
        int[] result = new int[4]; // A C G T
        for (int i = 0; i < m; i++) {
            switch (chs[i][j]) {
                case 'A':
                    result[0]++;
                    break;
                case 'C':
                    result[1]++;
                    break;
                case 'G':
                    result[2]++;
                    break;
                case 'T':
                    result[3]++;
                    break;
            }
        }
        // 排序
        int max = -1;
        int index = -1;
        for (int i = 0; i < 4; i++) {
            if (max < result[i]) {
                index = i;
                max = result[i];

            }
        }
        hamming += m - max;
        return chars[index];
    }
}
