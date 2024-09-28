import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
        static char [][]arr;
        static boolean [][]visit;
        static int cnt=0;
            static int n,m,k;
    
       static  ArrayList<int []>t=new ArrayList<>();
       static ArrayList<int []>s=new ArrayList<>();
        
    public static void main(String[] args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String [] str=br.readLine().split(" ");
                
        n = Integer.parseInt( str[0] );
        //3 개 장애물
        visit=new boolean[n][n];
        arr=new char[n][n];
        char [][]carr=new char[n][n];
        
        for(int i=0;i<n ;i++){
            str=br.readLine().split(" ");
            
            for(int j=0;j<n ;j++){
                arr[i][j]=str[j].charAt(0);        
                if(arr[i][j]=='T')t.add(new int[]{i,j});
                if(arr[i][j]=='S')s.add(new int[]{i,j});

            }
            
        }
         for(int i=0;i<n ;i++){
            
            for(int j=0;j<n ;j++){
                // System.out.print(arr[i][j]);
                carr[i][j]=arr[i][j];
            }
                // System.out.println( );
            
        }
        solve(0,arr);
        
        System.out.println(cnt>0?"YES":"NO" );
        
    }

    static boolean check(  char [][]copy ){
  
        
        int size=t.size();

        Queue<int []> q=new LinkedList<>();

        int []dr=new int[]{ 1,-1,0,0};
        int []dc=new int[]{ 0,0,1,-1};
        
          for(int i=0;i<size;i++){
            int []v=t.get(i);

             for(int j=0;j<4;j++) 
                q.add(new int[]{ v[0],v[1],j } );

              while(!q.isEmpty() ){
                  int []tmp=q.poll();
                    int r=tmp[0];
                    int c=tmp[1];
                    int dir=tmp[2];

                  int nr=r+dr[dir];
                  int nc=c+dc[dir];
                  
                  if( nr>=0&&nr<n&&nc>=0&&nc<n){
                    
                  }
                  else{
                        continue;
                  }
                  
                  if( copy[nr][nc]=='S'){
                      return false;
                  }
                  else if( copy[nr][nc]=='T'){
                      
                  }
                   else if( copy[nr][nc]=='0'){
                      continue;
                  }
                   else if( copy[nr][nc]=='X'){
                      q.add(new int[]{ nr, nc,dir});
                  }
                  
              }
              
        }
        return true;
        
    }
    
    static void solve(int d, char [][]copy ){
                // System.out.print(d);

        if(d==3){
            if( check(copy )) //true 면 안전하다.
            {
                cnt++;
            }
            return;
        }

          for(int i=0;i<n ;i++){
            
            for(int j=0;j<n ;j++){
                
                if(copy[i][j]=='T') continue;
                if(copy[i][j]=='S') continue;
                if(copy[i][j]=='0') continue;
                if(visit[i][j]) continue;
                visit[i][j]=true;
                char first=copy[i][j];
                copy[i][j]='0';
                // System.out.println( d+"fff"+first);
                
                solve(d+1,copy);
                copy[i][j]=first;
                
                visit[i][j]=false;
                
            }
            
        }
        
        
        
    }

    
 
     
 
}