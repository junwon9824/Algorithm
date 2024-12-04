import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );

        String []str= br.readLine().split(" ");
        
        long a=Long.parseLong(str[0]);
      
        long b=Long .parseLong(str[1]);
      
        Queue< long [] > q= new LinkedList<>();
 
        q.add( new long [] {a,1});


        while(!q.isEmpty() )
        {
            long []v=q.poll();

            if(v[0]==b)
            {
                System.out.println( v[1]);
                return;
            }
            
            String strt= String.valueOf(v[0]);
            strt+="1";

            if(2*v[0]<=b)
                q.add( new long[] { 2*v[0] ,v[1]+1 }  );
            
            long tmp =Long.parseLong(strt) ;
            if( tmp<=b)
                q.add( new long [] { tmp ,v[1]+1 }   );
                
        }
        
        System.out.println(  -1 );
        
    
    }

      
}
