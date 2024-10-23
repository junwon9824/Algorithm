import java.util.*;
import java.io.*;

 
public class Main {
    public static void main(String[] args) throws Exception{
      
      BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
      
      String []str= br.readLine().split(" ");
      
      int N=Integer.parseInt(str[0] ); 
      long T=Long.parseLong(str[1] ); 

        int []a=new int[N+1];
        
       str= br.readLine().split(" ");

        for(int i=0;i<N;i++){
            a[i]=Integer.parseInt(str[i]);
        }

        boolean []visit=new boolean [ N+1];

        int idx=0;
        int cnt=0; 
        int []path=new int[N+1];
        
        while(!visit[idx]){
            visit[idx]=true;
            path[cnt]= idx;
            idx=a[idx]-1;
            cnt++;
            
        }


        int start =0;
        
        for(int i=0;i<T;i++){
            int v= path[i];

            if(v==idx){
                break;

            }
            start++;      
      // System.out.println(  a[v-1]  );
            
            
        }
        
         int cyclesize= cnt- start ;
         

        T=T-start;
        T=(long)T%cyclesize ;
        
      // System.out.println(  cyclesize+ " "+start  );
      // System.out.println(  T+start  );
        
      System.out.println( path[ (int)T+start]+1 );
        
  }
   
  
  
}