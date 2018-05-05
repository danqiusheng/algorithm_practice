package seven;

/**
 * Created by Administrator on 2018/3/19.
 * DEFFF
 CEFFF
 CDFFF
 CDEFF
 CCFFF
 CCEFF
 CCDFF
 CCDEF
 BEFFF
 BDFFF
 BDEFF
 BCFFF
 BCEFF
 BCDFF
 BCDEFl
 */
public class Project_5 {
    public static void f(int[] a, int k, int n, String s) {
        if(k==a.length){
            if(n==0) System.out.println(s);
            return;
        }

        String s2 = s;
        for(int i=0; i<=a[k]; i++){
            //_____________________________;   //填空位置
            f(a,k+1,n-i,s2);
            s2 += (char)(k+'A');
        }
    }

    public static void main(String[] args) {
        // k = 0
        int[] a = {4,2,2,1,1,3};

        f(a,0,5,"");
    }
}
