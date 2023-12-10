import java.util.*;

class Solution {
    static int [][]dp;
    
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        dp=new int[251][251];
        int ga=0,gc=0;
        
        
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],1111111);
        
        for(int i=0;i<problems.length;i++)
        {
            ga=Math.max(ga,problems[i][0]);
            gc=Math.max(gc,problems[i][1]);
            
        }
        
        if(alp>=ga&&cop>=gc){
            return 0;
        }
        
        if(alp>=ga)
        {
            alp=ga;
        }
        
        if(cop>=gc)
        {
            cop=gc;
        }
        
        dp[alp][cop]=0;
        
        for(int i=alp;i<=ga;i++)
        {
            for(int j=cop;j<=gc;j++)
            {
                dp[i+1][j]=Math.min(dp[i+1][j],dp[i][j]+1);
                dp[i][j+1]=Math.min(dp[i][j+1],dp[i][j]+1);
                //14 17 9 10
                
                for(int []p:problems)
                {
                    if(i>=p[0]&&j>=p[1])
                    {
                        
                        
                    if(i+p[2]<=ga&&j+p[3]<=gc ){
                        
                         dp[i+p[2]][j+p[3]]=Math.min(dp[i+p[2]][j+p[3]],dp[i][j]+p[4]);
                        // System.out.println("p[0]"+p[0]+"i j"+i+" "+j+" "+dp[i][j]+" "+dp[i+p[2]][j+p[3]]);
                    }
                    
                    else if( i+p[2]>ga&&j+p[3]>gc){
                         dp[ga][gc]=Math.min(dp[ga][gc],dp[i][j]+p[4]);
                    }
                     else if(  j+p[3]>gc){
                         dp[i+p[2]][gc]=Math.min(dp[i+p[2]][gc],dp[i][j]+p[4]);
                    }
                     else if(  i+p[2]>ga){
                         dp[ga][j+p[3]]=Math.min(dp[ga][j+p[3]],dp[i][j]+p[4]);
                    }
                    
                    }
                }
            }
        }
        
        answer=dp[ga][gc];         
        return answer;
    }
    
}