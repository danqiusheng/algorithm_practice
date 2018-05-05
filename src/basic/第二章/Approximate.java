package basic.第二章;

/**
 * 近似值计算，计算pi/4 = 1-1/3+1/5-1/7+.... 直到最后一项小于10的-6次方
 * Created by Administrator on 2018/4/3.
 */
public class Approximate {
    public static void main(String[] args) {

        double sum = 0;
        int i = 1;
        while (true) {
            double term = 1.0 / (i * 2 + 1);
            if (i % 2 == 0)
                sum += term;
            else
                sum -= term;
            i++;
            if (term < 1e-6) {
                break;
            }

        }
        System.out.println(String.format("%.6f", sum));
    }
}
