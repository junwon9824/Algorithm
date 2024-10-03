 
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int cnt=0;

    public static void main(String[] args) throws Exception{

        BufferedReader brr=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        String []res=brr.readLine().split(" ");
        int ar=0;
        int ac=0;
        ar=Integer.parseInt(res[0]);
        ac=Integer.parseInt(res[1]);
          res=brr.readLine().split(" ");
        
        int br=0;
        int bc=0;
        
        br=Integer.parseInt(res[0]);
        bc=Integer.parseInt(res[1]);

        if( 0==ar&& 0!=br){
             System.out.println( 1);
                
        }
 
        else if( 0==ac && 0!=bc){
             System.out.println( 1);
            
        }
        
        else if(br!=ar&&ac!=bc){
             System.out.println( 2);
            
        }
         else if(br==ar&&ar==0 ){
             if(ac>bc)
             System.out.println( 3);
            else
             System.out.println( 1);
                 
        }
          else if(bc==ac&&ac==0 ){
              if(ar>br)
             System.out.println( 3);
            else
             System.out.println( 1);
            
        }
            
         else 
         System.out.println(  2);
 

    }



}