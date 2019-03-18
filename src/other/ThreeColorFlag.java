package other;


import java.util.Scanner;

/**
 * 三色旗
 *
 * @author danqiusheng
 *         假设有一条绳子，上面有红、白、蓝三种颜色的旗子，
 *         起初绳子上的旗子颜色并没有顺序，您希望将之分类，
 *         <p>
 *         并排列为蓝、白、红的顺序，要如何移动次数才会最少，
 *         注意您只能在绳子上进行这个动作，而且一次只能调换两个旗子。
 */
public class ThreeColorFlag {
    static int count = 0;

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        String color = read.nextLine();

        // 得到原始的颜色
        char[] colors = color.toCharArray();
        System.out.println("原始颜色数组:");
        System.out.println(colors[0] + "--" + colors[1] + "--" + colors[2]);
        move(colors);
        System.out.println(colors[0] + "--" + colors[1] + "--" + colors[2]);
        System.out.println(count + "次");
    }

    public static void swap(char[] colors, int left, int right) {
        char temp = colors[left];
        colors[left] = colors[right];
        colors[right] = temp;
        count++;
    }

    public static void move(char[] colors) {
        int wIndex = 0;
        int bIndex = 0;
        int rIndex = 2;
        while (wIndex < rIndex) {
            if (colors[wIndex] == 'W') { // 如果是白色 往后移动
                wIndex++;
            } else if (colors[wIndex] == 'B') { // 如果是蓝色
                swap(colors, wIndex, bIndex); // 与白色坐标交换
                wIndex++;
                bIndex++;
            } else { // 如果是红色
                while (wIndex < rIndex && colors[rIndex] == 'R') // 如果当前是红色
                    rIndex--;
                swap(colors, rIndex, wIndex);
                rIndex--; // 红色下标减一
            }
        }
    }
}
