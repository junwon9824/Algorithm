import java.io.*;
import java.util.*;
 
public class Main {
   public static void main(String[] args) throws IOException {
       
      // StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());

       
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken()); 
       int []a=new int[N]; 
       int []b=new int[N]; 
       int [] diff=new int[N]; 

       for(int i=0;i<N;i++){
           String [] str=br.readLine().split(" ");
           a[i]=Integer.parseInt(str[0]);
           b[i]=Integer.parseInt(str[1]);
           diff[i]= a[i]-b[i];
           
       }

        
       

       Arrays.sort(diff);
        int size=diff.length;

       int res=0;
              // System.out.println(   size );
              // System.out.println(   diff[size/2 ]+" "+diff[size/2-1 ] );
       
       if(size%2==0){
            res = diff[size/2 ]-diff[size/2-1 ];
              System.out.println(  res+1 );
           
       }

       if(size%2==1){
          System.out.println(   1 );
            
           
       }


 
       
       
//1 3 4 -- 
       // 3 -- 2 0 1 --- 3
        // 4 -- 3 1 0 -- 4
       // 2 -- 1 1 2 --- 4
       

       // -4 -3 1 2
       // 3 -- 1 0 4 5 ---10
       // 1 -- 3 2 2 3 --- 10
//-1 --- 5 4 0 1 ---10       
       
       
       // 5 3 2 1
       
        // 3 --2 0 1 2 -- 5
        // 2 --3 1 0 1 -- 5

       
       // 5 4 2 1

       // 3 ---2 1 1 2 --6 
       // 4 ---1 0 2 3 --6 
       // 2 ---3 2 0 1 --6 

       
       // -1 -- 0 4 3 --- 7
           // -2    1 3 2 --- 6
           // -3    2 2 1 --- 5
           // -4    1 0 3 --- 4
           // -5    0 1 4 --- 5
           
               

   }
}