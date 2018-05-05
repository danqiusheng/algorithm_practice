package basic.第三章;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 子序列（All in All)
 * Created by Administrator on 2018/4/12.
 *
 * @author 丹丘生
 */
public class AllInAll {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String[] str = read.nextLine().split(" ");
        String s = str[0];
        String t = str[1];
        char[] chs = s.toCharArray();
        String tmp = t;
        int[] arr = new int[chs.length];
        for (int i = 0; i < chs.length; i++) {
            arr[i] = -1;
        }
        for (int i = 0; i < chs.length; i++) {
            Pattern pattern = Pattern.compile(chs[i] + "");
            Matcher matcher = pattern.matcher(t);
            while (matcher.find()) {  //查找符合规则的子串
                if (i == 0) {
                    arr[i] = matcher.start() == 0 ? 0 : arr[i] == -1 ? matcher.start() : matcher.start() < arr[i] ? matcher.start() : arr[i];
                } else if (matcher.start() < arr[i - 1]) {
                    continue;
                } else {
                    arr[i] = arr[i] == -1 ? matcher.start() : matcher.start() < arr[i] ? matcher.start() : arr[i];
                }
            }
        }
        int length = arr.length;
        boolean flag = true;
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] == -1) flag = false;
            if (arr[i] > arr[i + 1]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("yes");
        } else
            System.out.println("no");

    }
}
