package basic.第二章;

/**
 * 水仙花数 若3位数 ab c = a的三次方+b的三次方+c的三次方
 * Created by Administrator on 2018/4/3.
 *
 * @author 丹丘生
 */
public class Daffodil {

    public static void main(String[] args) {
        for (int i = 100; i <= 999; i++) {
            int a = i / 100;
            int b = i % 100 / 10;
            int c = i % 100 % 10;
            if (a * a * a + b * b * b + c * c * c == i) System.out.println(i);
        }
    }
}
