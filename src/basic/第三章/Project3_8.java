package basic.第三章;

import java.util.Scanner;

/**
 * 猜数字游戏的提示（Master-Mind Hints)
 * Created by Administrator on 2018/4/4.
 * 题目：
 * 实现一个经典"猜数字"游戏。 给定答案序列和用户猜的序列，统计有多少数字位置正确
 * （A），有多少数字在两个序列都出现过但位置不对（B）。
 * 输入包含多组数据。 每组输入第一行为序列长度n，第二行是答案序列，接下来是若干
 * 猜测序列。 猜测序列全0时该组数据结束。 n=0时输入结束。
 * 样例输入：
 4
 1 3 5 5
 5 5 1 3
 4 3 3 5
 6 5 5 1
 6 1 3 5
 1 3 5 5
 0 0 0 0
 * 10
 * 1 2 2 2 4 5 6 6 6 9
 * 1 2 3 4 5 6 7 8 9 1
 * 1 1 2 2 3 3 4 4 5 5
 * 1 2 1 3 1 5 1 6 1 9
 * 1 2 2 5 5 5 6 6 6 7
 * 0 0 0 0 0 0 0 0 0 0
 * 0
 *
 * 样例输出：
 * Game 1:
 * (1,1) //在第一个数据中只有一个正确， 一个在两个序列中出现但位置不对
 * (2,0)
 * (1,2)
 * (1,2)
 * (4,0)
 * Game 2:
 * (2,4)
 * (3,2)
 * (5,0)
 * (7,0)
 *
 * @author 丹丘生
 */
public class Project3_8 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        int n;  // 序列长度
        int[] correct; // 正确的结果
        int[] guess; // 猜的结果
        int num = 0; //次数
        while ((n = read.nextInt()) != 0) {
            System.out.println("Game " + (++num) + ":");

            correct = new int[n];
            guess = new int[n];

            // 获取正确的结果
            for (int i = 0; i < n; i++) {
                correct[i] = read.nextInt();
            }

            while (true) {
                int cor = 0;
                int zero = 0;
                // 获取猜测的结果
                for (int i = 0; i < n; i++) {
                    guess[i] = read.nextInt();
                    if (correct[i] == guess[i]) cor += 1;
                    if (guess[i] == 0) zero += 1;
                }

                if (zero == n) break;// 如果数组结果全部是0


                int wrong = 0;
                for (int i = 0; i < 10; i++) { // 统计0~9出现的数字
                    int one = 0;
                    int two = 0;
                    for (int j = 0; j < n; j++) {
                        if (correct[j] == i) one += 1;
                        if (guess[j] == i) two += 1;
                    }
                    if (one < two) // 将最小次数出现的作为出现次数
                        wrong += one;
                    else
                        wrong += two;
                }
                // 最后要减去重复的值
                // 本题存在疑问 如 3 1 5 5
                //                5 5 1 3  应该输出（0,4） 还是（0,3）
                System.out.println("(" + cor + "," + (wrong-cor) + ")");
            }
        }
    }
}


