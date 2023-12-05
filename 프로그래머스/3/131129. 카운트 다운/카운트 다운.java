class Solution {
    static int [][] dp;
     
    public int[] solution(int target) {
        int[] answer = new int[2];
        // target=29;
        
        dp=new int[target+1][2];
            dp[0][0] = 0;
            dp[0][1] = 0;
        
        for(int i=1; i<=target; i++){
            
            dp[i][0] = 100001;
            // System.out.println(dp[i][0]);
            dp[i][1] = 0;
            
        }
        
        for(int i=1;i<=target;i++)
        {
            
          for(int j=1;j<=20;j++)
          {
              if(i>=50&& dp[i][0]>=dp[i-50][0]+1){
                  // System.out.println(i+" "+dp[i][0]+" "+dp[i-50][0]+1);
                dp[i][0]=dp[i-50][0]+1;
                // System.out.println("after"+i+" "+dp[i][0]+" "+dp[i-50][0]+1);
                  
                if(dp[i][0]==dp[i-50][0]+1 )
                    dp[i][1]=Math.max(dp[i][1],dp[i-50][1]+1 ) ;
                  
               }
              
              if(i-j>=0&& dp[i][0]>=dp[i-j][0]+1)
              {
                  
                 
                   // System.out.println("i"+i+" j"+j+" dp["+i+"][1]"+dp[i][1]+" dp["+(i-j)+"][1]"+dp[i-j][1]); 
                
                  // System.out.println("i"+i+" j"+j+" dp["+i+"][0]"+dp[i][0]+" dp["+(i-j)+"][0]"+dp[i-j][0]);   

                if(dp[i][0]==dp[i-j][0]+1 )
                   dp[i][1]=Math.max(dp[i][1],dp[i-j][1]+1 ) ;
                  
                else if(dp[i][0]>dp[i-j][0]+1 )
                   
                   dp[i][1]=dp[i-j][1]+1  ;
                  
              dp[i][0]=dp[i-j][0]+1;
                      
              }
              
               if(i-j*2>=0&&dp[i][0]>dp[i-j*2][0]+1)
              {
                dp[i][0]=dp[i-j*2][0]+1;
                    dp[i][1]=dp[i-j*2][1];

              }
              
               if(i-j*3>=0&&dp[i][0]>dp[i-j*3][0]+1)
              {
                    // System.out.println(i+" "+dp[i][0]+" "+dp[i-j*3][0]);
                   dp[i][0]=dp[i-j*3][0]+1;
                    dp[i][1]=dp[i-j*3][1];
                  
              }
          }
        }
         
        answer[0]=dp[target][0];
        answer[1]=dp[target][1];
        
        return answer;
    }
    
}