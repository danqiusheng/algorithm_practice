package basic.第三章;

import java.util.Scanner;

/**
 * WERTYU
 * Created by Administrator on 2018/4/4.
 * 题目：把手放在键盘上时，稍不注意就会往右错一位。这样，输入Q会变成输入W，输入J会变成输入K等。
 * 输入一个错位后敲出的字符串（所有字母均大写），输出打字员本来想打出的句子。输入保证合法，即一定是错位之后的字符串。例如输入中不会出现大写字母A。
 * 样例输入：O S, GOMR YPFSU/
 * 样例输出：I AM FINE TODAY.
 * 思路：将输入的作为数组，然后与静态常量进行匹配即可，再用一个字符串变量存储正确的字符。
 *
 * @author 丹丘生
 */
public class Project3_6 {
    static String str = "`1234567890-+QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String line = read.nextLine();
        char[] targets = line.toCharArray();
        String result = "";
        for (int i = 0; i < targets.length; i++) {
            int index = str.indexOf(targets[i]);
            if (index > 0) {
                char want = str.charAt(index - 1);
                result += want + "";
            } else {
                result += targets[i];
            }
        }
        System.out.println(result);
    }
}
