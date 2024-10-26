import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
      
      BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
      
      String []str= br.readLine().split(" ");
      
      int n=Integer.parseInt(str[0] );

        int []arr=new int[ n];

        str=br.readLine().split(" ");
        
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(str[i]);
                
        }

        int len=0;
        

        // int []tmp=new int[n];
        int []lis=new int[n];


    
        for(int i=0;i<n;i++){

            int left=0;
            int right=len;
                
            int v=arr[i];
                // System.out.println("iii "+v);
            
            while(left<right){
                int mid=(left+right)/2;
    
                if( lis[mid]  < v){
                    left=mid+1;
                }
                else{
                    right=mid;
                }
                // System.out.println("while "+i+" "+mid);
                
            }

            if(left==len){
                // System.out.println("ll"+len);

                lis[len]=v;
                len++;
            }
            else{
                lis[left]=v;
            }
        }
        

        
        System.out.println(len);
        

        
        
  }
  
  
}