import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           
        int n;
 
        n=Integer.parseInt( br.readLine());
        ArrayList<Integer> list=new ArrayList<>();

        int min=Integer.MAX_VALUE;
        int max=0;
        
        
        for(int i=0;i<n;i++){
            
            int x=Integer.parseInt( br.readLine());
            list.add(x);
            min=Math.min(min, x);
            max=Math.max(max, x);
        }

        int sum=Integer.MAX_VALUE;
        
         for(int i=min;i<max-17;i++){

             int tmp=0;

             for(int v: list){
                if( v < i ){
                    tmp+=Math.pow( v-i ,2);
                }
                 
               if( v > i+17 ){
                    tmp+=Math.pow( v-i-17 ,2);
                                
                }
                 
             }
             // System.out.print )
             sum=Math.min(sum, tmp);
            
        }

        if(sum==Integer.MAX_VALUE){
            System.out.println( 0 );
            return;
        }

// 5
// 21
// 20
// 1
// 1
// 20
        
        System.out.println( sum );

	}
 
    

}