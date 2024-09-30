import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
        static int cnt=0;
        
    public static void main(String[] args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

            String [] str=br.readLine().split(" ");
            int n,t;
        
            n=Integer.parseInt(str[0]);
             int  []tmp=new int[n];

        long  sum=0;
        
        for(int i=0;i<n;i++){
             tmp[i]=Integer.parseInt(  br.readLine());
        }
        Arrays.sort(tmp);
        
        for(int i=1;i<=n;i++){
            sum+= Math.abs(tmp[i-1]-i);
        }

        System.out.println( sum);
        
    }
     
     
 
}