import java.util.*;
import java.io.*;

// 11727 dp 사용.

public class Main{
    static int min=100;
    static int res=0;
    // static int sum=0;
    static int n=0;
    static int []dp;
    
	public static void main(String[] args) throws IOException{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
        
        String []str=br.readLine().split(" ");
        
		 n=Integer.parseInt( str[0]);
        dp=new int[n+1];

        if(n>=1)
        dp[1]=1;
        
        if(n>=2)
        dp[2]=3;

        
         ArrayList<Integer> list=new ArrayList<>();
        solve();
        
        System.out.println(dp[n] % 10007);

	}

    static void solve() {


        // System.out.println(dp[1]);

        for(int i=3;i<=n ;i++){
            dp[i]= dp[i-1 ]% 10007 + 2*dp[i-2]%10007;
                 
            
        }

        
    }

    
}