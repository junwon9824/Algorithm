import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[]arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        
        n = Integer.parseInt(str[0]);

        arr=new int[6];
        
        str = br.readLine().split(" ");

        for(int i=0;i<6;i++)
            arr[i]=Integer.parseInt( str[i] );

        // 맨밑부터 끝까지

            
        long res =0 ;

        res = number();
        System.out.println( res  );
        
    }

    static long number(  ){
        long v=0;
        int max = 0;
        
        if(n==1)
        {
            for(int i=0;i<6;i++)
                {
                    max =Math.max(max, arr[i]);            
                    v+=arr[i]  ;
                }
           
                v-= max;
            return v;
            
        }
         

        int [][]two = { {0,1},{0,2} ,{0,3} , {0,4} ,{1,2},{1,3},{1,5} ,{2,4},{2,5},{3,4},{3,5} ,{4,5}};
      int[][] triples = { {0,1,2}, {0,2,4}, {0,3,4}, {0,1,3}, {5,1,2}, {5,2,4}, {5,3,4}, {5,1,3} };
        
//             +---+        
//     | D |        
// +---+---+---+---+
// | E | A | B | F |
// +---+---+---+---+
//     | C |        
//     +---+   
        long min2 =Long.MAX_VALUE;
        long min3 =Long.MAX_VALUE;
        long min1 =Long.MAX_VALUE;
        
         for(int i=0;i<6;i++)
        {
            min1 =Math.min(min1, arr[i]);            
            // v+=arr[i]  ;
        }
           
        for( int []s:two){
            int a = arr[s[0]];
            int b = arr[s[1]];
            min2=Math.min(min2,a+b);
            
        }
        
        // n>=2 일떄 밑에는 {개당 두칸 *4,  개당  한칸 * (n -2 ) * 4 } *(n-1), 
        //맨 위에는 개당 세칸 *4 , 개당 두ㅏ칸* (n-2)  *4 ,
        
        // 개당 한칸 * (n-2)*(n-2) 
         for( int []s:triples){
             
            int a = arr[s[0]];
            int b = arr[s[1]];
            int c = arr[s[2]];
            min3=Math.min(min3,a+b+c);
        }
        
         v+= ((min2*4 +  min1*(n-2)*4) *(n-1)) +  ( ( min3)*4 + min2* (n-2)*4 + min1 * Math.pow( n-2 ,2 ) );
        
        
        return v;
       
    }
 


    
}
