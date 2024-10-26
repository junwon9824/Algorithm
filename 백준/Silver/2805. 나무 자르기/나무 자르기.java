import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String [] str =br.readLine().split(" ");
        
        int n=Integer.parseInt(str[0] );
        int m=Integer.parseInt(str[1] );
        
        int []arr=new int[n ];

         str =br.readLine().split(" ");
        
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(str[i]);
        }
        
         int left=0;
        int right=(int)Math.pow(10,9);
        int res=0;

        while(left<=right){
            
            int mid=  (left+right)/2;
            // System.out.println(mid+" left "+left+ " right " +right+" "+leftover(mid,arr));
            
            if(m ==leftover(mid,arr)){
                res=mid;
                break;
            }
            else if(m < leftover(mid,arr)){
                res=mid;
                left=mid+1;
            }
            else if(m > leftover(mid,arr)){
                right=mid-1;
            }
            
        }
        
        System.out.println(res );
    }

    static long leftover(long m,int []arr){
       long sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>m)
               sum+=  arr[i]-m;
       }
        return sum;
    }
 
}