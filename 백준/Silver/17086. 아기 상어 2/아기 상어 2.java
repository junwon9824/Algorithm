import java.io.*;
import java.util.*;

public class Main {
                static int [][]arr;
 
	public static void main(String[] args) throws Exception {

		// TODO Auto-generated method stub
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n,m;

        String []str=br.readLine().split(" ");
        n=Integer.parseInt(str[0]); 
        m=Integer.parseInt(str[1]); 
             arr= new int[n][m];
        
        for(int i=0;i<n;i++)
            {
               str=br.readLine().split(" ");
                
                for(int j=0;j<m;j++)
                {
                    arr[i][j]=Integer.parseInt(str[j]);
                }
            }

        int max=0;
        
         for(int i=0;i<n;i++)
            { 
                for(int j=0;j<m;j++)
                {
                    if(arr[i][j]==0 ){
                        max=Math.max(max, dis(i,j,n,m) );
                    }
                 }
            }


//         5 4
// 0 0 1 0
// 0 0 0 0
// 1 0 0 0
// 0 0 0 0
// 0 0 0 1

		System.out.println( max);

	}
    static boolean valid(int r,int c,int n,int m){
        return r>=0&&r<n&&c>=0&&c<m;
    }
    
    static int dis(int l,int k,int n,int m){
        Queue<int []> q=new LinkedList<>();

        int []dr={1,0,0,-1,1,1,-1,-1};
        int []dc={0,1,-1,0,-1,1,1,-1};
        boolean visit[][]=new boolean[n][m];

        
        q.add(new int[]{l,k,0 });
        visit[l][k]=true;

        
        while(!q.isEmpty()){
            int []v=q.poll();

            for(int i=0;i<8;i++){
                    
                int nr=v[0]+dr[i];
                int nc=v[1]+dc[i];
                 if(!valid(nr,nc,n,m))continue;
                if(visit[nr][nc])continue;
                
                if(valid(nr,nc,n,m) && arr[nr][nc]==0){
                    q.add(new int[]{nr,nc,v[2]+1});
                }
    
                else if(valid(nr,nc,n,m) && arr[nr][nc]==1){
                    return  v[2]+1;
                    
                }
                visit[nr][nc]=true;

            }
            
        }
        
        return  0;
        
    }

}
