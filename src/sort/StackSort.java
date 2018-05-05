package sort;

import java.util.Scanner;

/**
 * 栈排序
 *
 * @author 丹丘生
 * 回文判断
 * 将字符串的一半存储到数组中，然后进行匹配
 */
public class StackSort {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String str = read.nextLine();
        ifAll(str);
        isAll(str);
        checkAll(str);
    }

    public static void ifAll(String str) {
        long start = System.currentTimeMillis();
        int len = str.length();
        int index = len % 2 == 0 ? len / 2 : len / 2 + 1;
        char[] arr = new char[index];

        // 进栈
        for (int i = 0; i < len / 2; i++) {
            arr[i] = str.charAt(i);
        }

        for (int i = len / 2 - 1; i >= 0; i--) {
            if (arr[i] != str.charAt(len - i - 1)) {
                System.out.println(str + "不是回文");
                System.out.println("耗时：" + (System.currentTimeMillis() - start));
                return;
            }
        }
        System.out.println(str + "是回文");
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }


    // 改版
    public static void isAll(String str) {
        long start = System.currentTimeMillis();
        int middle = str.length() % 2 == 0 ? str.length() / 2 : str.length() / 2 + 1;
        char[] arr = new char[middle];

        // 进栈
        int top = 0;
        for (int index = 0; index < middle; index++) {
            arr[top++] = str.charAt(index);
        }
        // 出栈并进行比对
        for (int index = middle; index < str.length(); index++) {
            if (str.charAt(index) != arr[--top]) {
                System.out.println(str + "不是回文");
                System.out.println("耗时：" + (System.currentTimeMillis() - start));
                return;
            }
        }
        System.out.println(str + "是回文");
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }


    public static void checkAll(String str) {
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer(str);
        if (sb.reverse().toString().equals(str)) {
            System.out.println(str + "是回文");
            return;
        }
        System.out.println(str + "不是回文");
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }
}




