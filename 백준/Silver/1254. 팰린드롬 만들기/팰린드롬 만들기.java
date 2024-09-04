import java.io.*;
import java.util.*;
import java.math.*;
 
public class Main {
   public static void main(String[] args) throws Exception {
       
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String str=br.readLine();

       String a=  (str);
      int res=a.length();
       
            for(int i=0;i<=a.length()-1;i++){
                   // System.out.println(  i+" "+valid(a.substring(i) ) );
                
                if(valid(a.substring(i) )){
                   // System.out.println(  i );
                    
                    break;
                }
                res++;
            }
 
       
       // abb
       // cab
        // abcde       
        // abbae       
        // aeeee a       
       
       System.out.println(  res );
       
   }
    static boolean valid(String s){
        int left=0;
        int right=s.length()-1;

        while(left<=right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
                
            }

            else
                return false;
        }

        return true;
        
    }
    
}