import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            
            int n = Integer.parseInt(  br.readLine() );
            int [][] arr = new int [2][n];
            int [][] dp = new int [2][n];

            for (int  j =0;j<2;j++ ) {
                String[] tmp =br.readLine().split(" ");
                
                for (int k =0;k<n;k++ ) {
                    
                    arr[j][k]=Integer.parseInt(tmp[k]);
                    
                }
            }

            if(n==1){
                System.out.println(Math.max(arr[0][0], arr[1][0] ));

                continue;
            }

            dp[0][0]=arr[0][0];
            dp[1][0]=arr[1][0];

            dp[0][1]= arr[0][1]+dp[1][0];
            dp[1][1]= arr[1][1]+dp[0][0];
            
            // System.out.println("dp[0][k] "+" k "+k+" "+dp[0][k]);
            
                for (int  k =2;k<n;k++ ) {
                    
                     dp[0][k]= Math.max(dp[1][k-1] ,dp[1][k-2] )+arr[0][k];
                     dp[1][k]= Math.max(dp[0][k-1] ,dp[0][k-2] )+arr[1][k];
                    // System.out.println("dp[0][k] "+" k "+k+" "+dp[0][k]);
                }
            
            System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));

            
        }

    }
}
