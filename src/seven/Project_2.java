package seven;

/**
 * Created by Administrator on 2018/3/18.
 *
 生日蜡烛

 某君从某年开始每年都举办一次生日party，并且每次都要吹熄与年龄相同根数的蜡烛。
 现在算起来，他一共吹熄了236根蜡烛。
 请问，他从多少岁开始过生日party的？
 请填写他开始过生日party的年龄数。
 注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。 26
 */
public class Project_2 {
    public static void main(String[] args) {
        int sum = 0;
        int i ;
        for( i = 26;i<34;i++){
            sum += i;
            if(sum == 236)
                break;
        }
            System.out.println(sum);
        System.out.println(i);
    }
}
