import java.io.*;
import java.util.*;

public class Main {

        static int   []arr ;
        static int   []res ;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           
        int n,c;
 
            String []str=br.readLine().split(" ");
              n=Integer.parseInt(str[0]);

        arr= new int[n];
        res= new int[n ];
        
       str=br.readLine().split(" ");

        Queue<int []>q =new LinkedList<>();
        
        for(int i=0;i<n ;i++){
            arr[i]=  Integer.parseInt(str[i]);
            q.add(new int[]{i,arr[i]});
            
        } 

        int time=1;
         

        while(!q.isEmpty()){
            int []v=q.poll();
            
             if(v[1]>0)
            {
                v[1]--; 
                if(v[1]==0) res[v[0]]=time;
                else q.add(new int[]{v[0],v[1]});
                time++;
                
            }

        }
        
          for(int i=0;i<n ;i++){
            System.out.print(res[i]+" ");
        } 
        
// 4
// 1 3 1 4

	} 

}