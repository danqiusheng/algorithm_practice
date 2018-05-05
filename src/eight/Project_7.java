package eight;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by Administrator on 2018/3/15.
 * 小明知道这些日期都在1960年1月1日至2059年12月31日。
 * 有采用年/月/日的，有采用月/日/年的，还有采用日/月/年的
 * 年份也都省略了前两位
 * 比如02/03/04，可能是2002年03月04日、2004年02月03日或2004年03月02日。
 * 考虑去重，并排序
 */
public class Project_7 {
    static String str = "09/03/09";
    static SimpleDateFormat oneFormat  = new SimpleDateFormat("yyyy/MM/dd");
    static SimpleDateFormat resultFormat  = new SimpleDateFormat("yyyy-MM-dd");
    static SimpleDateFormat twoFormat  = new SimpleDateFormat("yyyyMMdd");
    static HashSet<Integer> res = new HashSet<Integer>();
    static ArrayList<Integer> list = new ArrayList<Integer>();
    private  static   String[] data ;
    private static int one;
    private static int two;
    private static int three;
    public static void main(String[] args) throws ParseException {
        data = str.split("/");
        one = Integer.parseInt(data[0]);
        two = Integer.parseInt(data[1]);
        three = Integer.parseInt(data[2]);
        // 年 月 日
        check(one,oneFormat,0,1,2);
        // 日
        check(three,oneFormat,2,1,0);
        // 月
        check(three,oneFormat,2,0,1);
        list.addAll(res);
        Collections.sort(list);
        for(Integer str : list){
            System.out.println(resultFormat.format(twoFormat.parse(str+"")));
        }
    }

    public  static void check(int current,SimpleDateFormat currentFormat,int oneIndex,int twoIndex,int threeIndex){
            if(current>=0&&current<60){
                someYear("20", currentFormat,oneIndex,twoIndex,threeIndex);
            }else{
                someYear("19",currentFormat,oneIndex,twoIndex,threeIndex);
        }
    }

    private static void someYear(String year,  SimpleDateFormat currentFormat, int oneIndex, int twoIndex, int threeIndex) {
        int one_year = Integer.parseInt(year+data[oneIndex]);
        try {
            Date date =   currentFormat.parse(one_year+"/"+data[twoIndex]+"/"+data[threeIndex]);
            String result =  currentFormat.format(date);
            String[] resultArr = result.split("/");
            // 得到年
            int  oneResult = Integer.parseInt(resultArr[0]);
            // 得到月
            int twoResult = Integer.parseInt(resultArr[1]);
            // 得到日
            int threeResult = Integer.parseInt(resultArr[2]);
            if(one_year==oneResult&&Integer.parseInt(data[twoIndex])==twoResult&&Integer.parseInt(data[threeIndex])==threeResult){
                 res.add(Integer.parseInt(resultArr[0]+resultArr[1]+resultArr[2]));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
