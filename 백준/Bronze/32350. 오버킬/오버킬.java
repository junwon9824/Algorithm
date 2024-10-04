 
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int cnt=0;

    public static void main(String[] args) throws Exception{

        BufferedReader brr=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int n=0;
        int d=0;
        int p=0;
        
        String []str=brr.readLine().split(" ");

        n=Integer.parseInt(str[0]);
        d=Integer.parseInt(str[1]);
        p=Integer.parseInt(str[2]);

        str=brr.readLine().split(" ");

        int []arr=new int[n];
        
        for(int i=0;i<n ;i++){
            arr[i]=Integer.parseInt(str[i]);

        }

        
        for(int i=0;i<n ;i++){
            int hp= arr[i];
            
             while(hp>0){
                hp-= d;
                 cnt++;
                // System.out.println ( " ppp "+(i)+" "+hp);
                 
            }

                
            hp=Math.abs(hp);
            //hp 15프로
            hp=(int)(hp*p/100*10/10);
            // System.out.println ( "15%%%% "+hp+" i "+i+" "+cnt);
            
            if(i<n-1)
            arr[i+1]-= hp;

            if(i<n-1&&arr[i+1]<=0)
            {
                // System.out.println ( " skip "+(i+1)+" "+cnt);
                i++;
            }
            
            // System.out.println ( hp+" i "+i+" "+cnt);
            
        }

        
        System.out.println ( cnt);
        
    }
}