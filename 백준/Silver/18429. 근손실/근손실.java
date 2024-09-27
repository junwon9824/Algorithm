import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
        static int []r;
        static boolean []visit;
        static int cnt=0;
            static int n,m,k;
    
    public static void main(String[] args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String [] str=br.readLine().split(" ");
        
        n = Integer.parseInt( str[0] );
        k = Integer.parseInt( str[1] );
        
        r  =new int[n];
        visit=new boolean[n];
        
        str=br.readLine().split(" ");

        for(int i=0;i<n ;i++){
            r[i]=Integer.parseInt( str[i] ) - k;//운동하면증가하는무게, 하루에k만큼감소
        }

        Arrays.sort(r);

        solve( 0,0);
        
        System.out.println(cnt );
        
    }

    static void solve(int sum,int d){

        if(sum<0){
            return;
        }
        
        if(d== n ){
            cnt++;
            return ;
        }

        for(int i=0;i<n;i++){
            int v=r[i];
            
            if(visit[i]){
                continue;
            }

            visit[i]=true;
            sum+=r[i];
            solve(sum,d+1);
            visit[i]=false;
            sum-=r[i];
            
            
        }
        

        
    }
     
 
}