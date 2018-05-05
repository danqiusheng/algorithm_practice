package other;

/**
 * 欧几里得算法（辗转相除法）
 * 做法：用较小数除较大数，再用出现的余数（第一余数）去除除数，
 * 再用出现的余数（第二余数）去除第一余数，如此反复，直到最后余数是0为止。
 * 如果是求两个数的最大公约数，那么最后的除数就是这两个数的最大公约数。
 */
public class Algorithm {

    public static void main(String[] args) {
        System.out.println(divisor(15, 10));
        System.out.println(gcd(15, 10));
    }

    /*
     * 思路：
          ⒈ 若 r 是 a ÷ b 的余数，且r不为0， 则
               gcd(a,b) = gcd(b,r)
         ⒉ a 和其倍数之最大公因子为 a。
         另一种写法是：
         ⒈ 令r为a/b所得余数（0≤r<b）
         若 r= 0，算法结束；b 即为答案。
         ⒉ 互换：置 a←b，b←r，并返回第一步。
     */
    static int divisor(int a, int b) {
        if (a % b == 0)
            return b;
        else
            return divisor(b, a % b);
    }


    static int gcd(int a, int b) {
        while (a != b) {
            if (a > b)
                a -= b;
            else
                b -= a;
        }
        return a;
    }
}
