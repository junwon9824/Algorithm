import java.util.*;
import java.io.*;

public class Main {
    
      static  int []arr;
      static int n=0;
      static int max=1000000;
      static  ArrayList<Integer> list = new ArrayList<>();
      static boolean []prime=new boolean [1000000+1];
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(prime,true);
        eratos();
        
        while(true )
        {
            String [] str= br.readLine().split(" ");
        
            // 첫 번째 줄에서 N 입력 받기
            n = Integer.parseInt(str[0] );
            if(n==0)break;
            
            solve(n);
        }
        
    }

    static void eratos(){
        
        for(int i=2 ; i <=Math.sqrt( max)  ; i++){
             for(int j=i*i ; j<=max ;j+=i){
                prime[j]=false;
            }
        }
        
    }

    static void solve(int n ){

        int first = 3;
        int last  = n-3;

        while( !prime[first] || !prime[last])
        {
            // System.out.println( first +" "+last+" "+prime[first]+" "+prime[last]  );
            
            first++;
            last--;
        }
        
        System.out.println( n +" = "+first +" + "+last  );
        
        return;
        
    }

    
}
