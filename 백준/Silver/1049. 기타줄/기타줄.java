import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
// 4 2
// 12 3
// 15 4

        int  mok,na;
        int []a=new int[m];
        int []b=new int[m];

        
        int minmok=Integer.MAX_VALUE;
        int minna=Integer.MAX_VALUE;

        mok=n/6;
        na=n%6;
        if(mok==0)minmok=0;
        if(na==0)minna=0;
        

        
        for (int i = 0; i < m; i++) {
             String []str= br.readLine().split(" ");
            a[i]=Integer.parseInt(str[0]);
            b[i]=Integer.parseInt(str[1]);

            minmok=Math.min(minmok,a[i]);
            minmok=Math.min(minmok,b[i]*6 );
            
            minna=Math.min(minna,b[i]*na );
            minna=Math.min(minna, a[i] );
        // System.out.println(minmok+ " i " +i+" "+minna);
            
        }
 
        
        System.out.println(minmok*mok+minna );
    }
}
