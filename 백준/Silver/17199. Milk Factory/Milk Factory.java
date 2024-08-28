import java.io.*;
import java.util.*;

public class Main {

        static ArrayList <Integer> []list ;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           
        int n,c;
 
            String []str=br.readLine().split(" ");
              n=Integer.parseInt(str[0]);

        list= new ArrayList[n+1 ];
        
        for(int i=1;i<=n ;i++){
            list[i]=new ArrayList<>();            
        }


        
        for(int i=0;i<n-1 ;i++){
             str=br.readLine().split(" ");
            int a =Integer.parseInt(str[0]);
            int b =Integer.parseInt(str[1]);
            // list[a].add(b);
            list[b].add(a);
            
        }
        
        boolean flag=false;
         for(int i=1;i<=n ;i++){
             
            if( solve(i,n) ==n ){
                System.out.print(i);
                // System.out.print("N"+n);
                flag=true;
                
            }
             
        }
        if(flag==false)
                System.out.print(-1);
        
// 3
// 1 2
// 3 2

	}
    
    static int solve(int idx,int n){

        boolean [] visit=new boolean[n+1];

        Queue<Integer> q=new LinkedList<>();

        q.add(idx);
        
         while(!q.isEmpty()){
            int v=q.poll();
            visit[v]=true;
             
             for(int s: list[v]){
                 if(visit[s]==false){
                    q.add(s);
                     visit[s]=true;
                 }
             }
             
         }
        int cnt=0;
        for(int i=1;i<=n;i++){
            if(visit[i]){
                 cnt++;
            }
        }
                // System.out.println(idx+" " +cnt);
        
        return cnt;
    }

}