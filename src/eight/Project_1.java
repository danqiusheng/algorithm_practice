package eight;

import java.io.*;

/**
 * Created by Administrator on 2018/3/12.
 * 5200  读取文件信息，然后求和
 */
public class Project_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("src/eight/a.txt")));
        String line;
        double sum = 0;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(" ");
            String count = data[1];
            if (count.length() == 1) {
                count = "0." + count;
            } else if (count.length() == 2) {
                count = "0." + count;
            }
            Double one = Double.parseDouble(data[0]);
            Double two = Double.parseDouble(count);
            sum += one * two;
            System.out.println(data[0] + "=" + one + "----" + data[1] + "=" + two);
        }
        System.out.println(sum);
    }
}
