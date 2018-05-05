package basic.第三章;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 分子量
 * 题目: 给出一种物质的分子式（不带括号），求分子量。本题中的分子式只包含4种原子，分
 * 别为C, H, O, N，原子量分别为12.01, 1.008, 16.00, 14.01（单位：g/mol）。例如，C6H5OH的
 * 分子量为94.108g/mol。
 * Sample Input
4
C
C6H5OH
NH2CH2COOH
C12H22O11
 * Sample Output
 * 12.010
 * 94.108
 * 75.070
 * 342.296
 * Created by Administrator on 2018/4/7.
 * 思路：遍历字符串即可,
 *
 * @author 丹丘生
 */
public class MolarMass {
    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<String, Double>();
        map.put("C", 12.01);
        map.put("H", 1.008);
        map.put("O", 16.00);
        map.put("N", 14.01);
        Scanner read = new Scanner(System.in);
        int count = read.nextInt();

        read.nextLine();
        while (count-- > 0) {
            String line = read.next();
            char[] chars = line.toCharArray();
            int length = line.length();
            if (length == 1) {
                System.out.println(map.get(line));
                continue;
            }
            double total = 0;

            String num = "";
            int target = -3;
            for (int i = 0; i < length; i++) {
                int current = i;
                if (Character.isDigit(chars[i])) {
                    num += chars[i];
                    continue;
                }
                if (Character.isAlphabetic(chars[i])) {
                    if (!num.equals("")) {
                        total += map.get(chars[target] + "") * Integer.parseInt(num);
                        num = "";
                    } else if (current == target + 1) {
                        total += map.get(chars[target] + "");
                    }
                }
                target = i;
            }
            if (!num.equals("")) {
                total += map.get(chars[target] + "") * Integer.parseInt(num);
            } else {
                total += map.get(chars[target] + "");
            }
            System.out.println(total);
        }

    }
}
