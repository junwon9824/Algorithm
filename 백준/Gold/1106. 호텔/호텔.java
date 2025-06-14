import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[][] cities = new int[N][2];
        int maxCust = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int cust = Integer.parseInt(st.nextToken());
            cities[i][0] = cost;
            cities[i][1] = cust;
            maxCust = Math.max(maxCust, cust);
        }

        int target = C + maxCust;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 모든 도시를 먼저 순회하지 않고, 각 고객 수마다 최적의 도시를 선택
        for (int i = 1; i <= target; i++) {
            
            for (int[] city : cities) {
                
                int cost = city[0];
                int cust = city[1];
                
                // if (i >= cust && dp[i - cust] != Integer.MAX_VALUE ) {
                if (i >= cust ) {
                    // System.out.println(" i "+i +" cust "+cust +" dp[i - cust] " +dp[i - cust] );
                if ( dp[i - cust] != Integer.MAX_VALUE )  
                   
                    dp[i] = Math.min(dp[i], dp[i - cust] + cost);
                }
                
            }
            
        }

        int minCost = Integer.MAX_VALUE;
        
        for (int i = C; i <= target; i++) {
            minCost = Math.min(minCost, dp[i]);
        }
        
        System.out.println(minCost);
    }
}
