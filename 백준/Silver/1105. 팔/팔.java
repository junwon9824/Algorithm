import java.io.*;
import java.util.*;

public class Main {
 
	public static void main(String[] args) throws Exception {

		// TODO Auto-generated method stub
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n,m,k,x,y;

        String l,r;

        String [] str=br.readLine().split(" ");
        l= str[0];
        r= (str[1]);
        int res=0;
        
          // System.out.println ( l.length());

        if( l.length() !=r.length() ){
          // System.out.println ( 0);
            // return;
            
        }

        else{
            
            if(l.length()== r.length() )
            {
                // 108 908

          // System.out.println ( "bb"+ r.length());

                for(int i=0;i<r.length();i++)
                    {

                            
                        if(l.charAt(i) !=r.charAt(i))
                        {
          // System.out.println ( "brea");
                            break;
                            
                        }
                        else if( l.charAt(i)=='8' ){
                            res++;
                        }

                    }

                
                    // 888 889 2
                // 808 888 1
                // 188 189  1
                // 188 188  2
                // 188 198  0
                // 108 118  0

                
            }
                
            else{
                // 888 1000

            }
        }
        

      
      System.out.println ( res);
        
      

	}

    static int check(String a){
        String s= String.valueOf(a);
        int cnt=0;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='8')
                 cnt++;
            
        }
        return cnt;
        
    }

}
