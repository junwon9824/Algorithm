import java.io.*;

public class Main {

	static int N, M;
	static int[][][] dp;
	static int[][] w;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);

		dp = new int[N   ][M  ][3];
		w = new int[N  ][M  ];


		for (int i = 0; i < N; i++) {
			sarr = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				w[i][j] = Integer.parseInt(sarr[j ]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = w[i][j] ;
			}
		}
        
		dp[0][0][0] = dp[0][0][1] = dp[0][0][2] = w[0][0];

		for (int i = 0; i < N; i++) {
            
			for (int j = 0; j < M; j++) {
				if (j >= 1) //왼쪽에서
					dp[i][j][0] = Math.max(dp[i][j - 1][0], dp[i][j - 1][1]) + w[i][j];
                
                if(i==0 ) dp[i][j][2]=dp[i][j][0];
                
				if (i >= 1) //위에서
					dp[i][j][1] = Math.max(dp[i - 1][j][0], Math.max(dp[i - 1][j][1], dp[i - 1][j][2])) + w[i][j];
                
                if(i==0 ) dp[i][j][1]=dp[i][j][0];
                
                if(j==0 ) 
                {
                    
                    dp[i][j][0]=dp[i][j][1];
                }

                if(j==M-1 ) dp[i][j][2]=dp[i][j][1];
                
               // System.out.println( i+ " "+j+" 왼 "+dp[i][j][0]+" 위 "+dp[i][j][1]+ " 오른 " +dp[i][j][2] );
			
            }
            
            if(i>0){
                
    			for (int j = M -2; j >= 0; j--) { //오른쪽에서
    				dp[i][j][2] = Math.max(dp[i][j + 1][1], dp[i][j + 1][2]) + w[i][j];
                    
                  //  System.out.println( i+ "  "+j+" 오른 " +dp[i][j][2]);
                    
                }
			}
            
		}
        
        System.out.println(Math.max(dp[N-1][M-1][0],dp[N-1][M-1][1]));
		// bw.write(Math.max(dp[N-1][M-1][0], dp[N-1][M-1][1]) + "\n");

	}

}