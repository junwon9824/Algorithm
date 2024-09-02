import java.io.*;
import java.util.*;
 
public class Main {
   public static void main(String[] args) throws IOException {
       
      StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
      int N = Integer.parseInt(st.nextToken());
      int L = Integer.parseInt(st.nextToken());
      int W = Integer.parseInt(st.nextToken());
      int H = Integer.parseInt(st.nextToken());
 
      double low = 0;
      double high = Math.min(L,Math.min(W,H));
      double mid;
       double tmp=0;
      while(low<=high){
         mid = (low+high)/2;
         tmp=mid;
         if((long)(L/mid)*(long)(W/mid)*(long)(H/mid)<N){ //불가..ㅂ
            if(high==mid) break;
            high = mid;
         }
         else{ //가능..
            if(low==mid) break;
            low = mid;
         }
          
      }
      System.out.println(low);
       
   }
}