import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
        static int []x,y;
        static boolean []visit;
        static int cnt=0;
            static int n,m,k;
    
    public static void main(String[] args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String [] str=br.readLine().split(" ");
        
        n = Integer.parseInt( str[0] );
        
        x  =new int[n];
        y  =new int[n];

        for(int i=0;i<n ;i++){
            str=br.readLine().split(" ");
            x[i]=Integer.parseInt(str[0]);
            y[i]=Integer.parseInt(str[1]);
            // System.out.println(x[i]+"xx"+y[i]);
            
        }

        int sum=0;
        
        for(int i=0;i<n-1 ;i++){
            sum+=dis(i,i+1);        
        }

        int min=Integer.MAX_VALUE;
        for(int i=1;i<n-1 ;i++){
            int tmp=sum;

            tmp+= dis(i-1,i+1);
            tmp-= dis(i-1,i);
            tmp-= dis(i,i+1);
            
            // System.out.println(i+"ss"+tmp);
            min=Math.min(tmp,min);
            
        }

        
        System.out.println(min );
        
    }

    static int dis(int i,int j){
        
        return   Math.abs( x[i]-x[j])+Math.abs( y[i]-y[j]) ;
        
    }
 
     
 
}