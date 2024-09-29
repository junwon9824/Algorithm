import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
        static int cnt=0;
        static int n,m,k,x,y,w,s;
        
    public static void main(String[] args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String [] str=br.readLine().split(" ");
                int a,b;
        a=Integer.parseInt(str[0]);
         
        str=br.readLine().split(" ");
        b=Integer.parseInt(str[0]);
        
        System.out.println( a+b  );
        
    }
     
 
}