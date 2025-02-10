import java.io.*;
import java.util.*;
///백준 1916

public class Main {

    static ArrayList<int []> [] arr;
    static  int [] dp;
    static  boolean [] visit;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         int n = Integer.parseInt(br.readLine());    
         int m = Integer.parseInt(br.readLine());    

        arr=new ArrayList[n+1];
        visit=new boolean[n+1];
        dp=new int[n+1];
        
        for(int i=1;i<=n;i++){
            arr[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            
            String []str= br.readLine().split(" ");
            int s= Integer.parseInt( str[0]);
            int e= Integer.parseInt( str[1]);
            int c= Integer.parseInt( str[2]);
            
            arr[s].add(new int[]{e,c});
        }

        String []str= br.readLine().split(" ");
        
        int s= Integer.parseInt( str[0]);
        int e= Integer.parseInt( str[1]);

        dijkstra(s);

        System.out.println(dp[e] );
        
    }
    
    static void dijkstra(int start ){

        PriorityQueue <int []> q =new PriorityQueue<>(
            (a,b)-> {
                return a[1]-b[1];}
        );
        
        q.add(new int []{ start,0});

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[start]=0;
        
        while (!q.isEmpty()) {
            
            int []v=q.poll();
            int from =v[0];
            
            // System.out.println("from"+ from );
            
                if(visit[from])continue;
                
                visit[from]=true;

            for(int []s : arr[from] ){
                
                int to =  s[0] ;
                int cost =  s[1] ;

                
                if( dp[to] >  cost+dp[from]    ){
                    
                    dp[to] =  cost+dp[from];
                // System.out.println("to"+ to + "dp[to]"+dp[to]+"cost"+cost +"from"+from+  "dp[from]"+ dp[from]);

                    q.add(new int[]{ to , dp[to] });
                }
            
            }
            
        }
        
    }
 
}