package basic.第三章;

import java.util.Scanner;

/**
 * 回文词（Palindromes)
 * Created by Administrator on 2018/4/4.
 * 题目： 输入一个字符串，判断它是否为回文以及镜像串。输入字符串保证不含数字0.所谓回文串，就是反转之后原串相同，如abba和madam。
 * 所谓镜像串，就是左右镜像之后和原串相同，如2S和3AIAE。注意，并不是每个字符在镜像之后都能得到一个合法字符，
 * 本题中，每个字符的镜像如下所示，（空白项表示该字符镜像后不能得到一个合法的字符）。
 * 样例输入：
 * NOTAPALINDROME
 * ISAPALINILAPASI
 * 2A3MEAS
 * ATOYOTA
 * 样例输出：
 * NOTAPALINDROME -- is not a palindrome.
 * <p>
 * ISAPALINILAPASI -- is a regular palindrome.
 * <p>
 * 2A3MEAS -- is a mirrored string.
 * <p>
 * ATOYOTA -- is a mirrored palindrome.
 * <p>
 * <p>
 * 思路：四种可能性：不是回文，是一个普通回文，是一个镜像，是一个镜像回文
 *
 * @author 丹丘生
 */
public class Project3_7 {
    // 存储镜像后的数据
    static String str = "A   3  HIL JM O   2TUVWXY51SE Z  8 ";

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String line = read.nextLine();

        // 判断是否为镜像和回文
        char[] chars = line.toCharArray();
        String reverseStr = "";
        for (int i = 0; i < chars.length; i++) {
            if (Character.isAlphabetic(chars[i])) // 判断是否为字母
                reverseStr += str.charAt(chars[i] - 65);
            else
                reverseStr += str.charAt(chars[i] - '0' + 25); //下标从25开始才是数字

        }

        if (checkPalindromes(line) && checkMirror(line, reverseStr)) {
            System.out.println("is a mirrored palindrome");
            return;
        }

        if (checkMirror(line, reverseStr)) {
            System.out.println("is a mirrored string");
            return;
        }

        // 判断是否为回文
        if (checkPalindromes(line)) {
            System.out.println("is a regular palindrome.");
            return;
        } else {
            System.out.println("is not a palindrome");
            return;
        }


    }

    private static boolean checkMirror(String line, String reverseStr) {
        StringBuilder sb = new StringBuilder(line);
        return sb.reverse().toString().equals(reverseStr);
    }

    private static boolean checkPalindromes(String line) {
        return new StringBuilder(line).reverse().toString().equals(line);
    }
}
/*
Character	Reverse	Character	Reverse	Character	Reverse
     A	      A	      M	          M        Y	        Y
     B	       	      N	                   Z	        5
     C	       	      O	          O        1	        1
     D	       	      P	                   2	        S
     E	      3	      Q	                   3	        E
     F	       	      R	                   4
     G	       	      S	          2        5	        Z
     H	      H	      T	          T        6
     I	      I	      U	          U        7
     J	      L	      V	          V        8	        8
     K	       	      W	          W        9
     L	      J	      X
 */