import java.io.*;
import java.util.*;

public class Main {
        static int n;
    
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []str= br.readLine().split(" ");
        n = Integer.parseInt(str[0]); 

        str= br.readLine().split(" ");
        int []dp= new int[n ];

        dp[n-1]=Integer.valueOf(str[n-1]) ;

        // dp[n-1]= ;
         for( int i=n-2;i>=0 ;i--){
             int v=Integer.valueOf(str[i]);
             
             dp[i]=Math.min(dp[i+1], v);
         }
        
            long sum=0;
        
         for( int i=n-1;i>=0 ;i--){
            sum+=dp[i];     
         }

            System.out.print( sum );
        
        
    }
     
}

