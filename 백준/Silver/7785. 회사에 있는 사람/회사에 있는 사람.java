import java.util.*;
import java.io.*;

// 14425
// 슬라이딩윈도우
public class Main{
    
    
	public static void main(String[] args) throws IOException{

        int cnt=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();

        
        String []str=br.readLine().split(" ");
		int n=Integer.parseInt( str[0]);

        HashMap<String,Integer> map = new HashMap<>();

        
        for(int i=0;i<n;i++){
             str=br.readLine().split(" ");

            if(str[1].equals("enter") ) {
                map.put( str[0],map.getOrDefault(str[0],0)+1   );
                
            }
                
            else{
                map.put( str[0],map.getOrDefault(str[0],0)-1  );
                 
            }
        }

        PriorityQueue<String> pq=new PriorityQueue<>( (a,b)->{
            return b.compareTo(a);
            
        });
        
        for(Map.Entry <String,Integer> entryset : map.entrySet() ){
            if(entryset.getValue()==1  )
            {
                pq.add( entryset.getKey());
            }

        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll()  );
            
        }

		

	}
      


    
}