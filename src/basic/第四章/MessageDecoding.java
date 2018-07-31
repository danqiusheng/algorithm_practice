package basic.第四章;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/6/13.
 * 题目：
 * 对于下面这个字符串：
 * 0，00，01，10，000，001，010，011…….
 * 首先是长度为1的串，然后是长度为2的串，以此类推。不存在全为1的串。
 * 你的任务是编写一个程序。首先输入一个代码头（例如AB#TANCnrtXc），则上述序列的每个串依次对应编码头的每个字符。例如，0对应A，00对应B，01对应#…，0000对应c。
 * 接下来是编码文本（可能由多行组成，你应当把他们拼成一个长长的01串）。
 * 编码文本由多个小节组成，每个小节的前3个数字代表小节中每个编码的长度，用二进制表示，然后是个字符的编码，以全1结束。编码文本以000结束。
 * $#**\
 * 0100000101101100011100101000
 * 0100000101101100011100101000
 * 思路： 二进制的处理 ，字符串判断, 对输入的编码头进行处理，因为编码的长度决定编码的个数，比如编码长度为1，则编码个数为1，编码长度为2，编码个数为3，编码长度为3，编码个数为7。
 * 所以依次类推，编码长度为n，编码个数为2^n-1，采用map存储，键为编码长度以及当前编码长度的第几个，对应的value值是字符。比如000的key就是30（3是编码长度，0代表编码第1个） ，001的key就是31...
 * <p>
 * Sample input
 * TNM AEIOU
 * 0010101100011
 * 1010001001110110011
 * 11000
 * $#**\
 * 0100000101101100011100101000
 * Sample output
 * TAN ME
 * ##*$
 *
 * @author 丹丘生
 */
public class MessageDecoding {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String codeHead = reader.nextLine();
        String code = reader.nextLine();
        // 存储
        Map<String, String> codeMap = new HashMap<>();
        init(codeHead, codeMap);
        System.out.println(codeMap);
        System.out.println("result:" + doDeal(code, codeMap));
    }

    // 处理字符串
    private static String doDeal(String code, Map<String, String> codeMap) {
        // 每个小节的前三个数字代表小节的编码长度
        String result = "";
        StringBuilder sb = new StringBuilder(code);
        while (sb.length() != 0) {
            // 获取头
            String first = sb.substring(0, 3);
            sb = new StringBuilder(sb.substring(3));
            // 获取头标识截取的长度
            int length = Integer.valueOf(first, 2);
            // 如果等于0.则结束
            if (length == 0) break;
            while (sb.length() != 0) {
                String smallCode = sb.substring(0, length);
                sb = new StringBuilder(sb.substring(length));
                // 如果到了结束标志
                if (smallCode.equals(Integer.toBinaryString((1 << length) - 1) + "")) break;
                result += codeMap.get(smallCode.length() + "" + Integer.valueOf(smallCode, 2));
            }
        }
        return result;
    }

    // 存储字符串编码
    private static void init(String code, Map<String, String> codeMap) {
        int index = 0;
        int maxI = (int) Math.ceil(Math.sqrt(code.length()));
        for (int i = 1; i <= maxI; i++) {
            for (int j = 0; j < Math.pow(2, i)-1 && index < code.length(); j++) {
                String key = i + "" + j;
                String value = code.charAt(index++) + "";
                codeMap.put(key, value);
            }
        }

    }


}
