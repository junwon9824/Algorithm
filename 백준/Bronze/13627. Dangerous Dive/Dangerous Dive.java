import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           
        int n,c;
 
            String []str=br.readLine().split(" ");
              n=Integer.parseInt(str[0]);
              c=Integer.parseInt(str[1]);

        PriorityQueue<Integer> pq=new PriorityQueue<>();
       str=br.readLine().split(" ");
        // int []arr=new int[c];
        boolean []visit=new boolean[n+1];
        ArrayList<Integer> list=new ArrayList<>();
        
        for(int i=0;i<str.length;i++)
        {
            int a= Integer.parseInt(str[i]);
            visit[a]=true;
        }

        Collections.sort(list);

        int idx=0;
        
        for(int i=1;i<=n;i++)
        {
            if( visit[i]==false ){
                pq.add(i);
            }
              
        }
        
        for(int v:pq)
        System.out.print(v+" "  );

        if(pq.isEmpty())
        System.out.print( "*"  );

	}

}