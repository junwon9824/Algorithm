import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
        static int []arr;
        static boolean [][]pelin;
        static boolean [][]visit;
    
        static int cnt=0;
        static int n,m,k;
        
    public static void main(String[] args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String [] str=br.readLine().split(" ");
                
        n = Integer.parseInt( str[0] );
                //System.out.println(n );
        
        arr=new int [n];
        pelin=new boolean [n][n];
        
        str=br.readLine().split(" ");
        
        for(int i=0;i<n ;i++){
            arr[i]=Integer.parseInt( str[i] );
                // System.out.println(arr[i]);

        }

        
        for(int i=0;i<n ;i++){ //start
                pelin[i][i]= true;
            
        }

        for(int i=n-2;i>=0 ;i--){ //start
            for(int j=i+1;j<n ;j++){
 
                if(j-i==1){
                    if(arr[i]==arr[j])
                    pelin[i][j]= true;
                }
                    
                else{
                     if(arr[i]==arr[j] && pelin[i+1][j-1]  )
                        pelin[i][j]= true;
                }
                
                // System.out.println(i+" "+j+" "+  pelin[i][j] );
                
            }
        }
 
        
        str=br.readLine().split(" ");
        int m = Integer.parseInt( str[0] );
            // System.out.println(  m);

         for(int i=0;i<m ;i++){
            str=br.readLine().split(" ");
            int s =Integer.parseInt( str[0] );
            int e =Integer.parseInt( str[1] );
            // System.out.println(  s+" "+e);
             
            sb.append( pelin[s-1][e-1]==true?1:0).append('\n');


        }


            System.out.println(  sb.toString() );
        
    }
     
 
}