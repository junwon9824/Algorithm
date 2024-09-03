import java.io.*;
import java.util.*;
 
public class Main {
   public static void main(String[] args) throws IOException {
       
      // StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
       
      int N = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      int T = Integer.parseInt(st.nextToken());
      int R = Integer.parseInt(st.nextToken());
 
         // N, m, M, T, R

       int work=0;
       int tmp=m;
       int time=0;
       
       while(work<N){

           
           if(tmp+T<=M) 
           {
               
           tmp+= T;
          // System.out.println("add "+tmp);

               work++;
           }

           else{


               if(tmp==m)
               {
                   
                   time=-1;
               break;
               }
               
               tmp-=R;
               if(tmp<m)
                   tmp=m;
          // System.out.println("--"+tmp);

               
           }
           
           time++;
       }

 
      System.out.println(time);
       
   }
}