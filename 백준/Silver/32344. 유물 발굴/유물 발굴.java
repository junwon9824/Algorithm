import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in)) ;

        String []str= br.readLine().split(" ");
        
        int R=Integer.parseInt(str[0]);
        int C=Integer.parseInt(str[1]);
        
        int N=Integer.parseInt(br.readLine() );

        int []maxv = new int[N+1];
        int []maxh = new int[N+1];
        
        int []minv = new int[N+1];
        int []minh = new int[N+1];

        Arrays.fill(minv,Integer.MAX_VALUE);
        Arrays.fill(minh,Integer.MAX_VALUE);
        
        for(int i=0;i<N;i++){
           str= br.readLine().split(" ");
                
            int a=Integer.parseInt(str[0]);
            int v=Integer.parseInt(str[1]);
            int h=Integer.parseInt(str[2]);
            
            maxv[a]=Math.max(maxv[a],v );
            maxh[a]=Math.max(maxh[a], h);
            
            minv[a]=Math.min(minv[a], v);
            minh[a]=Math.min(minh[a], h);
            
            // System.out.println(v+" "+h);
            
        }
        
        long res=0;
        int residx=0;
        
          for(int i=1;i<=N;i++){ 
              if(maxv[i]==0) 
              continue;
              
            long v=    (long)(maxv[i]-minv[i]+1)*(maxh[i]-minh[i]+1);
            // System.out.println(v);
              
              if(res<v){
                  
                  res=Math.max(res, v );
                  residx=i;
        
              }
              
          }
        
      
        // 결과 출력
        System.out.println(residx+" " + res );
        
    }
    
}
