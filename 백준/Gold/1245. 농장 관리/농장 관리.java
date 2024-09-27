import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
        static int [] ladder= new int [101];
        static int [] snake= new int [101];
        static int [][]arr;
        static boolean [][]visit;
        static int []dr=new int[]{1,-1,0,0,1,1,-1,-1};
        static int []dc=new int[]{0,0,1,-1,1,-1,1,-1};
        static int cnt=0;
            static int n,m;
    
    public static void main(String[] args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String [] str=br.readLine().split(" ");
        
        n=Integer.parseInt( str[0] );
        m=Integer.parseInt( str[1] );

         arr=new int[n][m];
         visit=new boolean[n][m];

        
        for(int i=0;i<n ;i++){
              str=br.readLine().split(" ");
            
           out: for(int j=0;j<m ;j++){
                arr[i][j]=Integer.parseInt(str[j]);
                 
            }
            
        }
        
         for(int i=0;i<n ;i++){
            
            for(int j=0;j<m ;j++){
                     
                        
                      if(visit[i][j] ) 
                      {
                        continue;
                      }

                
                     if(  bfs(i,j) )cnt++ ;
                  
            }
                
                // System.out.println(i+" "+j );
                // cnt++;
            
        }
            
        
        System.out.println(cnt);
        
    }


    
    static boolean bfs(int r, int c){
        
        Queue<int []> q=new LinkedList<>();
        q.add(new int[]{ r,c });

        boolean flag=false;
        while(!q.isEmpty()){
            int []v=q.poll();

            int  r1=v[0];
            int  c1=v[1];
            
            if(visit[r1][c1])
            {
               continue; 
                                
            }
            
            visit[r1][c1]=true; 
            
            for(int i=0;i<8;i++){
                
                int nr=v[0]+dr[i];
                int nc=v[1]+dc[i];
                
                if(nr>=0&&nr<n&&nc>=0&&nc<m){

                }

                else{
                    continue;
                }
                
                if(arr[r1][c1] ==  arr[nr][nc]  ){
                    q.add(new int[]{ nr,nc });
                    
                }
                    
                  if(  arr[r1][c1]<arr[nr][nc]   ){
                            // System.out.println(i+" cccc "+j+" "+ni+" "+nj );
                     flag=true;
                      
                  }
                
            }
            
            
        }

        if(flag)
            return false;
        
        else
            return true;
    }
 
}