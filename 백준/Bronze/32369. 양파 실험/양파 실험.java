import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visit;
    static char[] arr;
    static String []str;
    static int tot = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int a = Integer.parseInt(str[1]); //칭찬ㅊ
        int b = Integer.parseInt(str[2]);

        int cnt = 0;
        int good=1;
        int bad=1;
        
        for (int i = 0; i < n; i++) { 
            good+= a;
            bad += b;

            if( good<bad ){
                int tmp=bad;
                bad=good;
                good=tmp;
            }

            if(good==bad){
                bad--;
            }
        }

 
        // 결과 출력
        System.out.println(good+" "+bad);
        
    }

    
}
