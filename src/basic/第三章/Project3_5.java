package basic.第三章;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TeX中的引号 (TexQuotes)
 * Created by Administrator on 2018/4/4.
 * 题目：在Tex中，做双引号的" `` ",右双引号是"  '' "（两个回车左边的）.输入一篇包含双引号的文章，你的任务是把它转换成TeX的格式。
 * 样例输入："To be or not to be,"quoth the Bard,"that is the question".
 * 样例输出：``To be or not to be,''quoth the Bard,``that is the question''.
 * 思路：采用正则进行匹配，找到则进行替换,通过一个计数变量判断当前是左右引号；
 *
 * @author 丹丘生
 */
public class Project3_5 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String line = read.nextLine();
        //1.将正在表达式封装成对象Patten 类来实现
        Pattern pattern = Pattern.compile("\"");
        //2.将字符串和正则表达式相关联
        Matcher matcher = pattern.matcher(line);
        StringBuilder sb = new StringBuilder(line);
        int i = 0;
        while (matcher.find()) {  //查找符合规则的子串
            if (i % 2 == 0) {    //获取的字符串的首位置和末位置
                sb.replace(matcher.start(), matcher.end(), "`");
            } else {
                sb.replace(matcher.start(), matcher.end(), "'");
            }
            i++;
        }
        line = sb.toString();
        System.out.println(line.replaceAll("`", "``").replaceAll("'", "''"));
    }
}
