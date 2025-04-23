import java.util.*;
import java.io.*;

// 28215
// 5 2
// 1 5
// 3 0
// 3 3
// 6 12
// 8 9

// 1 1
// 0 0

public class Main{
    static int min=100;
    static int res=Integer.MAX_VALUE;
    // static int sum=0;
    static int n=0;
    static int k=0;
    
          static  int []x;
           static int []y;
       static  ArrayList<Integer> list =new ArrayList<>();
       static  boolean[]visit;
    
	public static void main(String[] args) throws IOException{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
        
        String []str=br.readLine().split(" ");
        
		 n=Integer.parseInt( str[0]);
		 k=Integer.parseInt( str[1]);
        visit=new boolean[n];
        
         x=new int[n];
         y=new int[n];
        
        for(int i=0;i<n;i++){
            str=br.readLine().split(" ");
            x[i]=Integer.parseInt( str[0]);
            y[i]=Integer.parseInt( str[1]);
        }

        solve(0 , -1  );
        
        System.out.println( res );

	}
    
    static void solve (int d , int idx ) { 

        if(d==k){
            // System.out.println( d +" "+ list.size());
            // for(int v:list){
                
                // System.out.println("v "+v);
            // }
            
            // System.out.println("max"+ " "+maxlen(list));
            
            res=Math.min(res,maxlen(list));
        }
        
        for(int i=idx+1;i<n;i++ ){
            list.add(i);
            visit[i]=true;
            solve(d+1, i);
            list.remove(list.size()-1);
            visit[i]=false;
        
        }
        
    }
    
    static int maxlen( ArrayList<Integer> list){
        int len=0;
        {
            
            for(int i=0;i<n;i++){ //특정 집
                int tmp=Integer.MAX_VALUE;
                    if(visit[i])continue;  
                
                for(int j: list ){ //대피소들.
                    // if(i==j)continue; //대피소만 

                    tmp = Math.min(tmp, diff( i,  j  ) )    ;
                    // System.out.println("i "+i+" j "+j+" diff"+diff( i,  j  ) );
                    
                }
                len=Math.max(len, tmp );
                
            }
            
        }
        
        return len;
    }
    
    static int diff(int a,int b ){
        
        int tmp=Math.abs(x[a]-x[b])+Math.abs(y[a]-y[b]);
        return  tmp;
        
    }



    

     

    
}