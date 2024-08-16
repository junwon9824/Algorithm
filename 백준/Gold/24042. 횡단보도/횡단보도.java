import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n,m;
        String []str=br.readLine().split(" ");

        n=Integer.parseInt(str[0]);
        m=Integer.parseInt(str[1]);
        
        ArrayList <int []> [] list=new ArrayList[n+1];

        for(int i=0;i<=n;i++){
            list[i]=new ArrayList<>();
        }
        long []dis=new long[n+1];
        
        
        for(int i=1;i<=m;i++){
            
            str=br.readLine().split(" ");
           int a=Integer.parseInt(str[0]);
           int b=Integer.parseInt(str[1]);
            
            list[a].add(new int[]{b,i});
            list[b].add(new int[]{a,i});
            
            // System.out.println( str[1] );
            
        }
        
         PriorityQueue  <long []> q=new  PriorityQueue<>( (a,b)->Long.compare( a[1] , b[1]) );
 
         // Queue <long []> q=new  LinkedList<>( );

        
        Arrays.fill(dis,Long.MAX_VALUE);
        dis[1]=0;

        q.add(new long[]{1L,0L});
        
        
        while(!q.isEmpty()){
            
            long []v=q.poll();
            int cur=(int)v[0];
            long temp=v[1];

            if(cur==n)break;
            
            for(int []s: list[cur]){
                
                  if( temp %m < s[1] ){
                        if(dis[s[0]]>  temp+Math.abs( (temp%m)-s[1] ) ) {
                            dis[s[0]]=temp+Math.abs( (temp%m)-s[1] );
                            q.add(new long[]{ s[0] ,dis[s[0]] });
                            // System.out.println(" "+cur+" "+s[0]+" "+temp+" "+s[1]+" "+dis[s[0]]);

                        }
                    }
                
                    if( temp %m >s[1] ){
                          if(dis[s[0]]> temp+ Math.abs( (temp%m)-m) +s[1] ){
                            dis[s[0]]=temp+ Math.abs( (temp%m)-m) +s[1] ;
                            q.add(new long[]{ s[0] ,dis[s[0]] });
                          // System.out.println(" "+cur+" "+s[0]+" "+temp+" "+s[1]+" "+dis[s[0]]);

                          }
                    }

                
                
                // if(dis[s[0]]> temp+s[1] ){
                //     System.out.println(" "+cur+" "+s[0]+" "+temp+" "+s[1]+" "+dis[s[0]]);
                //     q.add(new long[]{ s[0] ,dis[s[0]] });
                // }
                
            }
            
        }
        
        System.out.println( dis[n] );

	}

}