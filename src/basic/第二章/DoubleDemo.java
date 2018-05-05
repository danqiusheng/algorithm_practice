package basic.第二章;

/**
 * 测试double的问题，不能将其作为循环条件判断数字是否相等，只能做为近似值
 * Created by Administrator on 2018/4/4.
 *
 * @author 丹丘生
 */
public class DoubleDemo {
    public static void main(String[] args) {
        for (double i = 0; i != 10; i += 0.1) {
            System.out.println(i);
        }
    }
}
