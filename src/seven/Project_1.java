package seven;

/**
 * Created by Administrator on 2018/3/18.
 * 有一堆煤球，堆成三角棱锥形。具体：
 第一层放1个， 1
 第二层3个（排列成三角形）， 1+2
 第三层6个（排列成三角形）， 1+2+3
 第四层10个（排列成三角形）， 1+2+3+4
 ....
 如果一共有100层，共有多少个煤球？ 171700
 */
public class Project_1 {
    public static void main(String[] args) {
        int ans = 0;
        for(int i = 1; i <= 100; ++i)
            ans += (1+i)*i/2;
        System.out.println(ans);
    }
}
