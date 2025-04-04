import java.util.*;
import java.io.*;

// 33710
public class Main{
    static int min=100;
    
	public static void main(String[] args) throws IOException{

        
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
        // I,T 에 비장의 일격
        
        String []str=br.readLine().split(" ");
        
		int n=Integer.parseInt( str[0]);
		int k=Integer.parseInt( str[1]);
        
        str=br.readLine().split(" ");

        solve(str[0], 0);
        // System.out.println(min);
        // System.out.println(str[0]);
        System.out.println(min==100? str[0].length(): min );
        

	}

    static void solve(String str, int d   ) {

        int start=0;
        int len=str.length();

        if(d>=2){
           // System.out.println("return "+"d "+d);
            return;
        }
        
       // System.out.println ( len);
        
        for(int i=0;i<len;i++){
            
             for(int j=i+1;j<len ;j++){
                StringBuilder sb=new StringBuilder();
                 
                if( str.charAt(i)==str.charAt(j) && str.charAt(i)!='X' )
                {
                    sb.append(str.substring(0,i));
                    sb.append(str.substring(j+1,len));
                    int tmp= len- (j-i+1);
                    min=Math.min(min,tmp );
                     // System.out.println ( "i"+i+" j "+j+" str.charAt(i) "+str.charAt(i) + " tmp "+ tmp +" str "+ str 
                                          // +"len"+len );
                    solve( sb.toString(), d+1  );
                    
                }

             }
            
        }

        
    }
      


    
}