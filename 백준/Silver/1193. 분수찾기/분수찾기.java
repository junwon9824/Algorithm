import java.io.*;
import java.util.*;
 
public class Main {
      static int x=0; 
    
   public static void main(String[] args) throws IOException {
       
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken()); 

       // n 10의 4승 0부터
       // n*(n+1)/2 > x 

       int left=0;
       int right=(int)Math.pow(10,4);
        int tmp=0;
       
       
       while(left<right){
           
           int mid =(int) ( left+right)/2;

           if( (mid)*(mid+1)/2 >= x ){ // 작다는소리 x 가 더 크거나 같아야한다.
              if(right==mid)break;
                  right=mid;
           }
           else{
                 if(left==mid)break;
               left=mid;
                
           }
           
       }
           
       // System.out.println(left);

       int idx = x-left*(left+1) /2;
    // 1/5
       int rear=left+1 -idx+1;


       if(left%2==0)
       System.out.println(rear+"/"+idx);

       else
       System.out.println(idx+"/"+rear);
       
       
               
   }
 

    
}