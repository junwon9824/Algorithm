import java.util.*;
import java.io.*;

 
public class Main {
 
	public static void main(String[] args) throws Exception{

        
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

		int n= Integer.parseInt(br.readLine());

        int []x=new int[ n];
        int []y=new int[ n];

        
        for(int i=0;i<n;i++){
            
    		String [] str =  br.readLine().split(" ");
            x[i]=Integer.parseInt(str[0]);
            y[i]=Integer.parseInt(str[1]);
        
        }

        double max=0;
        
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                     double sum= 0.5*( Math.abs(( x[i]*y[j]+x[j]*y[k]+x[k]*y[i] )-(x[i]*y[k]+x[j]*y[i]+x[k]*y[j]))  );
                     // System.out.println(sum+" ss");
                    
                    max=Math.max(max, sum );
                }
            }
        
        }
        
         System.out.println(max);

          
        
	}
}