import java.io.*;
import java.util.*;

public class Main {
    
        static boolean []prime;
        static int [] cnt;
    
	public static void main(String[] args) throws Exception {

		// TODO Auto-generated method stub
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int a,b;

        String [] str=br.readLine().split(" ");
        
        a = Integer.parseInt( str[0]) ; 
        b = Integer.parseInt( str[1]) ; 

         prime=new boolean[b+1];
         cnt=new int[b+1];

        int res=0;
         
         for(int i=2;i<=b;i++){
              prime[i]= sosu(i);
         }

        // cnt[2]=1;
        // cnt[3]=1;

        
         for(int i=2;i<=b;i++){

             
            int idx=i;
             
            if(!prime[i] ){
                // cnt[i]=1;
                continue;
            }

             for(int j=i;j<=b ;j +=i){
                int tmp=j;
                 
                while( tmp%i==0 )  {
                    tmp=tmp/i;
                    cnt[j]++;
                    
                  // System.out.println ( i+" cc " + " "+j+  " "+idx);
                    
                 }
                 
             }
                 
            }

        
        
         for(int i=a;i<=b;i++){

             int num=cnt[i];
              // System.out.println ( i+" under " +num);
             
            if(prime[num] ){
                res++;
            }

             
         }
        
      System.out.println ( res);
        
	}

    // static boolean under(int a){

    //     if( sosu(prime[a]) )
    //         return true;
        
    //     return false;
        
    // }

    // static int  soinsu(int a ){

    //     Queue<Integer> q=new LinkedList<>();
    //     int cnt=0;

    //     q.add(a);
        
    //     while(!q.isEmpty())
    //     {
    //         int v=q.poll();
            
    //         for(int i=2;i<=v;i++){
                
    //             if(sosu(i)&& v%i==0)
    //             {
    //                   // System.out.println ( a+" sosu "+i+" "+sosu(i));
                    
    //                 q.add(v/i );
    //                 cnt++;
    //                 break;
    //             }
                
    //         }
    //     }
        
    //   // System.out.println ( a+" ccc "+cnt);
            
    //     return cnt;
        
    // }

    static boolean sosu(int a){ //소수여부 판별
        int cnt=0;
        
        if(a==1)
        return false;
        
        for(int i=2;i<=Math.sqrt(a) ;i++)
        {
            if( a%i ==0)
                cnt++;
            
        }

        if(cnt==0)
        return true;

        else
        return false;
        
    }

}
