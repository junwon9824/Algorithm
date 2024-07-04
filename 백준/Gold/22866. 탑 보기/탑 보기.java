
import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        int n = Integer.parseInt(line);
 
        String[] str = br.readLine().split(" ");

        ArrayList<Integer> list=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            list.add(Integer.valueOf(str[i]) );
        }
         
        int []cnt=new int[ n];
        int []near=new int[ n];
        
        Deque<int[]> q=new LinkedList<>();
        
        q.add(new int []{ list.get(0),1} );
        
        if(list.size()>=2&& list.get(0)<list.get(1) )
            near[0]= 2 ;
            
        for(int i=1;i<n;i++){
            //left
            //  System.out.println(i+" "+"cc " +cnt[i] );

            while(!q.isEmpty()&& list.get(i) >= q.peekLast()[0] ){
                q.pollLast();
            }
            
            if( !q.isEmpty() )
                near[i]=q.peekLast()[1];
            
            cnt[i]=q.size();
            
            // if(!q.isEmpty())
             // System.out.println(i+" "+list.get(i)+" cc " +cnt[i]+" "+ q.peekLast()[0] );
             // System.out.println(i+" "+list.get(i)+" cc " +cnt[i]+"  ");

            q.add(new int[]{ list.get(i), i+1 } ); 
        }
        
 
         q=new LinkedList<>();
         
         q.add(new int [] { list.get(list.size()-1) , list.size() } );


         for(int i=n-2;i>=0;i--){    //right
            
            while(!q.isEmpty()&& list.get(i) >= q.peekLast()[0] ){
                q.pollLast();
            }
             
              // if( !q.isEmpty())
             // System.out.println("i"+i+" "+near[i]+" beff "+q.peekLast()[1] );

            if( !q.isEmpty()&& (Math.abs(q.peekLast()[1] -(i+1) ) < Math.abs(near[i] -(i+1 )) || near[i]==0 )){

                 // System.out.print(near[i]+" nn "+q.peekLast()[1] );

                near[i]=q.peekLast()[1];
            }
             
            cnt[i]+=q.size();

            q.add(new int[]{ list.get(i),i+1 } ); 
            
        }
        
        for(int i=0;i<n;i++){
            
            if(cnt[i]==0)
             System.out.println(0);

            else{
             System.out.print(cnt[i]+" " );
             System.out.println(near[i] );
            }
            
        }
  
    }
    
    
}

