package other;

import java.util.Scanner;

/**
 * 解密QQ，用于队列，出队列，进队列
 *
 * @author 丹丘生
 */
public class SecretQQ {
    public static void main(String[] args) {
        // String QQ = "631758924";
        Scanner read = new Scanner(System.in);
        String QQ = read.nextLine();
        char[] chs = new char[2 * QQ.length()];
        for (int index = 0; index < QQ.length(); index++) {
            chs[index] = QQ.charAt(index);
        }

        // 删除某数， 再将某数添加到末尾
        int head = 0;
        int tail = QQ.length();

        while (head < tail) {
            System.out.printf("%c", chs[head]);
            head++;
            chs[tail] = chs[head];
            tail++;
            head++;
        }

    }
}
