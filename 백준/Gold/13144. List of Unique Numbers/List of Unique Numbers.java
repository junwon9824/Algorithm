import java.io.*;
import java.util.*; 


public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); 
         int n=Integer.parseInt(str);
        int []su=new int[n];
        
        String []str2 = br.readLine().split(" "); 
        
        for(int i=0;i<n;i++){
            su[i]=Integer.parseInt(str2[i]);
        }
        
        //슬라이딩 윈도우
        long cnt=0;
        
        // for(int i=0;i<n;i++){
        //       int s= su[i];
            
        //     // cnt++;
            
        // }
        
        int s=0;
        int e=0;
        HashSet<Integer> hs = new HashSet<>();
        
        while(s<n ){

            while(e<n&& !hs.contains( su[e])  ){
               // System.out.println( s+" while "+e+" "+cnt);
                hs.add( su[e++]);
            }
                cnt+=e-s;
            
            // System.out.println( s+" "+e+" "+cnt);

            hs.remove(su[s]);

            s++;
        }
        
       System.out.println(cnt);
        
    }
     
}
