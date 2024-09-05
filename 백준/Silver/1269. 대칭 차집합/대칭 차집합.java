import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
   public static void main(String[] args) throws Exception {
       
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
           String [] str = br.readLine().split(" ");

       
           int n=Integer.parseInt(str[0]);
           int m=Integer.parseInt(str[1]);
       
             str = br.readLine().split(" ");
           HashSet<Integer> hs=new HashSet<>();
       
            for(int i=0;i<n;i++){
               int v=Integer.parseInt(str[i]);
                hs.add(v);
                   // System.out.println( v);
                
            }
       
              str = br.readLine().split(" ");
        
            for(int i=0;i<m;i++){
               int v=Integer.parseInt(str[i]);
                   // System.out.println( v);
                
                hs.add(v);
            }
       
        int same=n+m- hs.size();

       System.out.println(n+m-2*same);
           

   } 
}
