import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
        static int cnt=0;
        static int n,m,k,x,y,w,s;
        
    public static void main(String[] args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String [] str=br.readLine().split(" ");
                int a,b;
        a=Integer.parseInt(str[0]);
        b=Integer.parseInt(str[1]);

        Queue<int []> q=new LinkedList<>();

        q.add(new int[]{ a*b});
        int cnt=0;

        while(!q.isEmpty()){
            int []v=q.poll();

            if(v[0]==1)continue;
            
            if(v[0]%2==0) 
            {
                for(int i=0;i<2;i++)
                    q.add(new int[]{ v[0]/2});
            }

            else{ //홀수
                    q.add(new int[]{ v[0]/2});
                    q.add(new int[]{ v[0]/2+1});





            }
            
            cnt++;
        }

        
        System.out.println( cnt );
        
    }
     
 
}