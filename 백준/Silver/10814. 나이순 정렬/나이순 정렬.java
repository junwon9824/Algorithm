import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
      
      BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
      
      String []str= br.readLine().split(" ");

      int t=Integer.parseInt(str[0] ); 
        
        ArrayList <String[]> list=new ArrayList<>();
        
       

        for(int i=0;i<t;i++){
             str= br.readLine().split(" ");
            String a=str[0];
            String b=str[1];
            list.add(new String[]{a,b});
        }
         Collections.sort(list,(a,b)->{
            int na=Integer.parseInt(a[0]);
            int nb=Integer.parseInt(b[0]);
            
            if( na!=nb){
                return Integer.compare( na,nb);
            
            }
            
            return 0;
            
        });
        
        for(int i=0;i<list.size();i++) {
            String []s=list.get(i);
            
            System.out.println(s[0]+" "+s[1] );
        }
        
  }
  
  
}