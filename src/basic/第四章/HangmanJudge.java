package basic.第四章;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/5/7.
 * 题目：
 * 游戏规则，计算机想一个单词让你猜，你每次可以猜一个字母，如果单词里有那个字母，所有该字母都会显示出来，如果没有那个字母
 则计算机会在一副“刽子手”画上填一笔，这幅画一共需要7笔就能完成，因此你最多只能错6次。注意猜一个已经猜过的字母也算错。
 在本题中，你的任务是编写一个“裁判”程序，输入单词和玩家的猜测，判断玩家赢了，（You win.）、输了（You lose.）、还是放弃了（You chickened out.)
 每组包含3行，第一行是游戏编号（-1为输入结束标记），第2行是计算机想的单词，第3行是玩家的猜测。后两行保证只含小写字母。
 思路：直接用字符串的replace即可
 * 输入：
1
cheese
chese
2
cheese
abcdefg
3
cheese
abcdefgij
-1
 输出：
 Round 1
 You win.
 Round 2
 You chickened out.
 Round 3
 You lose.
 * @author 丹丘生
 */
public class HangmanJudge {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        while(true){
            int round = read.nextInt();
            if(round==-1)break;
            read.nextLine();
            String original = read.nextLine();
            String guess = read.nextLine();
            check(round,original,guess);
        }
    }

    private static void check(int round, String original, String guess) {
        char[] chs = guess.toCharArray();
        int length = chs.length;
        int wrongCount = 0;
        for(int i = 0; i<length;i++){
            int index = original.indexOf(chs[i]);
            if(index!=-1){
                original=  original.replaceAll(chs[i]+"","");
            }else{
                wrongCount++;
            }
        }
        System.out.println("Round "+round);
        if(original.equals("")&&wrongCount<6){
            System.out.println("You win.");
        }
       else if(wrongCount>6){
            System.out.println("You lose.");
        }else{
            System.out.println("You chickened out.");
        }
    }
}
