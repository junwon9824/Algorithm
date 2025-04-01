import java.util.*;
import java.io.*;

// 33664
public class Main{
    
    
	public static void main(String[] args) throws IOException{

        int cnt=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
        
        String []str=br.readLine().split(" ");
        
		long b=Long.parseLong( str[0]); //price
        
		int n=Integer.parseInt( str[1]);
		int m=Integer.parseInt( str[2]);

        HashMap<String,Long> map=new HashMap<>();
        
        for(int i=0;i<n;i++){
           str=br.readLine().split(" ");
            map.put( str[0], Long.parseLong(str[1]) );
        }
        
        long res=0;
        
		
        for(int i=0;i<m;i++){
           str=br.readLine().split(" ");
            
            if(map.containsKey( str[0]) )
                res+= map.get(str[0]);    
            // else
            //     System.out.println(map.get(str[0]));
            
            //     int v=1+ "NULL";
            //     System.out.println( v );
                
        }

        if(res<= b)
            System.out.println( "acceptable");
            
        else
            System.out.println( "unacceptable");
        

	}
      


    
}