import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str =  br.readLine();

            int one=0;
            int zero=0;
            int size=str.length();
            // System.out.println(str+" " );
        
            for( int i=0;i<str.length();i++){
                if(str.charAt(i)=='1' ){
                    one++;
                }
                    
                 else if(str.charAt(i)=='0' ){
                    zero++;
                }
            }
        
            ArrayList<Character> list=new ArrayList<>();
            // System.out.println(zero+" "+one);

        int none=one;
        int nzero=0;
        
             for( int i=0;i<str.length() ;i++){
            // System.out.println("nzero"+nzero );
            // System.out.println("none"+none );
                 
                if(str.charAt(i)=='1'&& none>one/2 ){
                   // list.add( );
                    none--;
                }
                 else if(str.charAt(i)=='1'&& none<=one/2 ){
                   list.add('1' );
                }
                     
                else if(str.charAt(i)=='0'&& nzero<zero/2 ){
                   list.add('0' );
                    nzero++;
                }
                
            }


            for(char ch:list )
            System.out.print(ch );
        
    }


    
}
