
import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        char [][]ch=new char [n][m];
        int [][]ch2=new int [n][m];

        for(int i=0;i<n;i++){
            String tmp = br.readLine();
            ch[i]=tmp.toCharArray();
            Arrays.fill(ch2[i],-1);

        }
        
        int []dr={1,-1,0,0};
        int []dc={0,0,1,-1};
        Queue<int []> q=new LinkedList<>();
        
        q.add(new int[]{ 0,0,0,0});
        boolean [][][]visit=new boolean [n][m][2] ;
        visit[0][0][0] = true;
        
        while(!q.isEmpty()){
            int []v=q.poll();
            // System.out.println(v[0]+" "+v[1]+" "+v[2]+" "+v[3] );

            for(int i=0;i<4;i++){
                int nr=v[0]+dr[i];
                int nc=v[1]+dc[i];
                
                //  System.out.println("fff"+nr+" "+nc+" "+visit[nr][nc][v[2]]  );

                  if(valid(nr, nc, n, m) && ch[nr][nc] == '0' && visit[nr][nc][v[2]] == false){
                    q.add(new int[]{nr, nc, v[2], v[3] + 1});
                    
                    if(nr==n-1&&nc==m-1){
                        if(ch2[nr][nc]!=-1)
                            continue;
                    }
 
                    
                    ch2[nr][nc] = v[3] + 1 ;
                    
                    visit[nr][nc][v[2]] = true;
                    
                } 
                 
                if(valid(nr, nc, n, m) && ch[nr][nc] == '1' && visit[nr][nc][1] == false && v[2] == 0){
                    q.add(new int[]{nr, nc, v[2] + 1, v[3] + 1});
                    ch2[nr][nc] = v[3] + 1;
                    visit[nr][nc][1] =true;
                } 
            }
        }
        
        if(n==1&&m==1)
         System.out.println( 1);
         
        else
        System.out.println( ch2[n-1][m-1]==-1 ? -1:   ch2[n-1][m-1]+1 );
        
    }
 
    static boolean valid(int r,int c,int n,int m){
        return r>=0&&r<n&&c>=0&&c<m;
    }
    
    
}